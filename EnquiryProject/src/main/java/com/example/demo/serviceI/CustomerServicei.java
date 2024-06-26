package com.example.demo.serviceI;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.CustomerDetails;
import com.example.demo.model.Documents;
import com.example.demo.model.Email;

public interface CustomerServicei {

	public CustomerDetails saveCustomer(CustomerDetails cd);

	public Documents createDocuments(String documentsJson, MultipartFile panCard, MultipartFile incomeProof,
			MultipartFile aadharCard, MultipartFile photo, MultipartFile signature, MultipartFile bankPassBook);

	public void sendMail(Email mail);

}
