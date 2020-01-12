package com.cinema.mvc.service;

import java.util.List;

import com.cinema.mvc.dao.entities.Individual;
import com.cinema.mvc.dao.entities.Roles;

public interface RoleService {

	public void add(Roles e);
	public Roles edite(Roles e);
	public void delete(Long id);

	public List<Roles> findAll();
	public Roles findById(Long id);
}
