package ua.bieliaiev.busstation.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.bieliaiev.busstation.model.Route;
import ua.bieliaiev.busstation.repostitories.RouteRepository;

@Service
@AllArgsConstructor
public class RouteService {
	private final RouteRepository repository;

	public Route findRouteById(Integer id) {
		return repository.findById(id)
				.orElseThrow(IllegalArgumentException::new);
	}
}
