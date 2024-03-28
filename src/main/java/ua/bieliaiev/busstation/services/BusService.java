package ua.bieliaiev.busstation.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.bieliaiev.busstation.model.BusDeparture;
import ua.bieliaiev.busstation.repostitories.BusDepartureRepository;
import ua.bieliaiev.busstation.repostitories.BusRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BusService {
	private BusRepository repository;
	private BusDepartureRepository busDepartureRepository;

	public List<BusDeparture> findAllByRouteId(int routeId) {
		return busDepartureRepository.findByIsActiveTrueAndBus_Route_Id(routeId);
	}
}
