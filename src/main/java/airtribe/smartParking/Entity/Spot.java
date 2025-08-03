package airtribe.smartParking.Entity;

import jakarta.persistence.*;

@Entity
public class Spot {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private SpotType spotType;

    private Boolean isOccupied;

    @OneToOne(mappedBy = "spot")
    private VehicleTransactions vehicle;

    @ManyToOne
    private Floor floor;

    public Spot(Long id, SpotType spotType, Boolean isOccupied, VehicleTransactions vehicle, Floor floor) {
        this.id = id;
        this.spotType = spotType;
        this.isOccupied = isOccupied;
        this.vehicle = vehicle;
        this.floor = floor;
    }

    public Spot() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    public Boolean getOccupied() {
        return isOccupied;
    }

    public void setOccupied(Boolean occupied) {
        isOccupied = occupied;
    }

    public VehicleTransactions getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleTransactions vehicle) {
        this.vehicle = vehicle;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }
}
