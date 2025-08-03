package airtribe.smartParking.Service.EntryManagement;

import airtribe.smartParking.Bean.SpotAllotment;
import airtribe.smartParking.Bean.VehicleDetailsBean;
import airtribe.smartParking.Entity.Lot;
import airtribe.smartParking.Entity.Spot;
import airtribe.smartParking.Entity.VehicleTransactions;
import airtribe.smartParking.Entity.VehicleType;
import airtribe.smartParking.Repository.LotRepository;
import airtribe.smartParking.Repository.SpotRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EntryManagement {

    private static final Logger LOGGER = LoggerFactory.getLogger(EntryManagement.class);

    @Autowired
    private SpotRepository spotRepository;

    @Transactional
    public SpotAllotment allotmentParkingSpot(VehicleDetailsBean vehicleDetails) {
        List<Spot> availableSpots = spotRepository.findByIsOccupiedFalse();
        if (availableSpots.isEmpty()) {
            LOGGER.info("No available parking spots for vehicle : {}", vehicleDetails.getVehicleRegistrationNumber());
            return null; // No available spots for the vehicle type
        }

        AllocationStrategy allocationStrategy = new NearestFirstAllocationStrategy();
        Spot allocatedSpot = allocationStrategy.allocateSpot(availableSpots, vehicleDetails.getVehicleType())
                .orElse(null);
        if (allocatedSpot == null) {
            LOGGER.info("No suitable parking spot found for vehicle : {}", vehicleDetails.getVehicleRegistrationNumber());
            return null; // No suitable spot found
        }

        VehicleTransactions vehicleTransactions = new VehicleTransactions();
        vehicleTransactions.setVehicleRegistrationNumber(vehicleDetails.getVehicleRegistrationNumber());
        vehicleTransactions.setVehicleType(vehicleDetails.getVehicleType());
        vehicleTransactions.setEntryTime(LocalDateTime.now());
        allocatedSpot.setOccupied(false);
        allocatedSpot.setVehicle(vehicleTransactions);
        Spot savedSpot = spotRepository.save(allocatedSpot);
        return new SpotAllotment(savedSpot.getVehicle().getId(), savedSpot.getFloor().getId(), savedSpot.getId());
    }
}
