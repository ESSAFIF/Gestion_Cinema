package com.cinema.mvc.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cinema.mvc.dao.IndividualDAO;
import com.cinema.mvc.dao.entities.Individual;

@Transactional
public class IndividualServiceImpl implements IndividualService {

	private IndividualDAO dao;
	@Override
	public void add(Individual e) {
		dao.add(e);

	}

	@Override
	public Individual edite(Individual e) {
		// TODO Auto-generated method stub
		return dao.edite(e);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);

	}

	@Override
	public List<Individual> findAll() {
		return dao.findAll();
	}

	@Override
	public Individual findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<Individual> findlist(Long id) {
		// TODO Auto-generated method stub
		return dao.findlist(id);
	}

	@Override
	public List<Individual> findByName2(String id1,String id2){
		// TODO Auto-generated method stub
		return dao.findByName2( id1, id2);
	}
	public IndividualDAO getDao() {
		return dao;
	}

	public void setDao(IndividualDAO dao) {
		this.dao = dao;
	}

}
