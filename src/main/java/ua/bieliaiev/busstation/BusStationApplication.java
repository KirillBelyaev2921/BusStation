package ua.bieliaiev.busstation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.bieliaiev.busstation.services.DataSetter;

@SpringBootApplication
public class BusStationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusStationApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(DataSetter dataSetter) {
		return args -> dataSetter.setTestData();
	}

}
