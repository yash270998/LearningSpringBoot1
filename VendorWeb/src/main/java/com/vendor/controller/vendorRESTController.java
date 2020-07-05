package com.vendor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendor.entities.Vendor;
import com.vendor.repos.VendorRepository;

@RestController
@RequestMapping("/vendors")
@CrossOrigin
public class vendorRESTController {
	@Autowired
	VendorRepository repository;
	
	
	@GetMapping
	public List<Vendor> getVendors(){
		return repository.findAll();
	}
	@PostMapping
	public Vendor createVendor(@RequestBody Vendor vendor) {
		return repository.save(vendor);
	}
	@PutMapping
	public Vendor updateVedor(@RequestBody Vendor vendor) {
		return repository.save(vendor);
	}
	@DeleteMapping("/{id}")
	public void deleteVendor(@PathVariable("id") int id) {
		repository.deleteById(id);
	}
	@GetMapping("/{id}")
	public Vendor getVendor(@PathVariable("id") int id) {
		return repository.findById(id).get();
	}
}
