package ua.bieliaiev.busstation.data_setup;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;
import ua.bieliaiev.busstation.model.Bus;
import ua.bieliaiev.busstation.model.Route;
import ua.bieliaiev.busstation.repostitories.BusRepository;

import java.util.ArrayList;
import java.util.List;

import static ua.bieliaiev.busstation.util.Randomizer.*;

@AllArgsConstructor
@Service
public class BusSetUp {
	private final BusRepository repository;

	@Getter
	private final List<Bus> buses = new ArrayList<>();

	public void createBuses(List<Route> routes) {
		routes.forEach(route -> {
			Bus bus = new Bus();
			bus.setRoute(route);
			bus.setBusName(getLetters(2) + getNumbers(4));
			bus.setMaxSize(getNumberBetween(3, 15));
			buses.add(repository.save(bus));
		});
	}
}
