package com.cinema.mvc.service;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cinema.mvc.dao.PlayDAO;
import com.cinema.mvc.dao.entities.Cinema;
import com.cinema.mvc.dao.entities.Play;
import com.cinema.mvc.dao.entities.PlayPK;

@Transactional
public class PlayServiceImpl implements PlayService {

	private PlayDAO dao;
	@Override
	public void add(Play e) {
		dao.add(e);

	}

	@Override
	public Play edite(Play e) {
		// TODO Auto-generated method stub
		return dao.edite(e);
	}

	@Override
	public void delete(PlayPK playpk) {
		dao.delete(playpk);

	}

	@Override
	public List<Play> findAll() {
		return dao.findAll();
	}

	@Override
	public Play findById(PlayPK playpk) {
		// TODO Auto-generated method stub
		return dao.findById( playpk);
	}

	@Override
	public List<Play> findlist(PlayPK playpk) {
		// TODO Auto-generated method stub
		return dao.findlist(playpk);
	}
	public PlayDAO getDao() {
		return dao;
	}

	public void setDao(PlayDAO dao) {
		this.dao = dao;
	}


}
