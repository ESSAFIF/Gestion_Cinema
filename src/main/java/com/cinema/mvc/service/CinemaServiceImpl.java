package com.cinema.mvc.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cinema.mvc.dao.CinemaDAO;
import com.cinema.mvc.dao.entities.Cinema;
import com.cinema.mvc.dao.entities.Individual;

@Transactional
public class CinemaServiceImpl implements CinemaService {

	private CinemaDAO dao;
	
	@Override
	public void add(Cinema e) {
		dao.add(e);

	}

	@Override
	public Cinema edite(Cinema e) {
		// TODO Auto-generated method stub
		return dao.edite(e);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);

	}

	@Override
	public List<Cinema> findAll() {
		return dao.findAll();
	}

	@Override
	public Cinema findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	public CinemaDAO getDao() {
		return dao;
	}

	public void setDao(CinemaDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<Cinema> findlist(Long id) {
		// TODO Auto-generated method stub
		return dao.findlist(id);
	}
}
