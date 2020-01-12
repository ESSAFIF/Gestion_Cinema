package com.cinema.mvc.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cinema.mvc.dao.ProjectionDAO;
import com.cinema.mvc.dao.entities.Play;
import com.cinema.mvc.dao.entities.PlayPK;
import com.cinema.mvc.dao.entities.Projection;
import com.cinema.mvc.dao.entities.ProjectionPK;

@Transactional
public class ProjectionServiceImpl implements ProjectionService {

	private ProjectionDAO dao;
	@Override
	public void add(Projection e) {
		dao.add(e);

	}

	@Override
	public Projection edite(Projection e) {
		// TODO Auto-generated method stub
		return dao.edite(e);
	}

	@Override
	public void delete(ProjectionPK projectionpk) {
		dao.delete(projectionpk);

	}

	@Override
	public List<Projection> findAll() {
		return dao.findAll();
	}

	@Override
	public Projection findById( ProjectionPK projectionpk) {
		// TODO Auto-generated method stub
		return dao.findById(projectionpk);
	}

	@Override
	public List<Projection> findlist( ProjectionPK projectionpk) {
		// TODO Auto-generated method stub
		return dao.findlist(projectionpk);
	}
	public ProjectionDAO getDao() {
		return dao;
	}

	public void setDao(ProjectionDAO dao) {
		this.dao = dao;
	}


}
