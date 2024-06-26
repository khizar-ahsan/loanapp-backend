package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.CustomerDetails;
import com.example.demo.model.Documents;
import com.example.demo.model.Email;
import com.example.demo.model.EnquiryModel;
import com.example.demo.serviceI.CustomerServicei;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@CrossOrigin("*")
public class CustomerController {
	
	@Autowired 
	private CustomerServicei csi;
	
	
	@PostMapping("/customerData")
	public CustomerDetails CustomerDetails(@RequestBody CustomerDetails cd)
	{
		
		return 	csi.saveCustomer(cd);	 
	}
	
	@PostMapping(value="/regCustomer",consumes ={MediaType.MULTIPART_FORM_DATA_VALUE})
	public CustomerDetails createDocuments
	                 (@RequestPart ("text") String json, 
	                  @RequestPart ("pan") MultipartFile panCard,
	                  @RequestPart ("incomeProf") MultipartFile incomeProof,
	                  @RequestPart ("aadhar") MultipartFile aadharCard,
	                  @RequestPart ("profile") MultipartFile photo,
	                  @RequestPart ("signature") MultipartFile signature,
	                  @RequestPart ("passBook") MultipartFile bankPassBook)
	                  
 {
		CustomerDetails cd = new CustomerDetails();
		Email email = new Email();
		ObjectMapper om = new ObjectMapper();
		try
		{
			cd = om.readValue(json, CustomerDetails.class);
			cd.getDoc().setAadharCard(aadharCard.getBytes());
			cd.getDoc().setBankPassBook(bankPassBook.getBytes());
			cd.getDoc().setIncomeProof(incomeProof.getBytes());
			cd.getDoc().setPanCard(panCard.getBytes());
			cd.getDoc().setPhoto(photo.getBytes());
			cd.getDoc().setSignature(signature.getBytes());
			email.setToMail(cd.getEmail());
			email.setSubject("STAR LOAN FINANCE");
			email.setText("Thanks for enquiry and register with us...");
			csi.sendMail(email);
			csi.saveCustomer(cd);
			
		}
		catch (Exception e) {

			System.out.println(e.getMessage());
		}
		return cd;
//		return new ResponseEntity<String> ("Saved..!!" , HttpStatus.CREATED);
	
}

	@PostMapping("/simple-mail")
	public ResponseEntity<String> SendMail(@RequestBody Email mail)
	{
		csi.sendMail(mail);
		return new ResponseEntity<String>("Mail Send....!",HttpStatus.OK);
	}
}
