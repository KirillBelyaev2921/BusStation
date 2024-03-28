package ua.bieliaiev.busstation.repostitories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.bieliaiev.busstation.model.Bus;

public interface BusRepository extends JpaRepository<Bus, Integer> {
}