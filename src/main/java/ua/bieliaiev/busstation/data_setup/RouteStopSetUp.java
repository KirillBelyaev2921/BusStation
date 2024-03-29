package ua.bieliaiev.busstation.data_setup;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;
import ua.bieliaiev.busstation.model.Route;
import ua.bieliaiev.busstation.model.RouteStop;
import ua.bieliaiev.busstation.model.Stop;
import ua.bieliaiev.busstation.repostitories.RouteStopRepository;

import java.util.*;
import static ua.bieliaiev.busstation.util.Randomizer.*;

@AllArgsConstructor
@Service
public class RouteStopSetUp {
	private final RouteStopRepository repository;
	@Getter
	private final Map<Route, List<RouteStop>> routeStops = new HashMap<>();

	public void createRandomRouteStops(List<Route> routes, Stop station, List<Stop> stops) {
		List<Stop> newStops = new ArrayList<>(stops);

		routes.forEach(route -> routeStops.put(route, getRandomStops(route, station, newStops)));
	}

	private List<RouteStop> getRandomStops(Route route, Stop station, List<Stop> newStops) {
		List<RouteStop> routeStops = new ArrayList<>();
		routeStops.add(repository.save(new RouteStop(route, station, 0)));
		Collections.shuffle(newStops);
		for (int i = 0; i < getNumberBetween(8, 15); i++) {
			routeStops.add(
					repository.save(new RouteStop(route, newStops.get(i), i + 1)));
		}
		return routeStops;
	}
}
