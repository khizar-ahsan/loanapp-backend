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
public class Documents {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int documentId;
	@Lob
	@Column(length = 999999999)
	private byte[] panCard;
	@Lob 
	@Column(length = 999999999)
	private byte[] incomeProof;
	@Lob 
	@Column(length = 999999999)
	private byte[] aadharCard;
	@Lob 
	@Column(length = 999999999)
	private byte[] photo;
	@Lob 
	@Column(length = 999999999)
	private byte[] signature;
	@Lob 
	@Column(length = 999999999)
	private byte[] bankPassBook;

}
