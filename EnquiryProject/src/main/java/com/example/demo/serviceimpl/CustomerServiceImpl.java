package com.example.demo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CustomerDetails;
import com.example.demo.repo.CustomerRepository;
import com.example.demo.serviceI.CustomerServicei;

@Service
public class CustomerServiceImpl implements CustomerServicei{

	@Autowired
	CustomerRepository cr;
	
	@Override
	public CustomerDetails saveCustomer(CustomerDetails cd) {
		
		return cr.save(cd);
	}

}
