package airtribe.smartParking.Repository;

import airtribe.smartParking.Entity.FeeStandard;
import airtribe.smartParking.Entity.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeeStandardRepository extends JpaRepository<FeeStandard, Long> {

    FeeStandard findByVehicleType(VehicleType vehicleType);
}
