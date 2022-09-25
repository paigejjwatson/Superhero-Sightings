package paige.superherosightings.service;

import paige.superherosightings.dto.Organisation;

import java.util.List;
import java.util.Optional;

public interface OrganisationService {
    Organisation createOrganisation(Organisation organisation);
    Optional<Organisation> findOrganisation(int id);
    Organisation updateOrganisation(Organisation organisation);
    boolean deleteOrganisation(int id);
    List<Organisation> getAllOrganisations();
    Organisation findOrganisationByName(String name);
    List<Organisation> findOrganisationByMember(int superheroId);
}
