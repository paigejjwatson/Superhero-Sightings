package paige.superherosightings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import paige.superherosightings.dto.*;
import paige.superherosightings.service.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SightingController {
    @Autowired
    SightingService sightingService = new SightingServiceImpl();
    @Autowired
    SuperheroService superheroService = new SuperheroServiceImpl();
    @Autowired
    LocationService locationService = new LocationServiceImpl();

    @GetMapping("sightings")
    public String displaySightings(Model model) {
        List<Sighting> sightings = sightingService.getAllSightings();
        List<Superhero> superheroes = superheroService.getAllSuperheroes();
        List<Location> locations = locationService.getAllLocations();

        model.addAttribute("sightings", sightings);
        model.addAttribute("superheroes", superheroes);
        model.addAttribute("locations", locations);

        return "sighting";
    }

    @PostMapping("addSighting")
    public String addSighting(HttpServletRequest request) {
        int superheroId = Integer.parseInt(request.getParameter("hero"));
        int locationId = Integer.parseInt(request.getParameter("location"));
        String dateStr = request.getParameter("date");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        LocalDate date = LocalDate.parse(dateStr, formatter);

        Superhero hero = superheroService.findSuperhero(superheroId).get();
        Location location = locationService.findLocation(locationId).get();


        Sighting sighting = new Sighting();
        sighting.setSuperhero(hero);
        sighting.setLocation(location);
        sighting.setDate(date);

        //System.out.println(hero);

        sightingService.createSighting(sighting);

        return "redirect:/sightings";
    }

    @GetMapping("deleteSighting")
    public String deleteSighting(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        sightingService.deleteSighting(id);

        return "redirect:/sightings";
    }

    @GetMapping("editSighting")
    public String editSighting(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        Sighting sighting = sightingService.findSighting(id).get();

        List<Superhero> superheroes = superheroService.getAllSuperheroes();
        List<Location> locations = locationService.getAllLocations();

        model.addAttribute("sighting", sighting);
        model.addAttribute("superheroes", superheroes);
        model.addAttribute("locations", locations);

        return "editSighting";
    }

    @PostMapping("editSighting")
    public String performEditSighting(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Sighting sighting = sightingService.findSighting(id).get();
        int superheroId = Integer.parseInt(request.getParameter("hero"));
        int locationId = Integer.parseInt(request.getParameter("location"));
        String dateStr = request.getParameter("date");

        LocalDate date;
        if (dateStr.contains("/")) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
            date = LocalDate.parse(dateStr, formatter);
        } else {
            date = LocalDate.parse(dateStr);
        }

        Superhero hero = superheroService.findSuperhero(superheroId).get();
        Location location = locationService.findLocation(locationId).get();

        sighting.setSuperhero(hero);
        sighting.setLocation(location);
        sighting.setDate(date);

        sightingService.updateSighting(sighting);

        return "redirect:/sightings";

    }
}
