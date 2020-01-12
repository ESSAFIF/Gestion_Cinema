package com.cinema.mvc.dao;


import java.util.List;

import com.cinema.mvc.dao.entities.Cinema;
import com.cinema.mvc.dao.entities.Film;
import com.cinema.mvc.dao.entities.Individual;

public interface FilmDAO {
	
	public void add(Film e);
	public Film edite(Film e);
	public void delete(Long id);

	public List<Film> findAll();
	public Film findById(Long id);
	public  List<Film> findByName2(String id1);
	public List<Film> findlist(Long id);
	public List<Film> findlistBy();
	
}
