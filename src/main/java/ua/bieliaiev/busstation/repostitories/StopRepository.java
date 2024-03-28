package ua.bieliaiev.busstation.repostitories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.bieliaiev.busstation.model.Stop;

public interface StopRepository extends JpaRepository<Stop, Integer> {
}