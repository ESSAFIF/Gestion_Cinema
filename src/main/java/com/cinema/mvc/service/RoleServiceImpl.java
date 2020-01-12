package com.cinema.mvc.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cinema.mvc.dao.IndividualDAO;
import com.cinema.mvc.dao.RoleDAO;
import com.cinema.mvc.dao.entities.Individual;
import com.cinema.mvc.dao.entities.Roles;

@Transactional
public class RoleServiceImpl implements RoleService {

	private RoleDAO dao;
	@Override
	public void add(Roles e) {
		dao.add(e);

	}

	@Override
	public Roles edite(Roles e) {
		// TODO Auto-generated method stub
		return dao.edite(e);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);

	}

	@Override
	public List<Roles> findAll() {
		return dao.findAll();
	}

	@Override
	public Roles findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	public RoleDAO getDao() {
		return dao;
	}

	public void setDao(RoleDAO dao) {
		this.dao = dao;
	}

}
