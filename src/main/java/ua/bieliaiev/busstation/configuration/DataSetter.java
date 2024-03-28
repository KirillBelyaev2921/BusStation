package ua.bieliaiev.busstation.configuration;

import lombok.AllArgsConstructor;
import ua.bieliaiev.busstation.model.Route;
import ua.bieliaiev.busstation.model.RouteStop;
import ua.bieliaiev.busstation.model.Stop;
import ua.bieliaiev.busstation.repostitories.RouteRepository;
import ua.bieliaiev.busstation.repostitories.RouteStopRepository;
import ua.bieliaiev.busstation.repostitories.StopRepository;

import java.util.List;
import java.util.stream.IntStream;

@AllArgsConstructor
public class DataSetter {
	private final RouteRepository routeRepository;
	private final StopRepository stopRepository;
	private final RouteStopRepository routeStopRepository;

	public void setAllData() {
		Route route = setRoute("Route 1");
		List<Stop> stops = setUpStops();
		setUpRouteStops(stops, route);
	}

	private Route setRoute(String routeName) {
		Route route = new Route();
		route.setRouteNumber(routeName);
		route = routeRepository.save(route);
		return route;
	}

	private List<Stop> setUpStops() {
		return IntStream.range(0, 26)
				.mapToObj(i -> (char)(i + 'A') + "")
				.map(Stop::new)
				.map(stopRepository::save)
				.toList();
	}

	private void setUpRouteStops(List<Stop> stops, Route route) {
		for (int i = 0; i < stops.size(); i++) {
			routeStopRepository.save(new RouteStop(route, stops.get(i), i));
		}
	}
}
