package com.cinema.mvc.dao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cinema.mvc.dao.entities.Play;
import com.cinema.mvc.dao.entities.PlayPK;
import com.cinema.mvc.dao.entities.Projection;
import com.cinema.mvc.dao.entities.ProjectionPK;

public class ProjectionDAOImpl implements ProjectionDAO {

	@PersistenceContext
	EntityManager em;

	
	@Override
	public void add(Projection e) {
				em.persist(e);  		
	}

	@Override
	public Projection edite(Projection e) {
		return em.merge(e);
	}

	@Override
	public void delete(ProjectionPK projectionpk) {
		Projection tab=em.getReference(Projection.class,projectionpk);
		em.remove(tab);
		
	}
	
	@Override
	public List<Projection> findAll() {
		Query query = em.createQuery("select t from projection t");
		return  query.getResultList();
	}

	public Projection findById(ProjectionPK projectionpk) {
		return em.find(Projection.class, projectionpk);
	}


	@Override
	public List<Projection> findlist(ProjectionPK projectionpk) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date DateVal = new java.util.Date();
		try {
			DateVal = dateFormat.parse(projectionpk.getDateStringOut());
		} catch (ParseException e) {
			// TODO Auto-generated catch block		
			e.printStackTrace();
		}
		java.sql.Date sd = new java.sql.Date(DateVal.getTime());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String sdString = df.format(sd);
		Query query = em.createQuery("select t from projection t where num_film ="+projectionpk.getNumFilm()+" and num_cine="+projectionpk.getNumCine()+" and pdate='"+sdString+"'");
		return  query.getResultList();
		
	}

	

}

