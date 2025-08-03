package airtribe.smartParking.Service.ExitManagement;

import airtribe.smartParking.Entity.FeeStandard;
import airtribe.smartParking.Entity.VehicleTransactions;
import airtribe.smartParking.Repository.FeeStandardRepository;
import airtribe.smartParking.Repository.VehicleTransactionsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ExitManagement {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExitManagement.class);

    @Autowired
    private VehicleTransactionsRepository vehicleTransactionsRepository;

    @Autowired
    private FeeStandardRepository feeStandardRepository;

    public Long getParkingFee(Long transactionId) {
        Optional<VehicleTransactions> vehicleTransactions = vehicleTransactionsRepository.findById(transactionId);
        if (vehicleTransactions.isEmpty()) {
            LOGGER.info("Transaction with ID {} not found", transactionId);
        }

        VehicleTransactions transaction = vehicleTransactions.get();
        if (transaction.getEntryTime().isAfter(LocalDateTime.now())) {
            LOGGER.info("Entry time is in the future for transaction ID {}", transactionId);
            throw new IllegalArgumentException("Entry time cannot be in the future");
        }
        FeeStandard feeStandard = feeStandardRepository.findByVehicleType(transaction.getVehicleType());
        FeeCalculationStrategy feeCalculationStrategy = new HourlyBased();
        return feeCalculationStrategy.calculateFee(
                transaction.getEntryTime(),
                LocalDateTime.now(),
                feeStandard.getHourlyRate()
        );
    }
}
