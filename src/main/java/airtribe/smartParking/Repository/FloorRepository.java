package airtribe.smartParking.Repository;

import airtribe.smartParking.Entity.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorRepository extends JpaRepository<Floor, Long> {
}
