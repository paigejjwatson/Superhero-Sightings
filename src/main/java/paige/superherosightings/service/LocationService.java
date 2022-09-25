package paige.superherosightings.service;

import paige.superherosightings.dto.Location;

import java.util.List;
import java.util.Optional;

public interface LocationService {
    Location createLocation(Location location);
    Optional<Location> findLocation(int id);
    Location updateLocation(Location location);
    boolean deleteLocation(int id);
    List<Location> getAllLocations();
}
