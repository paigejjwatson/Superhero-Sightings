package paige.superherosightings.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import paige.superherosightings.dto.Organisation;
import paige.superherosightings.dto.Superhero;

import java.util.List;

public interface SuperheroRepo extends CrudRepository<Superhero, Integer> {
    List<Superhero> findAllByOrganisationsIn(List<Organisation> organisations);
}
