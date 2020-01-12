package com.cinema.mvc.dao;


import java.util.List;

import com.cinema.mvc.dao.entities.Film;
import com.cinema.mvc.dao.entities.Roles;

public interface RoleDAO {
	
	public void add(Roles e);
	public Roles edite(Roles e);
	public void delete(Long id);

	public List<Roles> findAll();
	public Roles findById(Long id);
}
