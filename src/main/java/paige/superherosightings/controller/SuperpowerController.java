package paige.superherosightings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import paige.superherosightings.dto.Organisation;
import paige.superherosightings.dto.Superhero;
import paige.superherosightings.dto.Superpower;
import paige.superherosightings.service.SuperpowerService;
import paige.superherosightings.service.SuperpowerServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class SuperpowerController {

    @Autowired
    SuperpowerService superpowerService = new SuperpowerServiceImpl();

    @GetMapping("superpowers")
    public String displaySuperpowers(Model model) {
        List<Superpower> superpowers = superpowerService.getAllSuperpowers();
        model.addAttribute("superpowers", superpowers);
        return "superpower";
    }

    @PostMapping("addSuperpower")
    public String addSuperpower(HttpServletRequest request) {
        String powerName = request.getParameter("power");

        Superpower power = new Superpower();
        power.setSuperpower(powerName);

        superpowerService.createSuperpower(power);

        return "redirect:/superpowers";
    }

    @GetMapping("deleteSuperpower")
    public String deleteSuperpower(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        superpowerService.deleteSuperpower(id);

        return "redirect:/superpowers";
    }

    @GetMapping("editSuperpower")
    public String editSuperpower(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        Superpower power = superpowerService.findSuperpower(id).get();

        model.addAttribute("superpower", power);

        return "editSuperpower";
    }

    @PostMapping("editSuperpower")
    public String performEditSuperpower(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Superpower power = superpowerService.findSuperpower(id).get();
        String name = request.getParameter("power");

        power.setSuperpower(name);

        superpowerService.updateSuperpower(power);

        return "redirect:/superpowers";

    }

}
