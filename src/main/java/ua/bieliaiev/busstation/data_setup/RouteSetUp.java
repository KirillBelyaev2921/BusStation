package ua.bieliaiev.busstation.data_setup;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;
import ua.bieliaiev.busstation.model.Route;
import ua.bieliaiev.busstation.repostitories.RouteRepository;

import java.util.ArrayList;
import java.util.List;
import static ua.bieliaiev.busstation.util.Randomizer.*;

@AllArgsConstructor
@Service
public class RouteSetUp {
	private final RouteRepository repository;

	@Getter
	private final List<Route> routes = new ArrayList<>();

	public void createRoutes(int numberOfRoutes) {
		for (int i = 0; i < numberOfRoutes; i++) {
			Route route = new Route();
			route.setRouteNumber(getLetters(1) + getNumbers(3));
			route = repository.save(route);
			routes.add(route);
		}
	}
}
