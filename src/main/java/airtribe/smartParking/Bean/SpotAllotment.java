package airtribe.smartParking.Bean;

public class SpotAllotment {

    private Long ticketId;

    private Long floorNumber;

    private Long spotNumber;

    public SpotAllotment(Long ticketId, Long floorNumber, Long spotNumber) {
        this.ticketId = ticketId;
        this.floorNumber = floorNumber;
        this.spotNumber = spotNumber;
    }

    public SpotAllotment() {
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Long getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Long floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Long getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(Long spotNumber) {
        this.spotNumber = spotNumber;
    }
}
