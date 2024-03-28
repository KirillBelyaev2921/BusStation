package ua.bieliaiev.busstation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class BusStop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bus_departure_id")
	private BusDeparture busDeparture;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "route_id"),
			@JoinColumn(name = "stop_id")
	})
	private RouteStop routeStop;

	@OneToMany(mappedBy = "busStop")
	private List<Customer> customers;

	private LocalDateTime arrivalDate;
	private LocalDateTime departureDate;
	private Double price;

}
