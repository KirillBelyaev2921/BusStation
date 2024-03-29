package ua.bieliaiev.busstation.data_setup;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.bieliaiev.busstation.model.*;
import ua.bieliaiev.busstation.repostitories.BusDepartureRepository;
import ua.bieliaiev.busstation.repostitories.BusRepository;
import ua.bieliaiev.busstation.repostitories.BusStopRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class DataSetterService {
	private final RouteSetUp routeSetUp;
	private final StopSetUp stopSetUp;
	private final RouteStopSetUp routeStopSetUp;
	private final BusRepository busRepository;
	private final BusDepartureRepository busDepartureRepository;
	private final BusStopRepository busStopRepository;

	public void setTestData() {
		routeSetUp.createRoutes(10);

		stopSetUp.createStandardStops();

		routeStopSetUp.createRandomRouteStops(routeSetUp.getRoutes(), stopSetUp.getStation(), stopSetUp.getStops());

		Bus bus = setUpBus(routeSetUp.getRoutes().getFirst());

		BusDeparture busDeparture = setUpBusDeparture(bus);

		setUpBusStops(busDeparture, routeStopSetUp.getRouteStops().get(routeSetUp.getRoutes().getFirst()));
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
