package com.cinema.mvc.controllers;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cinema.mvc.dao.entities.Film;
import com.cinema.mvc.dao.entities.Projection;

public class DateFilmValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Film.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
	
		Film fl = (Film) target;

	      if(fl.getDateStringIn().isEmpty()) {
	          errors.rejectValue("DateStringIn", "date.invalid");
	}
	}

	
}
