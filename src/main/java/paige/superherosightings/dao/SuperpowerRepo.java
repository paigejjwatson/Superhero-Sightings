package paige.superherosightings.dao;

import org.springframework.data.repository.CrudRepository;
import paige.superherosightings.dto.Superpower;

public interface SuperpowerRepo extends CrudRepository<Superpower, Integer> {
    Superpower findBySuperpower(String name);
}
