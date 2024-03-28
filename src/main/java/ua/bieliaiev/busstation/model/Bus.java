package ua.bieliaiev.busstation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "bus")
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "route_id", referencedColumnName = "id")
	private Route route;

	private Integer maxSize;
	private LocalTime departureTime;

	@OneToMany(mappedBy = "bus")
	private List<BusDeparture> departures;
}