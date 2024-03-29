package ua.bieliaiev.busstation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.bieliaiev.busstation.data_setup.DataSetterService;

@SpringBootApplication
public class BusStationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusStationApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(DataSetterService dataSetterService) {
		return args -> dataSetterService.setTestData();
	}

}
