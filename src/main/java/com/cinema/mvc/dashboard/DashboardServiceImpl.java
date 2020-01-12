package com.cinema.mvc.dashboard;

import java.util.List;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
 
import com.cinema.mvc.dashboard.DashboardDao;
 
public class DashboardServiceImpl implements DashboardService {
 
	@Autowired
	private DashboardDao dao;
 

 
	@Override
	public List<List<Map<Object, Object>>> getHistjsChartData() {
		return dao.getHistjsChartData();
	}

	@Override
	public List<List<Map<Object, Object>>> getPiejsChartData() {
		return dao.getPiejsChartData();
	}

	@Override
	public 	List<ListFilm> findAll() {
		return dao.findAll();
	}
	
	@Override
	public 	List<ListFilm> listCine() {
		return dao.listCine();
	}
	public DashboardDao getDao() {
		return dao;
	}

	public void setDao(DashboardDao dao) {
		this.dao = dao;
	}


}                   