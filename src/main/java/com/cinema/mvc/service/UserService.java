package com.cinema.mvc.service;

import java.util.List;

import com.cinema.mvc.dao.entities.Individual;
import com.cinema.mvc.dao.entities.Users;

public interface UserService {

	public void add(Users e);
	public Users edite(Users e);
	public void delete(Long id);

	public List<Users> findAll();
	public Users findById(Long id);
}
