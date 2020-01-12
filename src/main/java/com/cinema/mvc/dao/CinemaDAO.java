package com.cinema.mvc.dao;

import java.util.List;

import com.cinema.mvc.dao.entities.Cinema;

public interface CinemaDAO {
	public void add(Cinema e);
	public Cinema edite(Cinema e);
	public void delete(Long id);

	public List<Cinema> findAll();
	public Cinema findById(Long id);
	public List<Cinema> findlist(Long id);


}
