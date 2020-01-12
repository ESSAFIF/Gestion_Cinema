package com.cinema.mvc.controllers;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cinema.mvc.dao.entities.Projection;

public class DateProjValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Projection.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
	
		 Projection proj = (Projection) target;

	      if(proj.getProjectionPK().getDateStringIn().isEmpty()) {
	          errors.rejectValue("projectionPK.DateStringIn", "date.invalid");
	}
	}

	
}
