package ua.bieliaiev.busstation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.bieliaiev.busstation.model.Route;
import ua.bieliaiev.busstation.model.RouteStop;
import ua.bieliaiev.busstation.model.Stop;
import ua.bieliaiev.busstation.repostitories.RouteRepository;
import ua.bieliaiev.busstation.repostitories.RouteStopRepository;
import ua.bieliaiev.busstation.repostitories.StopRepository;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication
public class BusStationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusStationApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(RouteStopRepository repository, RouteRepository routeRepository,
								 StopRepository stopRepository) {
		return args -> {
			System.out.println("Hello world!");
			addTestData(repository, routeRepository, stopRepository);
			System.out.println(repository.findAll());
		};
	}

	private void addTestData(RouteStopRepository repository,
							 RouteRepository routeRepository, StopRepository stopRepository) {
		List<Stop> stops = IntStream.range(0, 28)
				.mapToObj(i -> (i + 'A') + "")
				.map(Stop::new)
				.map(stopRepository::save)
				.toList();
		Route route = new Route();
		route.setRouteNumber("Route1");
		route = routeRepository.save(route);
		for (int i = 0; i < stops.size(); i++) {
			repository.save(new RouteStop(route, stops.get(i), i));
		}
	}

}
