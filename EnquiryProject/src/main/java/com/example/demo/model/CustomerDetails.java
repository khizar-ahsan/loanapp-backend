package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CustomerDetails {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private String customerName;
	private String dateOfBirth;
	private String gender;
	private String mariatalStatus;
	private double loanAmount;
	private String email;
	private long mobno;
	private String panno;
	private long aadharNo;
	private String address;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerBankDetails customerBankDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerProfession customerProfession;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Builder customerBuilder;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerPropertyDetails customerPropertyDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Ledger customerLedger;
	
	@OneToOne(cascade = CascadeType.ALL)
	private SanctionLetter customerSanctionLetter;
	
	
	
}
