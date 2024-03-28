package ua.bieliaiev.busstation.repostitories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.bieliaiev.busstation.model.Route;

public interface RouteRepository extends JpaRepository<Route, Integer> {

}