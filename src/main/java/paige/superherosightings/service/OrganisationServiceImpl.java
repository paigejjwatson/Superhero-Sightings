package paige.superherosightings.service;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import paige.superherosightings.dao.OrganisationRepo;
import paige.superherosightings.dao.SuperheroRepo;
import paige.superherosightings.dto.Organisation;
import paige.superherosightings.dto.Superhero;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log
@Service
public class OrganisationServiceImpl implements OrganisationService {

    @Autowired
    OrganisationRepo organisationRepo;

    @Autowired
    SuperheroRepo superheroRepo;

    @Override
    public Organisation createOrganisation(Organisation organisation) {
        return organisationRepo.save(organisation);
    }

    @Override
    public Optional<Organisation> findOrganisation(int id) {
        return organisationRepo.findById(id);
    }

    @Override
    public Organisation updateOrganisation(Organisation organisation) {
        return organisationRepo.save(organisation);
    }

    @Override
    public boolean deleteOrganisation(int id) {
        boolean deleteFlag = false;
        try {
            organisationRepo.deleteById(id);
            deleteFlag = true;
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return deleteFlag;
    }

    @Override
    public List<Organisation> getAllOrganisations() {
        return (List<Organisation>) organisationRepo.findAll();
    }

    @Override
    public Organisation findOrganisationByName(String name) {
        return organisationRepo.findByName(name);
    }

    @Override
    public List<Organisation> findOrganisationByMember(int superheroId) {
        Superhero hero = superheroRepo.findById(superheroId).get();
        List<Superhero> members = new ArrayList<>();
        members.add(hero);
        return organisationRepo.findAllByMembersIn(members);
    }
}
