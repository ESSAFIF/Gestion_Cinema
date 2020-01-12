package com.cinema.mvc.dao;

import java.util.List;

import com.cinema.mvc.dao.entities.Individual;

public interface IndividualDAO {
	public void add(Individual e);
	public Individual edite(Individual e);
	public void delete(Long id);

	public List<Individual> findAll();
	
	public Individual findById(Long id);	
	public  List<Individual> findByName2(String id1,String id2);
	
	public List<Individual> findlist(Long id);
}
