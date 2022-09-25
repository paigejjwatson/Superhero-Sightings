package paige.superherosightings.service;

import paige.superherosightings.dto.Superhero;

import java.util.List;
import java.util.Optional;

public interface SuperheroService {
    Superhero createSuperhero(Superhero hero);
    Optional<Superhero> findSuperhero(int id);
    Superhero updateSuperhero(Superhero hero);
    boolean deleteSuperhero(int id);
    List<Superhero> getAllSuperheroes();
}
