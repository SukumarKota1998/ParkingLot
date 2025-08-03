package airtribe.smartParking.Entity;

import jakarta.persistence.*;

@Entity
public class FeeStandard {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @Enumerated(EnumType.STRING)
    private SpotType spotType;

    private Long hourlyRate;

    public FeeStandard(Long id, VehicleType vehicleType, SpotType spotType, Long hourlyRate) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.spotType = spotType;
        this.hourlyRate = hourlyRate;
    }

    public FeeStandard() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    public Long getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Long hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
