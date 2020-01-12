package com.cinema.mvc.service;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cinema.mvc.dao.FilmDAO;
import com.cinema.mvc.dao.FilmDAOImpl;
import com.cinema.mvc.dao.entities.Cinema;
import com.cinema.mvc.dao.entities.Film;
import com.cinema.mvc.dao.entities.Individual;


@Transactional
public class FilmServiceImpl implements FilmService {

	private FilmDAO dao;
	@Override
	public void add(Film e) {
		dao.add(e);

	}

	@Override
	public Film edite(Film e) {
		// TODO Auto-generated method stub
		return dao.edite(e);
	}

	@Override
	public List<Film> findlist(Long id) {
		// TODO Auto-generated method stub
		return dao.findlist(id);
	}
	
	@Override
	public List<Film> findlistBy() {
		// TODO Auto-generated method stub
		return dao.findlistBy();
	}
	@Override
	public List<Film> findByName2(String id1){
		// TODO Auto-generated method stub
		return dao.findByName2( id1);
	}
	
	@Override
	public void delete(Long id) {
		dao.delete(id);

	}

	@Override
	public List<Film> findAll() {
		return dao.findAll();
	}

	@Override
	public Film findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	public FilmDAO getDao() {
		return dao;
	}

	public void setDao(FilmDAO dao) {
		this.dao = dao;
	}

}
