package ua.bieliaiev.busstation.repostitories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.bieliaiev.busstation.model.BusDeparture;

import java.util.List;

public interface BusDepartureRepository extends JpaRepository<BusDeparture, Integer> {
	List<BusDeparture> findByIsActiveTrueAndBus_Route_Id(Integer id);

}