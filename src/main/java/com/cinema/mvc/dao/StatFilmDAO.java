package com.cinema.mvc.dao;


import java.util.List;

import com.cinema.mvc.dao.entities.Cinema;
import com.cinema.mvc.dao.entities.Film;
import com.cinema.mvc.dashboard.StatFilm;

public interface StatFilmDAO {
	
	public List<StatFilm> findAll();
	
}
