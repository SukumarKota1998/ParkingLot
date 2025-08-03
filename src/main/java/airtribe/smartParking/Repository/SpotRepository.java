package airtribe.smartParking.Repository;

import airtribe.smartParking.Entity.Spot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpotRepository extends JpaRepository<Spot, Long> {

    List<Spot> findByIsOccupiedFalse();
}
