package com.vendor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vendor.entities.Vendor;
import com.vendor.service.VendorService;

@Controller
public class VendorController {
	@Autowired
	private VendorService service;
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createVendor";
	}
	
	@RequestMapping("/saveVendor")
	public String saveVendor(@ModelAttribute("vendor") Vendor vendor,ModelMap modelMapd) {
		Vendor vendorSaved = service.saveVendor(vendor);
		String msg = "Vendor Saved with ID : "+vendor.getId();
		modelMapd.addAttribute("msg",msg);
		return "createVendor";
		
	}
	@RequestMapping("/displayVendor")
	public String displayVendor(ModelMap modelMapd) {
		List<Vendor> vendors = service.getAll();
		modelMapd.addAttribute("vendors",vendors);
		return "displayVendor";
	}
	
	@RequestMapping("/deleteVendor")
	public String deleteVendor(@RequestParam("id") int id,ModelMap modelMapd) {
		Vendor vendor = service.getVendorById(id);
		service.deleteVendor(vendor);
		List<Vendor> vendors = service.getAll();
		modelMapd.addAttribute("locations",vendors);
		return "displayVendor";
	}
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id,ModelMap modelMapd) {
		Vendor vendor = service.getVendorById(id);
		modelMapd.addAttribute("vendor",vendor);
		return "editVendor";
		
	}
	
	@RequestMapping("/updateVendor")
	public String updateVendor(@ModelAttribute("vendor") Vendor vendor,ModelMap modelMapd) {
			service.updateVendor(vendor);
			List<Vendor> vendors = service.getAll();
			modelMapd.addAttribute("vendors",vendors);
		return "displayVendor";
	}


}
