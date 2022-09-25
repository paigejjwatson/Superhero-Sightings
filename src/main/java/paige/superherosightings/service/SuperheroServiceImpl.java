package paige.superherosightings.service;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import paige.superherosightings.dao.SuperheroRepo;
import paige.superherosightings.dto.Superhero;

import java.util.List;
import java.util.Optional;

@Log
@Service
public class SuperheroServiceImpl implements SuperheroService {

    @Autowired
    private SuperheroRepo superheroRepo;

    @Override
    public Superhero createSuperhero(Superhero hero) {
        return superheroRepo.save(hero);
    }

    @Override
    public Optional<Superhero> findSuperhero(int id) {
        return superheroRepo.findById(id);
    }

    @Override
    public Superhero updateSuperhero(Superhero hero) {
        return superheroRepo.save(hero);
    }

    @Override
    public boolean deleteSuperhero(int id) {
        boolean deleteFlag = false;
        try {
            superheroRepo.deleteById(id);
            deleteFlag = true;
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return deleteFlag;
    }

    @Override
    public List<Superhero> getAllSuperheroes() {
        return (List<Superhero>) superheroRepo.findAll();
    }
}
