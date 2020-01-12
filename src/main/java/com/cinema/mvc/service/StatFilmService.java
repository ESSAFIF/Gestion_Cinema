package com.cinema.mvc.service;

import java.util.List;

import com.cinema.mvc.dao.entities.Cinema;
import com.cinema.mvc.dao.entities.Film;
import com.cinema.mvc.dashboard.StatFilm;

public interface StatFilmService {

	public List<StatFilm> findAll();

}
