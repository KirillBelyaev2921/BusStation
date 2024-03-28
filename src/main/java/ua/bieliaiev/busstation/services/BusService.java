package ua.bieliaiev.busstation.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.bieliaiev.busstation.model.BusDeparture;
import ua.bieliaiev.busstation.repostitories.BusDepartureRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BusService {
	private BusDepartureRepository busDepartureRepository;

	public BusDeparture findById(int id) {
		return busDepartureRepository.findById(id)
				.orElseThrow(IllegalArgumentException::new);
	}

	public List<BusDeparture> findAllByRouteId(int routeId) {
		return busDepartureRepository.findByIsActiveTrueAndBus_Route_Id(routeId);
	}
}
