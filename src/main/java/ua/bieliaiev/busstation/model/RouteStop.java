package ua.bieliaiev.busstation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "route_stop")
public class RouteStop {

	@EmbeddedId
	private RouteStopId id = new RouteStopId();

	@ManyToOne
	@MapsId("routeId")
	@JoinColumn(name = "route_id")
	private Route route;

	@ManyToOne
	@MapsId("stopId")
	@JoinColumn(name = "stop_id")
	private Stop stop;

	private Integer stopIndex;

	@OneToMany(mappedBy = "routeStop")
	private List<BusStop> busStops;

	public RouteStop(Route route, Stop stop, Integer stopIndex) {
		this.route = route;
		this.stop = stop;
		this.stopIndex = stopIndex;
	}
}