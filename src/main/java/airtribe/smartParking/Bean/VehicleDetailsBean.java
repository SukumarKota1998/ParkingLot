package airtribe.smartParking.Bean;

import airtribe.smartParking.Entity.VehicleType;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.lang.NonNull;

public class VehicleDetailsBean {

    private String vehicleRegistrationNumber;

    private VehicleType vehicleType;

    public VehicleDetailsBean(String vehicleRegistrationNumber, VehicleType vehicleType) {
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
        this.vehicleType = vehicleType;
    }

    public VehicleDetailsBean() {

    }

    @NonNull
    public String getVehicleRegistrationNumber() {
        return vehicleRegistrationNumber;
    }

    public void setVehicleRegistrationNumber(@NonNull String vehicleRegistrationNumber) {
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
    }

    @NonNull
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(@NonNull VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
