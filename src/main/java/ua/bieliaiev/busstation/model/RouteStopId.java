package ua.bieliaiev.busstation.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;
@Data
@Embeddable
public class RouteStopId implements Serializable {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "stop_id")
	private Stop stop;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "route_id")
	private Route route;
}
