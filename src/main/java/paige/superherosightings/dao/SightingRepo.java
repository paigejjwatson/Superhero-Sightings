package paige.superherosightings.dao;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import paige.superherosightings.dto.Location;
import paige.superherosightings.dto.Sighting;
import paige.superherosightings.dto.Superhero;

import java.time.LocalDate;
import java.util.List;

public interface SightingRepo extends CrudRepository<Sighting, Integer> {
    List<Sighting> findByLocation(Location location);
    List<Sighting> findBySuperhero(Superhero superhero);
    List<Sighting> findAllByDate(LocalDate date);
    List<Sighting> findTop10ByOrderByDateDesc();
}
