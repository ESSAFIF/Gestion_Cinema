package com.cinema.mvc.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cinema.mvc.dao.entities.Individual;
import com.cinema.mvc.dao.entities.Roles;

public class RoleDAOImpl implements RoleDAO {
	@PersistenceContext
	EntityManager em;
	private Class<Roles> type;



	@Override
	public void add(Roles e) {
		 em.persist(e);  


	}

	@Override
	public Roles edite(Roles e) {
		return em.merge(e);
	}

	@Override
	public void delete(Long id) {
		Roles tab=em.getReference(Roles.class,id);
		em.remove(tab);

		
	}

	@Override
	public List<Roles> findAll() {
		
		Query query = em.createQuery("select t from roles t");
		return  query.getResultList();

		
	}

	@Override
	public Roles findById(Long id) {
	 	return em.find(Roles.class, id);
	}


}