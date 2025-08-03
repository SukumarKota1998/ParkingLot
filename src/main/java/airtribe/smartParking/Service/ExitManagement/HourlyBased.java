package airtribe.smartParking.Service.ExitManagement;

import airtribe.smartParking.Repository.FeeStandardRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class HourlyBased implements FeeCalculationStrategy {

    @Override
    public Long calculateFee(LocalDateTime entryTime, LocalDateTime exitTime, Long feePerHour) {
        return feePerHour * ChronoUnit.HOURS.between(entryTime, exitTime);
    }
}
