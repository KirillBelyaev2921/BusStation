package ua.bieliaiev.busstation.data_setup;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.bieliaiev.busstation.model.Stop;
import ua.bieliaiev.busstation.repostitories.StopRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class StopSetUp {
	private final StopRepository repository;
	@Getter
	private Stop station = new Stop("Station");
	@Getter
	private final List<Stop> stops = new ArrayList<>();

	@Autowired
	public StopSetUp(StopRepository repository) {
		this.repository = repository;
	}

	public void createStandardStops() {
		station = repository.save(station);
		stops.addAll(IntStream.range(0, 26)
				.mapToObj(i -> (char)(i + 'A') + "")
				.map(Stop::new)
				.map(repository::save)
				.toList());
	}
}
