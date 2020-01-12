package com.cinema.mvc.service;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cinema.mvc.dao.FilmDAO;
import com.cinema.mvc.dao.FilmDAOImpl;
import com.cinema.mvc.dao.StatFilmDAO;
import com.cinema.mvc.dao.entities.Cinema;
import com.cinema.mvc.dao.entities.Film;
import com.cinema.mvc.dashboard.StatFilm;


@Transactional
public class StatFilmServiceImpl implements StatFilmService {

	private StatFilmDAO dao;


	@Override
	public List<StatFilm> findAll() {
		return dao.findAll();
	}


	public StatFilmDAO getDao() {
		return dao;
	}

	public void setDao(StatFilmDAO dao) {
		this.dao = dao;
	}

}
