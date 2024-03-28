package ua.bieliaiev.busstation.repostitories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.bieliaiev.busstation.model.RouteStop;
import ua.bieliaiev.busstation.model.RouteStopId;

public interface RouteStopRepository extends JpaRepository<RouteStop, RouteStopId> {
}