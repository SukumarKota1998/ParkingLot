package airtribe.smartParking.Service.EntryManagement;

import airtribe.smartParking.Entity.Spot;
import airtribe.smartParking.Entity.SpotType;
import airtribe.smartParking.Entity.VehicleType;

import java.util.List;
import java.util.Optional;

public class NearestFirstAllocationStrategy implements AllocationStrategy{


    @Override
    public Optional<Spot> allocateSpot(List<Spot> spots, VehicleType vehicleType) {
        if (spots == null || spots.isEmpty()) {
            return Optional.empty(); // No available spots
        }
        return spots.stream().filter(spot -> !spot.getOccupied()
                        && getPreferredSpotType(vehicleType) == spot.getSpotType())
                .findFirst();
    }

    private SpotType getPreferredSpotType(VehicleType vehicleType) {
        return switch (vehicleType) {
            case CAR, VAN -> SpotType.MEDIUM;
            case BIKE -> SpotType.SMALL;
            case TRUCK, BUS -> SpotType.LARGE;
            default -> null;
        };
    }
}
