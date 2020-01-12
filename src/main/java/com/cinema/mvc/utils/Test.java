package com.cinema.mvc.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.cinema.mvc.dao.entities.Individual;
import com.cinema.mvc.dao.entities.Play;
import com.cinema.mvc.dao.entities.PlayPK;
import com.cinema.mvc.dao.entities.Projection;
import com.cinema.mvc.dao.entities.ProjectionPK;
import com.cinema.mvc.service.IndividualService;
import com.cinema.mvc.service.ProjectionService;

public class Test {

	
	@PersistenceContext
	static
	EntityManager em;

	public static  void main(String[] args) {
		// TODO Auto-generated method stub
	
		Play play=new Play() ;
		PlayPK playpk = new PlayPK();
		playpk.setNumInd(1);
		playpk.setNumFilm(5);
		
	
		Long id1=(long) 01;
		Long id2=(long) 1;
		play=em.find(Play.class, playpk);
 
		
			 System.out.println("existebien: " +play );
        

	}
}
