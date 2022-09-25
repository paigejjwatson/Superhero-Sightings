package paige.superherosightings.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import paige.superherosightings.dto.Organisation;
import paige.superherosightings.dto.Superhero;

import java.util.List;

public interface OrganisationRepo extends CrudRepository<Organisation, Integer> {
    List<Organisation> findAllByMembersIn(List<Superhero> members);
    Organisation findByName(String name);
}
