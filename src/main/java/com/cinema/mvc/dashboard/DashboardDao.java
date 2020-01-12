package com.cinema.mvc.dashboard;

import java.util.List;
import java.util.Map;

import com.cinema.mvc.dao.entities.Cinema;
 
public interface DashboardDao {
 
	List<List<Map<Object, Object>>> getHistjsChartData();
	List<List<Map<Object, Object>>> getPiejsChartData();
	List<ListFilm> findAll();
	List<ListFilm> listCine();
	
}