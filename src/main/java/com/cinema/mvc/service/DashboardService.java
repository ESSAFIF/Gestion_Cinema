package com.cinema.mvc.service;

import java.util.List;
import java.util.Map;

import com.cinema.mvc.dashboard.ListFilm;
 
public interface DashboardService {
 
	List<List<Map<Object, Object>>> getHistjsChartData();
	List<List<Map<Object, Object>>> getPiejsChartData();
	List<ListFilm> findAll();
	List<ListFilm> listCine();
 
}