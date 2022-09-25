package paige.superherosightings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import paige.superherosightings.dto.Sighting;
import paige.superherosightings.service.SightingService;
import paige.superherosightings.service.SightingServiceImpl;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    SightingService sightingService = new SightingServiceImpl();

    @GetMapping("/")
    public String displayHome(Model model) {
        List<Sighting> sightings = sightingService.getLast10();
        model.addAttribute("sightings", sightings);

        return "index";
    }
}
