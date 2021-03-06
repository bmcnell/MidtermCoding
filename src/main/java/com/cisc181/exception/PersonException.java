package com.cisc181.exception;

import java.util.regex.Pattern;

import com.cisc181.core.Person;

public class PersonException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private Person person;
	
	public Person getPerson() {
		return person;
	}
	
	public PersonException(String message) {
		super(message);
	}
}
