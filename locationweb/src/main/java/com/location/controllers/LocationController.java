package com.location.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.location.entities.Location;
import com.location.repos.LocationRepository;
import com.location.service.LocationService;
import com.location.util.EmailUtil;
import com.location.util.reportUtil;

import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LocationController {
	@Autowired
	LocationService service;
	@Autowired
	private EmailUtil emailUtil;
	@Autowired
	private reportUtil reportUtilobj;
	@Autowired
	private LocationRepository repo;
	@Autowired
	ServletContext sc;
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	}
	
	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location,ModelMap modelMapd) {
		Location locationSaved = service.saveLocation(location);
		String msg = "Location Saved with ID : "+location.getId();
		modelMapd.addAttribute("msg",msg);
		try {
		emailUtil.sendMail("yashtestuser1@gmail.com", "Location Save", "Location saved Sucessfully!");
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return "createLocation";
		
	}
	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelMapd) {
		List<Location> locations = service.getAll();
		modelMapd.addAttribute("locations",locations);
		return "displayLocations";
	}
	
	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") int id,ModelMap modelMapd) {
		Location location = service.getLocationById(id);
		service.deleteLocation(location);
		List<Location> locations = service.getAll();
		modelMapd.addAttribute("locations",locations);
		return "displayLocations";
	}
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id,ModelMap modelMapd) {
		Location location = service.getLocationById(id);
		modelMapd.addAttribute("location",location);
		return "editLocation";
		
	}
	
	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location location,ModelMap modelMapd) {
			service.updateLocation(location);
			List<Location> locations = service.getAll();
			modelMapd.addAttribute("locations",locations);
		return "displayLocations";
	}
	@RequestMapping("/generateReport")
	public String generateReport() {
		String path = sc.getRealPath("/");
		List<Object[]> data = repo.findTypeandTypeCount();
		reportUtilobj.generatePieChart(path, data);
		return "report";
	}
}
