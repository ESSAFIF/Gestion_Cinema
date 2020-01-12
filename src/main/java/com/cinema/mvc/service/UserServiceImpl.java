package com.cinema.mvc.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cinema.mvc.dao.IndividualDAO;
import com.cinema.mvc.dao.UserDAO;
import com.cinema.mvc.dao.entities.Individual;
import com.cinema.mvc.dao.entities.Users;

@Transactional
public class UserServiceImpl implements UserService {

	private UserDAO dao;
	
	@Override
	public void add(Users e) {
		dao.add(e);

	}

	@Override
	public Users edite(Users e) {
		// TODO Auto-generated method stub
		return dao.edite(e);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);

	}

	@Override
	public List<Users> findAll() {
		return dao.findAll();
	}

	@Override
	public Users findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	public UserDAO getDao() {
		return dao;
	}

	public void setDao(UserDAO dao) {
		this.dao = dao;
	}

}
