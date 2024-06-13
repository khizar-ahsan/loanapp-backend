package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.CustomerDetails;
import com.example.demo.model.EnquiryModel;
import com.example.demo.serviceI.CustomerServicei;

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
	
//	@PostMapping("/documents")
//	public ResponseEntity<String> creatDocuments
//	                 ( 
//	                  @RequestPart ("profile") MultipartFile profImage,
//	                  @RequestPart ("aadhar") MultipartFile aadharImage,
//	                  @RequestPart (value="pan",required = false) MultipartFile panImage)
// {
//		creatDocuments(profImage, aadharImage, panImage) createDocuments = csi.createUser(, profImage , aadharImage , panImage);
//		return new ResponseEntity<String> ("Saved..!!" , HttpStatus.CREATED);
//		
//}

}
