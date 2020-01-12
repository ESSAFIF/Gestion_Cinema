package com.cinema.mvc.dao;

import java.util.List;

import com.cinema.mvc.dao.entities.Play;
import com.cinema.mvc.dao.entities.PlayPK;
import com.cinema.mvc.dao.entities.Projection;
import com.cinema.mvc.dao.entities.ProjectionPK;

public interface ProjectionDAO {
	public void add(Projection e);
	public Projection edite(Projection e);
	public void delete(ProjectionPK projectionpk);

	public List<Projection> findAll();
	public Projection findById(ProjectionPK projectionpk);
	public List<Projection> findlist(ProjectionPK projectionpk);
}
