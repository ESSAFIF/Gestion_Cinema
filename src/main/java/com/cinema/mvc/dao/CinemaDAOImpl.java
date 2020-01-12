package com.cinema.mvc.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import com.cinema.mvc.dao.entities.Cinema;



public class CinemaDAOImpl implements CinemaDAO {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public void add(Cinema e) {
			em.persist(e);  
		
	}

	@Override
	public Cinema edite(Cinema e) {
		return em.merge(e);
	}

	@Override
	public void delete(Long id) {
		Cinema tab=em.getReference(Cinema.class,id);
		em.remove(tab);

		
	}

	@Override
	public List<Cinema> findAll() {
		Query query = em.createQuery("select t from cinema t");
		return  query.getResultList();
		
	}
	@Override
	public List<Cinema> findlist(Long id) {
		Query query = em.createQuery("select t from cinema t where num_cine ="+id);
		return  query.getResultList();
		
	}
	
	@Override
	public Cinema findById(Long id) {
	 	return em.find(Cinema.class, id);
	}

}
