package ua.bieliaiev.busstation.repostitories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.bieliaiev.busstation.model.Bus;

import java.util.List;

public interface BusRepository extends JpaRepository<Bus, Integer> {
	List<Bus> findByRoute_Id(Integer id);

}