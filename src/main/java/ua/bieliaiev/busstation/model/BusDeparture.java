package ua.bieliaiev.busstation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "bus_departure")
public class BusDeparture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bus_id")
	private Bus bus;

	@OneToMany(mappedBy = "busDeparture")
	private List<BusStop> busStops;

	private Boolean isActive;

	public LocalDateTime getDepartureDate() {
		return busStops.getFirst().getDepartureDate();
	}
}