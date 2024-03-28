package ua.bieliaiev.busstation.repostitories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.bieliaiev.busstation.model.BusStop;

public interface BusStopRepository extends JpaRepository<BusStop, Integer> {
}