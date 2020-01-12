package com.cinema.mvc.dao;

import java.util.List;
import java.util.Map;

import com.cinema.mvc.dao.entities.Cinema;
import com.cinema.mvc.dashboard.ListFilm;
 
public interface DashboardDao {
 
	List<List<Map<Object, Object>>> getHistjsChartData();
	List<List<Map<Object, Object>>> getPiejsChartData();
	List<ListFilm> findAll();
	List<ListFilm> listCine();
	
}