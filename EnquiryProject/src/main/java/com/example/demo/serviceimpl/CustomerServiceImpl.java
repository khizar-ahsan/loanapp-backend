package com.example.demo.serviceimpl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.CustomerDetails;
import com.example.demo.model.Documents;
import com.example.demo.model.Email;
import com.example.demo.repo.CustomerRepository;
import com.example.demo.serviceI.CustomerServicei;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CustomerServiceImpl implements CustomerServicei{
	
	@Value("${spring.mail.username}")
	private String fromMail;
	
	@Autowired private JavaMailSender javaMailSender;

	@Autowired
	CustomerRepository cr;
	
	@Override
	public CustomerDetails saveCustomer(CustomerDetails cd) {
		
		return cr.save(cd);
	}

	@Override
	public Documents createDocuments(String documentsJson, MultipartFile panCard, MultipartFile incomeProof,
			MultipartFile aadharCard, MultipartFile photo, MultipartFile signature, MultipartFile bankPassBook) {
		
		ObjectMapper mapper = new ObjectMapper();
		Documents documents = new Documents();
		
		try {
			documents =mapper.readValue(documentsJson, Documents.class);
			documents.getDocumentId();
			if(panCard !=null)
				documents.setPanCard(panCard.getBytes());
			if(incomeProof !=null)
				documents.setIncomeProof(incomeProof.getBytes());
			if(aadharCard !=null)
				documents.setAadharCard(aadharCard.getBytes());
			if(photo !=null)
				documents.setPhoto(photo.getBytes());
			if(signature !=null)
				documents.setSignature(signature.getBytes());
			if(bankPassBook !=null)
				documents.setBankPassBook(bankPassBook.getBytes());
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		cr.save();
		return documents;
	}

	@Override
	public void sendMail(Email mail) {
		
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom(fromMail);
		message.setTo(mail.getToMail());
		message.setSubject(mail.getSubject());
		message.setText(mail.getText());
		
		javaMailSender.send(message);
		
	}

}
