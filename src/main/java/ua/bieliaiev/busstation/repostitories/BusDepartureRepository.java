package ua.bieliaiev.busstation.repostitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.bieliaiev.busstation.model.BusDeparture;

import java.util.List;

public interface BusDepartureRepository extends JpaRepository<BusDeparture, Integer> {
	List<BusDeparture> findByIsActiveTrueAndBus_Route_Id(Integer id);

	@Query("""
			select b from BusDeparture b inner join b.busStops busStops
			where b.isActive = true and busStops.routeStop.stop.id = ?1
			order by busStops.arrivalDate""")
	List<BusDeparture> findByIsActiveTrueAndBusStops_RouteStop_Stop(Integer id);


}