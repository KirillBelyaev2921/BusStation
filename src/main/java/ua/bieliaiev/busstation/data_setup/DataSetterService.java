package ua.bieliaiev.busstation.data_setup;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DataSetterService {
	private final RouteSetUp routeSetUp;
	private final StopSetUp stopSetUp;
	private final RouteStopSetUp routeStopSetUp;
	private final BusSetUp busSetUp;
	private final BusDepartureSetUp busDepartureSetUp;
	private final BusStopSetUp busStopSetUp;

	public void setTestData() {
		routeSetUp.createRoutes(10);

		stopSetUp.createStandardStops();

		routeStopSetUp.createRandomRouteStops(routeSetUp.getRoutes(), stopSetUp.getStation(), stopSetUp.getStops());

		busSetUp.createBuses(routeSetUp.getRoutes());

		busDepartureSetUp.createBuseDepartures(busSetUp.getBuses());

		busStopSetUp.createBuseStops(busDepartureSetUp.getBusDepartures(), routeStopSetUp.getRouteStops());
	}

}
