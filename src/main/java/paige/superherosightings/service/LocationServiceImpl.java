package paige.superherosightings.service;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import paige.superherosightings.dao.LocationRepo;
import paige.superherosightings.dto.Location;

import java.util.List;
import java.util.Optional;

@Log
@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    LocationRepo locationRepo;

    @Override
    public Location createLocation(Location location) {
        return locationRepo.save(location);
    }

    @Override
    public Optional<Location> findLocation(int id) {
        return locationRepo.findById(id);
    }

    @Override
    public Location updateLocation(Location location) {
        return locationRepo.save(location);
    }

    @Override
    public boolean deleteLocation(int id) {
        boolean deleteFlag = false;
        try {
            locationRepo.deleteById(id);
            deleteFlag = true;
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return deleteFlag;
    }

    @Override
    public List<Location> getAllLocations() {
        return (List<Location>) locationRepo.findAll();
    }
}
