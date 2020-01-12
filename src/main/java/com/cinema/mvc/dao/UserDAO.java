package com.cinema.mvc.dao;


import java.util.List;

import com.cinema.mvc.dao.entities.Film;
import com.cinema.mvc.dao.entities.Users;

public interface UserDAO {
	
	public void add(Users e);
	public Users edite(Users e);
	public void delete(Long id);

	public List<Users> findAll();
	public Users findById(Long id);
}
