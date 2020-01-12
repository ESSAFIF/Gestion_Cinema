package com.cinema.mvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cinema.mvc.dao.entities.Cinema;
import com.cinema.mvc.dao.entities.Film;
import com.cinema.mvc.dashboard.StatFilm;



public class StatFilmDAOImpl implements StatFilmDAO {
	@PersistenceContext
	EntityManager em;

	@Override
	public List<StatFilm> findAll() {
		
		Query query = em.createQuery("select t from statfilm t");
		return  query.getResultList();
		
	}
}