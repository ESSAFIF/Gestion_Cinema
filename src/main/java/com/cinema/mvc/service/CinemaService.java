package com.cinema.mvc.service;

import java.util.List;

import com.cinema.mvc.dao.entities.Cinema;
import com.cinema.mvc.dao.entities.Individual;
import com.cinema.mvc.dao.entities.ProjectionPK;


public interface CinemaService {

	public void add(Cinema e);
	public Cinema edite(Cinema e);
	public void delete(Long id);

	public List<Cinema> findAll();
	public Cinema findById(Long id);
	public List<Cinema> findlist(Long id);
}
