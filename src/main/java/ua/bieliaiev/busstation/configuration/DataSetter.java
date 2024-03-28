package ua.bieliaiev.busstation.configuration;

import lombok.AllArgsConstructor;
import ua.bieliaiev.busstation.model.*;
import ua.bieliaiev.busstation.repostitories.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@AllArgsConstructor
public class DataSetter {
	private final RouteRepository routeRepository;
	private final StopRepository stopRepository;
	private final RouteStopRepository routeStopRepository;
	private final BusRepository busRepository;
	private final BusDepartureRepository busDepartureRepository;
	private final BusStopRepository busStopRepository;

	public void setAllData() {
		Route route = setRoute("Route 1");

		List<Stop> stops = setUpStops();

		List<RouteStop> routeStops = setUpRouteStops(stops, route);

		Bus bus = setUpBus(route);

		BusDeparture busDeparture = setUpBusDeparture(bus);

		setUpBusStops(busDeparture, routeStops);
	}


	private Route setRoute(String routeName) {
		Route route = new Route();
		route.setRouteNumber(routeName);
		route = routeRepository.save(route);
		return route;
	}

	private List<Stop> setUpStops() {
		List<Stop> stops = IntStream.range(0, 26)
				.mapToObj(i -> (char)(i + 'A') + "")
				.map(Stop::new)
				.map(stopRepository::save)
				.collect(Collectors.toList());
		stops.addFirst(new Stop("Station"));
		return stops;
	}

	private List<RouteStop> setUpRouteStops(List<Stop> stops, Route route) {
		List<RouteStop> routeStops = new ArrayList<>();
		for (int i = 0; i < stops.size(); i++) {
			routeStops.add(
					routeStopRepository.save(new RouteStop(route, stops.get(i), i)));
		}
		return routeStops;
	}

	private Bus setUpBus(Route route) {
		Bus bus = new Bus();
		bus.setRoute(route);
		bus = busRepository.save(bus);
		return busRepository.save(bus);
	}

	private BusDeparture setUpBusDeparture(Bus bus) {
		BusDeparture busDeparture = new BusDeparture();
		busDeparture.setIsActive(true);
		busDeparture.setBus(bus);
		busDeparture = busDepartureRepository.save(busDeparture);
		return busDeparture;
	}

	private void setUpBusStops(BusDeparture busDeparture, List<RouteStop> routeStops) {
		List<BusStop> busStops = new ArrayList<>();
		LocalDateTime departureDate = LocalDateTime.now().plusHours(2);
		double price = 0;
		for (RouteStop routeStop : routeStops) {
			BusStop busStop = new BusStop();
			busStop.setRouteStop(routeStop);
			busStop.setBusDeparture(busDeparture);
			busStop.setPrice(price);
			if (routeStop.getStopIndex() == 0) {
				busStop.setDepartureDate(departureDate);
			} else {
				busStop.setArrivalDate(departureDate.plusMinutes(30));
				departureDate = departureDate.plusMinutes(45);
				busStop.setDepartureDate(departureDate);
			}
			price += 100;
			busStops.add(busStop);
		}
		busStopRepository.saveAll(busStops);
	}
}
