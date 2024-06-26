package com.example.demo.model;

import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Email {

	private String toMail;
	@Value("{$spring.mail.username}")
	private String fromEmail;
	private String subject;
	private String text;
}
