package com.cinema.mvc.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cinema.mvc.dao.entities.Individual;
import com.cinema.mvc.dao.entities.Users;

public class UserDAOImpl implements UserDAO {
	@PersistenceContext
	EntityManager em;
	private Class<Users> type;



	@Override
	public void add(Users e) {
		 em.persist(e);  


	}

	@Override
	public Users edite(Users e) {
		return em.merge(e);
	}

	@Override
	public void delete(Long id) {
		Users tab=em.getReference(Users.class,id);
		em.remove(tab);

		
	}

	@Override
	public List<Users> findAll() {
		
		Query query = em.createQuery("select t from users t");
		return  query.getResultList();

		
	}

	@Override
	public Users findById(Long id) {
	 	return em.find(Users.class, id);
	}


}