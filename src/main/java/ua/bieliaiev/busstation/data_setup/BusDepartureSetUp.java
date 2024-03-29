package ua.bieliaiev.busstation.data_setup;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;
import ua.bieliaiev.busstation.model.Bus;
import ua.bieliaiev.busstation.model.BusDeparture;
import ua.bieliaiev.busstation.repostitories.BusDepartureRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BusDepartureSetUp {
	private final BusDepartureRepository repository;

	@Getter
	private final List<BusDeparture> busDepartures = new ArrayList<>();

	public void createBuseDepartures(List<Bus> buses) {
		buses.forEach(bus -> {
			BusDeparture busDeparture = new BusDeparture();
			busDeparture.setIsActive(true);
			busDeparture.setBus(bus);
			busDepartures.add(repository.save(busDeparture));
		});
	}
}
