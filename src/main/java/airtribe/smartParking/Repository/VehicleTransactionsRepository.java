package airtribe.smartParking.Repository;

import airtribe.smartParking.Entity.VehicleTransactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleTransactionsRepository extends JpaRepository<VehicleTransactions, Long> {
}
