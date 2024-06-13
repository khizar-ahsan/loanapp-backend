package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SanctionLetter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sanctionId;
	private String sanctionDate;
	private String applicantName;
	private Double loanAmountSanctioned;
	private Double rateOfInterest;
	private int loanTenure;
	private Double monthlyEmiAmount;
	private String termsAndCondition;
	@Lob
	@Column(length = 5000000)
	private byte[] sanctionLetter;
}
