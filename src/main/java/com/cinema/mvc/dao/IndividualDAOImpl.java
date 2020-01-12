package com.cinema.mvc.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cinema.mvc.dao.entities.Individual;

public class IndividualDAOImpl implements IndividualDAO {
	@PersistenceContext
	EntityManager em;
	private Class<Individual> type;



	@Override
	public void add(Individual e) {
		 em.persist(e);  


	}

	@Override
	public Individual edite(Individual e) {
		return em.merge(e);
	}

	@Override
	public void delete(Long id) {
		Individual tab=em.getReference(Individual.class,id);
		em.remove(tab);

		
	}

	@Override
	public List<Individual> findAll() {
		
		Query query = em.createQuery("select t from individual t");
		return  query.getResultList();

		
	}

	@Override
	public List<Individual> findlist(Long id) {
		
		Query query = em.createQuery("select t from individual t where num_ind ="+id);
		return  query.getResultList();

		
	}
	@Override
	public  List<Individual> findByName2(String id1,String id2) {
		String queryString = "select t from individual t where t.name = :name and t.surname= :surname";
		
		Query query = em.createQuery(queryString)
		.setParameter("name", id1)
		.setParameter("surname",id2);
		return  query.getResultList();
				
	}
	
	@Override
	public Individual findById(Long id) {
	 	return em.find(Individual.class, id);
	}


}