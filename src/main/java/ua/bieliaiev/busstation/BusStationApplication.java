package ua.bieliaiev.busstation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.bieliaiev.busstation.configuration.DataSetter;
import ua.bieliaiev.busstation.repostitories.*;

@SpringBootApplication
public class BusStationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusStationApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(RouteStopRepository repository, RouteRepository routeRepository,
								 StopRepository stopRepository, BusRepository busRepository,
								 BusDepartureRepository busDepartureRepository,
								 BusStopRepository busStopRepository) {
		return args -> {
			DataSetter dataSetter = new DataSetter(routeRepository, stopRepository, repository, busRepository,
					busDepartureRepository, busStopRepository);
			dataSetter.setAllData();
		};
	}

}
