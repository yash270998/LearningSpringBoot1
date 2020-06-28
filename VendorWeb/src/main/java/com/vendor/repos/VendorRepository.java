package com.vendor.repos;

import org.springframework.data.repository.CrudRepository;

import com.vendor.entities.Vendor;

public interface VendorRepository extends CrudRepository<Vendor, Integer> {

}
