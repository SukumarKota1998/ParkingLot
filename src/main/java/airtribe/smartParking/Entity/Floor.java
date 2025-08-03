package airtribe.smartParking.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Floor {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "floor")
    private List<Spot> spots;

    private Boolean isUnderMaintenance;

    @ManyToOne
    private Lot lot;

    public Floor(Long id, List<Spot> spots, Boolean isUnderMaintenance, Lot lot) {
        this.id = id;
        this.spots = spots;
        this.isUnderMaintenance = isUnderMaintenance;
        this.lot = lot;
    }

    public Floor() {
        // Default constructor
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Spot> getSpots() {
        return spots;
    }

    public void setSpots(List<Spot> spots) {
        this.spots = spots;
    }

    public Boolean getUnderMaintenance() {
        return isUnderMaintenance;
    }

    public void setUnderMaintenance(Boolean underMaintenance) {
        isUnderMaintenance = underMaintenance;
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }
}
