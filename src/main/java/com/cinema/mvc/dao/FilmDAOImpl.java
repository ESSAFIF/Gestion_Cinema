package com.cinema.mvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cinema.mvc.dao.entities.Cinema;
import com.cinema.mvc.dao.entities.Film;
import com.cinema.mvc.dao.entities.Individual;



public class FilmDAOImpl implements FilmDAO {
	@PersistenceContext
	EntityManager em;

	private Class<Film> film;
	@Override
	public void add(Film e) {
			em.persist(e);  
		
	}

	@Override
	public Film edite(Film e) {
		return em.merge(e);
	}

	@Override
	public void delete(Long id) {
		Film tab=em.getReference(Film.class,id);
		em.remove(tab);

		
	}

	@Override
	public List<Film> findAll() {
		
		Query query = em.createQuery("select t from film t ");
		return  query.getResultList();
		
	}

	@Override
	public Film findById(Long id) {
	 	return em.find(Film.class, id);
	}
	@Override
	public  List<Film> findByName2(String id1) {
		String queryString = "select t from film t where t.title = :title ";
		
		Query query = em.createQuery(queryString)
		.setParameter("title", id1);
		return  query.getResultList();
				
	}
	@Override
	public List<Film> findlist(Long id) {
		Query query = em.createQuery("select t from film t where num_film ="+id);
		return  query.getResultList();
		
	}
	
	@Override
	public List<Film> findlistBy() {
		Query query = em.createQuery("select kind,count(*) as nb_film from film group by kind ");
		return  query.getResultList();
		
	}
	public Class<Film> getFilm() {
		return film;
	}

	public void setFilm(Class<Film> film) {
		this.film = film;
	}
}