package paige.superherosightings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import paige.superherosightings.dto.Location;
import paige.superherosightings.dto.Superhero;
import paige.superherosightings.dto.Superpower;
import paige.superherosightings.service.LocationService;
import paige.superherosightings.service.LocationServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
public class LocationController {

    @Autowired
    LocationService locationService = new LocationServiceImpl();

    @GetMapping("locations")
    public String displayLocations(Model model) {
        List<Location> locations = locationService.getAllLocations();
        model.addAttribute("locations", locations);
        return "location";
    }

    @PostMapping("addLocation")
    public String addSuperhero(HttpServletRequest request) {
        String name = request.getParameter("name");
        String desc = request.getParameter("desc");
        String address = request.getParameter("address");
        double longitude = (Double.parseDouble(request.getParameter("long")));
        double latitude = (Double.parseDouble(request.getParameter("lat")));

        Location location = new Location();
        location.setName(name);
        location.setDescription(desc);
        location.setAddress(address);
        location.setLongitude(longitude);
        location.setLatitude(latitude);

        locationService.createLocation(location);

        return "redirect:/locations";
    }

    @GetMapping("deleteLocation")
    public String deleteSuperpower(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        locationService.deleteLocation(id);

        return "redirect:/locations";
    }

    @GetMapping("editLocation")
    public String editSuperpower(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        Location location = locationService.findLocation(id).get();

        model.addAttribute("location", location);

        return "editLocation";
    }

    @PostMapping("editLocation")
    public String performEditLocation(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Location location = locationService.findLocation(id).get();
        String name = request.getParameter("name");
        String desc = request.getParameter("desc");
        String address = request.getParameter("address");
        double longitude = Double.parseDouble(request.getParameter("long"));
        double latitude = Double.parseDouble(request.getParameter("lat"));

        location.setName(name);
        location.setDescription(desc);
        location.setAddress(address);
        location.setLongitude(longitude);
        location.setLatitude(latitude);

        locationService.updateLocation(location);

        return "redirect:/locations";

    }
}
