package airtribe.smartParking.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.Map;

@Entity
public class Lot {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long Id;

    private String parkingLotName;

    private String location;

    private Long capacity;

    @OneToMany(mappedBy = "lot")
    private List<Floor> floors;

    public Lot(Long id, String parkingLotName, String location, Long capacity, List<Floor> floors) {
        Id = id;
        this.parkingLotName = parkingLotName;
        this.location = location;
        this.capacity = capacity;
        this.floors = floors;
    }

    public Lot() {
        // Default constructor
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public void setParkingLotName(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }
}
