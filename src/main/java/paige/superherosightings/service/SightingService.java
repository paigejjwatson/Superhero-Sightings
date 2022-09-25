package paige.superherosightings.service;

import paige.superherosightings.dto.Sighting;
import paige.superherosightings.dto.Superhero;

import java.util.List;
import java.util.Optional;

public interface SightingService {
    Sighting createSighting(Sighting sighting);
    Optional<Sighting> findSighting(int id);
    Sighting updateSighting(Sighting sighting);
    boolean deleteSighting(int id);
    List<Sighting> getAllSightings();

    List<Sighting> getLast10();
}
