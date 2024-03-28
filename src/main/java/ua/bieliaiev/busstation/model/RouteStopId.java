package ua.bieliaiev.busstation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class RouteStopId implements Serializable {
	@Column(name = "stop_id")
	private Integer stopId;

	@Column(name = "route_id")
	private Integer routeId;
}
