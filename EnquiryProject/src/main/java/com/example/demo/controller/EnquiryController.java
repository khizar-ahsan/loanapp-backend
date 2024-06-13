package com.example.demo.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EnquiryModel;
import com.example.demo.serviceI.EnquiryServicei;


@CrossOrigin("*")
@RestController
public class EnquiryController {
	
	@Autowired
	private EnquiryServicei esi;
	
	@GetMapping("/ftoe/{id}")
	public String changeData(@PathVariable int id)
	{
		EnquiryModel enquiryById = esi.getEnquiryById(id);
		enquiryById.setCibilStatus("forwarded");
		esi.saveEnquiryData(enquiryById);
		return "Forwarded to OE";
	}
	
	@GetMapping("/getByCibilStatus/{cibilStatus}")
	public List<EnquiryModel> getByCibiliStatus(@PathVariable String cibilStatus)
	{
		return esi.getByCibilStatus(cibilStatus);
	}
	
	@PostMapping("/saveData")
	public String saveEnquiryData(@RequestBody EnquiryModel em)
	{
		em.setCibilStatus("pending");
		esi.saveEnquiryData(em);
		
		return "Data Saved Successfully";
	}
   
	@GetMapping("/getData")
	public List<EnquiryModel> getData()
	{
		List<EnquiryModel> e=esi.getData();
		return e;
	}
	
	@GetMapping("/enquiry/{id}")
	public EnquiryModel exposeEnquiryModel(@PathVariable int id)
	{
		EnquiryModel e=esi.getEnquiryById(id);
		
		return e;
	}
	@PutMapping("/enquiry/{id}")
	public String updateEnquiry (@PathVariable("id") int id, @RequestBody EnquiryModel e)
	{
		EnquiryModel enq=esi.updateEnquiry(id,e);
		
		return "Updated Successfully....!!!";
		
	}
	@DeleteMapping("/enquiry/{id}")
	public String deleteEnquiry(@PathVariable int id)
	{
		esi.deleteEnquiryById(id);
		return "Enquiry Deleted";
	}
	
	@GetMapping("/checkCibil/{id}")
	public EnquiryModel getByCheckCibili(@PathVariable int id)
	{
		EnquiryModel enq = esi.getEnquiryById(id);
		Random r = new Random();
		String cibilStatus = "";
		int no = r.nextInt(600, 950); //>650 => approve   <650 => rejected
		
		if(no>=650 && no<=950) {
			cibilStatus="Cibil_Approved";
			System.out.println(no+ " => " +cibilStatus);
			enq.setCibilScore(no);
			enq.setCibilStatus(cibilStatus);
		}
		else
		{
			cibilStatus="Cibil_Rejected";
			System.out.println(no+ " => " +cibilStatus);
			enq.setCibilScore(no);
			enq.setCibilStatus(cibilStatus);
		}
		esi.saveEnquiryData(enq);
		return enq;
	}
	
	
}
