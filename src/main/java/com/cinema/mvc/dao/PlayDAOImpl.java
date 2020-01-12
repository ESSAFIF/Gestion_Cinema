package com.cinema.mvc.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cinema.mvc.dao.entities.Cinema;
import com.cinema.mvc.dao.entities.Individual;
import com.cinema.mvc.dao.entities.Play;
import com.cinema.mvc.dao.entities.PlayPK;



public class PlayDAOImpl implements PlayDAO {

			@PersistenceContext
			EntityManager em;
			private Class<Play> ply;
			@Override
			public void add(Play e) {
						em.persist(e);  		
			}

			@Override
			public Play edite(Play e) {
				return em.merge(e);
			}

			@Override
			public void delete(PlayPK playpk) {
				Play tab=em.getReference(Play.class,playpk);
				em.remove(tab);
				
			}
			
			@Override
			public List<Play> findAll() {
				Query query = em.createQuery("select t from play t");
				return  query.getResultList();
				
			}

			@Override
			public Play findById(PlayPK playpk) {
				return em.find(Play.class, playpk);
			}
			
			@Override
			public List<Play> findlist(PlayPK playpk) {
				Query query = em.createQuery("select t from play t where num_film ="+playpk.getNumFilm()+" and num_ind="+playpk.getNumInd());
				return  query.getResultList();
				
			}

}

