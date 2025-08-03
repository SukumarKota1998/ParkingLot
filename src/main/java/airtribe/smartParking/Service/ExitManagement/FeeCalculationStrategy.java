package airtribe.smartParking.Service.ExitManagement;

import java.time.LocalDateTime;

public interface FeeCalculationStrategy {
    Long calculateFee(LocalDateTime entryTime, LocalDateTime exitTime, Long feePerHour);
}
