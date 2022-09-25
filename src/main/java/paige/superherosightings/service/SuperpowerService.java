package paige.superherosightings.service;

import paige.superherosightings.dto.Superhero;
import paige.superherosightings.dto.Superpower;

import java.util.List;
import java.util.Optional;

public interface SuperpowerService {
    Optional<Superpower> findSuperpower(int id);
    Superpower findSuperpowerByName(String name);
    Superpower createSuperpower(Superpower power);
    Superpower updateSuperpower(Superpower power);
    boolean deleteSuperpower(int id);
    List<Superpower> getAllSuperpowers();
}
