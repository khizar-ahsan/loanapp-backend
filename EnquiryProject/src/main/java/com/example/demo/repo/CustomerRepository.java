package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CustomerDetails;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerDetails,Integer>{

	

}
