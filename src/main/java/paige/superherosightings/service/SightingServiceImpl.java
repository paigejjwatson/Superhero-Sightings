package paige.superherosightings.service;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import paige.superherosightings.dao.SightingRepo;
import paige.superherosightings.dto.Sighting;

import java.util.List;
import java.util.Optional;

@Log
@Service
public class SightingServiceImpl implements SightingService {
    @Autowired
    SightingRepo sightingRepo;

    @Override
    public Sighting createSighting(Sighting sighting) {
        return sightingRepo.save(sighting);
    }

    @Override
    public Optional<Sighting> findSighting(int id) {
        return sightingRepo.findById(id);
    }

    @Override
    public Sighting updateSighting(Sighting sighting) {
        return sightingRepo.save(sighting);
    }

    @Override
    public boolean deleteSighting(int id) {
        boolean deleteFlag = false;
        try {
            sightingRepo.deleteById(id);
            deleteFlag = true;
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return deleteFlag;
    }

    @Override
    public List<Sighting> getAllSightings() {
        return (List<Sighting>) sightingRepo.findAll();
    }

    @Override
    public List<Sighting> getLast10() {
        return sightingRepo.findTop10ByOrderByDateDesc();
    }
}
