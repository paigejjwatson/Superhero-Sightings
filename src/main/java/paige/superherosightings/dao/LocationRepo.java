package paige.superherosightings.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import paige.superherosightings.dto.Location;

public interface LocationRepo extends CrudRepository<Location, Integer> {
}
