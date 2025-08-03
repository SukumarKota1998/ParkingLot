package airtribe.smartParking.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class VehicleTransactions {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)

    private Long id;

    private String vehicleRegistrationNumber;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    private LocalDateTime entryTime;

    private LocalDateTime exitTime;

    private double parkingFee;

    @OneToOne
    @JoinColumn(name = "spot", referencedColumnName = "id")
    private Spot spot;

    public VehicleTransactions(Long id, String vehicleRegistrationNumber, VehicleType vehicleType, LocalDateTime entryTime, LocalDateTime exitTime, double parkingFee) {
        this.id = id;
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
        this.vehicleType = vehicleType;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.parkingFee = parkingFee;
    }

    public VehicleTransactions() {
        // Default constructor
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleRegistrationNumber() {
        return vehicleRegistrationNumber;
    }

    public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public double getParkingFee() {
        return parkingFee;
    }

    public void setParkingFee(double parkingFee) {
        this.parkingFee = parkingFee;
    }
}
