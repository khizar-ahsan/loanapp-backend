package com.example.demo.controller;

import java.util.Random;

public class CibilDemo {

	public static void main(String[] args) {
		
		Random r = new Random();
		String cibilStatus = "";
		int no = r.nextInt(600, 950); //>650 => approve   <650 => rejected
		
		if(no>=650 && no<=950) {
			cibilStatus="Cibil_Approved";
			System.out.println(no+ " => " +cibilStatus);
		}
		else
		{
			cibilStatus="Cibil_Rejected";
			System.out.println(no+ " => " +cibilStatus);
		}
		
	}
}
