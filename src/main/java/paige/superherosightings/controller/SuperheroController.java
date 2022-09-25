package paige.superherosightings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import paige.superherosightings.dto.Organisation;
import paige.superherosightings.dto.Superhero;
import paige.superherosightings.dto.Superpower;
import paige.superherosightings.service.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class SuperheroController {

    @Autowired
    SuperheroService superheroService = new SuperheroServiceImpl();

    @Autowired
    SuperpowerService superpowerService = new SuperpowerServiceImpl();

    @Autowired
    OrganisationService organisationService = new OrganisationServiceImpl();

    @GetMapping("/superheroes")
    public String displaySuperheroes(Model model) {
        List<Superhero> superheroes = superheroService.getAllSuperheroes();
        List<Superpower> superpowers = superpowerService.getAllSuperpowers();
        List<Organisation> organisations = organisationService.getAllOrganisations();

        List<String> powerNames = new ArrayList<>();
        for (Superpower power : superpowers) {
            powerNames.add(power.getSuperpower());
        }

        List<String> organisationNames = new ArrayList<>();
        for (Organisation organisation : organisations) {
            organisationNames.add(organisation.getName());
        }



        model.addAttribute("superheroes", superheroes);
        model.addAttribute("superpowers", powerNames);
        model.addAttribute("organisations", organisationNames);

        return "superhero";
    }

    @PostMapping("addSuperhero")
    public String addSuperhero(HttpServletRequest request) {
        String name = request.getParameter("name");
        String desc = request.getParameter("desc");
        Superpower power = superpowerService.findSuperpowerByName(request.getParameter("power"));
        Organisation organisation = organisationService.findOrganisationByName(request.getParameter("organisation"));

        Superhero hero = new Superhero();
        hero.setName(name);
        hero.setDescription(desc);
        hero.setSuperpower(power);
        hero.addOrganisation(organisation);

        //System.out.println(hero);

        superheroService.createSuperhero(hero);

        return "redirect:/superheroes";
    }

    @GetMapping("deleteSuperhero")
    public String deleteSuperhero(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        superheroService.deleteSuperhero(id);

        return "redirect:/superheroes";
    }

    @GetMapping("editSuperhero")
    public String editSuperhero(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        Superhero hero = superheroService.findSuperhero(id).get();

        List<Superpower> superpowers = superpowerService.getAllSuperpowers();
        List<Organisation> organisations = organisationService.getAllOrganisations();

        List<String> powerNames = new ArrayList<>();
        for (Superpower power : superpowers) {
            powerNames.add(power.getSuperpower());
        }

        List<String> organisationNames = new ArrayList<>();
        for (Organisation organisation : organisations) {
            organisationNames.add(organisation.getName());
        }

        model.addAttribute("superhero", hero);
        model.addAttribute("superpowers", powerNames);
        model.addAttribute("organisations", organisationNames);

        return "editSuperhero";
    }

    @PostMapping("editSuperhero")
    public String performEditSuperhero(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Superhero hero = superheroService.findSuperhero(id).get();
        String name = request.getParameter("name");
        String desc = request.getParameter("desc");
        Superpower power = superpowerService.findSuperpowerByName(request.getParameter("power"));
        Organisation organisation = organisationService.findOrganisationByName(request.getParameter("organisation"));

        System.out.println(hero);

        hero.setName(name);
        hero.setDescription(desc);
        hero.setSuperpower(power);
        hero.addOrganisation(organisation);

        System.out.println(hero);

        superheroService.updateSuperhero(hero);

        return "redirect:/superheroes";

    }

}
