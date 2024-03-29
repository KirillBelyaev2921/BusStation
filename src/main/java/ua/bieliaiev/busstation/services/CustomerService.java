package ua.bieliaiev.busstation.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.bieliaiev.busstation.model.BusStop;
import ua.bieliaiev.busstation.model.Customer;
import ua.bieliaiev.busstation.repostitories.BusStopRepository;
import ua.bieliaiev.busstation.repostitories.CustomerRepository;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class CustomerService {
	private final CustomerRepository repository;
	private final BusStopRepository busStopRepository;

	public boolean buyTicket(Customer customer, int busStopId) {
		BusStop busStop = busStopRepository.findById(busStopId)
				.orElseThrow(IllegalArgumentException::new);

		if (busStop.getBusDeparture().getFreeSeatsNumber() > 0) {
			customer.setBusStop(busStop);
			customer.setTicketBuyDate(LocalDateTime.now());
			repository.save(customer);
			return true;
		} else {
			return false;
		}
	}
}
