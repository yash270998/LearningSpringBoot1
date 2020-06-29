package com.location.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.entities.Location;
import com.location.repos.LocationRepository;
@Service
public class LocationServiceImpl implements LocationService {
	@Autowired
	private LocationRepository repo;
	@Override
	public Location saveLocation(Location location) {
		
		return repo.save(location);
	}

	@Override
	public Location updateLocation(Location location) {

		return repo.save(location);
	}

	@Override
	public void deleteLocation(Location location) {
		// TODO Auto-generated method stub
		repo.delete(location);
	}

	@Override
	public Location getLocationById(int id) {
		Optional<Location> opt = repo.findById(id);
		Location loc = new Location();
		if(opt.isPresent()){
			 loc = opt.get();
			return loc;
		}
		return loc;
	}

	@Override
	public List<Location> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
