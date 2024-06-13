package com.example.demo.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.mail.SimpleMailMessage;

import com.example.demo.controller.CibilDemo;
import com.example.demo.model.EnquiryModel;

public interface EnquiryRepository extends CrudRepository<EnquiryModel, Integer> {

	public List<EnquiryModel> findByCibilStatus(String cibilStatus);
	
	
}
