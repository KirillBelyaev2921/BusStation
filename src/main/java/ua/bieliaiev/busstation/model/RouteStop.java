package ua.bieliaiev.busstation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Currency;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "route_stop")
public class RouteStop {

	@EmbeddedId
	private RouteStopId id;

	private Integer stopIndex;
	private LocalTime arrival_Time;
	private LocalTime departureTime;
	private Currency price;

	@OneToMany(mappedBy = "routeStop")
	private List<Customer> customers;
}