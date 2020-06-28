package com.vendor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendor.entities.Vendor;
import com.vendor.repos.VendorRepository;
@Service
public class VendorServiceImpl implements VendorService {
	@Autowired
	private VendorRepository repo;
	
	@Override
	public Vendor saveVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		return repo.save(vendor);
	}

	@Override
	public Vendor updateVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		return repo.save(vendor);
	}

	@Override
	public void deleteVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		repo.delete(vendor);

	}

	@Override
	public Vendor getVendorById(int id) {
		// TODO Auto-generated method stub
		Optional<Vendor> opt = repo.findById(id);
		Vendor vendor = new Vendor();
		if(opt.isPresent()){
			 vendor = opt.get();
			return vendor;
		}
		return vendor;
	}

	@Override
	public List<Vendor> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
