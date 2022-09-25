package paige.superherosightings.service;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import paige.superherosightings.dao.SuperpowerRepo;
import paige.superherosightings.dto.Superpower;

import java.util.List;
import java.util.Optional;

@Log
@Service
public class SuperpowerServiceImpl implements SuperpowerService {

    @Autowired
    SuperpowerRepo superpowerRepo;

    @Override
    public Optional<Superpower> findSuperpower(int id) {
        return superpowerRepo.findById(id);
    }

    @Override
    public Superpower findSuperpowerByName(String name) {
        return superpowerRepo.findBySuperpower(name);
    }

    @Override
    public Superpower createSuperpower(Superpower power) {
        return superpowerRepo.save(power);
    }

    @Override
    public Superpower updateSuperpower(Superpower power) {
        return superpowerRepo.save(power);
    }

    @Override
    public boolean deleteSuperpower(int id) {
        boolean deleteFlag = false;
        try {
            superpowerRepo.deleteById(id);
            deleteFlag = true;
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return deleteFlag;
    }

    @Override
    public List<Superpower> getAllSuperpowers() {
        return (List<Superpower>) superpowerRepo.findAll();
    }
}
