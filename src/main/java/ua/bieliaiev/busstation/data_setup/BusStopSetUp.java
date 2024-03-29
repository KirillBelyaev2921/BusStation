package ua.bieliaiev.busstation.data_setup;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;
import ua.bieliaiev.busstation.model.BusDeparture;
import ua.bieliaiev.busstation.model.BusStop;
import ua.bieliaiev.busstation.model.Route;
import ua.bieliaiev.busstation.model.RouteStop;
import ua.bieliaiev.busstation.repostitories.BusStopRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class BusStopSetUp {
	private final BusStopRepository repository;

	@Getter
	private final Map<BusDeparture, List<BusStop>> busRoutes = new HashMap<>();

	public void createBuseStops(List<BusDeparture> busDepartures, Map<Route, List<RouteStop>> routeStops) {
		busDepartures.forEach(busDeparture ->
				setUpBusStopsForBus(busDeparture, routeStops.get(busDeparture.getBus().getRoute())));
	}

	private void setUpBusStopsForBus(BusDeparture busDeparture, List<RouteStop> routeStops) {
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
		repository.saveAll(busStops);
	}
}
