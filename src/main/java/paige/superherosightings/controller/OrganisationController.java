package paige.superherosightings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import paige.superherosightings.dto.Location;
import paige.superherosightings.dto.Organisation;
import paige.superherosightings.dto.Superhero;
import paige.superherosightings.service.OrganisationService;
import paige.superherosightings.service.OrganisationServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class OrganisationController {

    @Autowired
    OrganisationService organisationService = new OrganisationServiceImpl();

    @GetMapping("/organisations")
    public String displayOrganisations(Model model) {
        List<Organisation> organisations = organisationService.getAllOrganisations();
        model.addAttribute("organisations", organisations);
        return "organisation";
    }

    @PostMapping("addOrganisation")
    public String addSuperhero(HttpServletRequest request) {
        String name = request.getParameter("name");
        String desc = request.getParameter("desc");
        String address = request.getParameter("address");
        String email = request.getParameter("email");

        Organisation organisation = new Organisation();
        organisation.setName(name);
        organisation.setDescription(desc);
        organisation.setAddress(address);
        organisation.setContact(email);

        organisationService.createOrganisation(organisation);

        return "redirect:/organisations";
    }

    @GetMapping("deleteOrganisation")
    public String deleteSuperpower(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        organisationService.deleteOrganisation(id);

        return "redirect:/organisations";
    }

    @GetMapping("editOrganisation")
    public String editOrganisation(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        Organisation organisation = organisationService.findOrganisation(id).get();

        model.addAttribute("organisation", organisation);

        return "editOrganisation";
    }

    @PostMapping("editOrganisation")
    public String performEditOrganisation(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Organisation organisation = organisationService.findOrganisation(id).get();
        String name = request.getParameter("name");
        String desc = request.getParameter("desc");
        String address = request.getParameter("address");
        String contact = request.getParameter("email");

        organisation.setName(name);
        organisation.setDescription(desc);
        organisation.setAddress(address);
        organisation.setContact(contact);

        organisationService.updateOrganisation(organisation);

        return "redirect:/organisations";

    }

}
