package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CustomerDetails;
import com.example.demo.model.Documents;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerDetails,Integer>{

	

	

}
