package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;


import com.example.demo.model.EnquiryModel;
import com.example.demo.repo.EnquiryRepository;
import com.example.demo.serviceI.EnquiryServicei;

@Service
public class EnquiryServiceImpl implements EnquiryServicei {
	
	@Autowired
	EnquiryRepository er;
	
	
	

	@Override
	public void saveEnquiryData(EnquiryModel em) {
		// TODO Auto-generated method stub
		er.save(em);
		
	}

	@Override
	public List<EnquiryModel> getData() {
		// TODO Auto-generated method stub
		return (List<EnquiryModel>) er.findAll() ;
	}

	@Override
	public EnquiryModel getEnquiryById(int id) {
		// TODO Auto-generated method stub
		
Optional<EnquiryModel> idEnq = er.findById(id);
		
		EnquiryModel e = idEnq.get();
		return e;
		
	}

	@Override
	public EnquiryModel updateEnquiry(int id, EnquiryModel e) {
		// TODO Auto-generated method stub
		Optional<EnquiryModel> updateEnq = er.findById(id);
		return er.save(e);
	}

	@Override
	public void deleteEnquiryById(int id) {
		// TODO Auto-generated method stub
		Optional<EnquiryModel> deleteEnq = er.findById(id);
		
		er.deleteById(id);
		
	}

	@Override
	public List<EnquiryModel> getByCibilStatus(String cibilStatus) {
		
		return er.findByCibilStatus(cibilStatus);
	}


}
