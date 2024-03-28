package ua.bieliaiev.busstation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "route")
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	private String routeNumber;

	@OneToMany(mappedBy = "route")
	private List<RouteStop> routeStops;

	@OneToOne(mappedBy = "route")
	private Bus bus;

}