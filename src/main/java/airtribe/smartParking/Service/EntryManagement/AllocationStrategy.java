package airtribe.smartParking.Service.EntryManagement;

import airtribe.smartParking.Entity.Spot;
import airtribe.smartParking.Entity.VehicleType;

import java.util.List;
import java.util.Optional;

public interface AllocationStrategy {
    Optional<Spot> allocateSpot(List<Spot> spots, VehicleType vehicleType);
}
