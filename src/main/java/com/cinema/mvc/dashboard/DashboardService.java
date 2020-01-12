package com.cinema.mvc.dashboard;

import java.util.List;
import java.util.Map;
 
public interface DashboardService {
 
	List<List<Map<Object, Object>>> getHistjsChartData();
	List<List<Map<Object, Object>>> getPiejsChartData();
	List<ListFilm> findAll();
	List<ListFilm> listCine();
 
}