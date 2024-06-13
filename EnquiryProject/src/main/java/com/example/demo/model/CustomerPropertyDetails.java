package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CustomerPropertyDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerPropertyId;
	private String customerPropertyLocation;
	private String customerPropertyCost;
	private String customerPropertyType; 

}
