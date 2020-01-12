package com.cinema.mvc.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cinema.mvc.dao.entities.Film;
import com.cinema.mvc.dashboard.ListFilm;
import com.cinema.mvc.dashboard.StatCine;
import com.cinema.mvc.export.FileExporter;
import com.cinema.mvc.export.PdfExport;
import com.cinema.mvc.service.DashboardService;
import com.cinema.mvc.service.FilmService;
 
@Controller
@RequestMapping("/dashboard")
public class DashboardController {
 
	@Autowired
	private DashboardService dashboardService;
	@PersistenceContext
	EntityManager em;
	@Autowired
	private FilmService filmService;
	@Autowired
	@Qualifier("dashExporter")
	private PdfExport export;

	@RequestMapping(method = RequestMethod.GET)
	public String charts(ModelMap modelMap,Model model ) {
		List<List<Map<Object, Object>>> DataList1 = dashboardService.getHistjsChartData();
		modelMap.addAttribute("dataPointsList1", DataList1);
		List<List<Map<Object, Object>>> DataList2 = dashboardService.getPiejsChartData();
		modelMap.addAttribute("dataPointsList2", DataList2);
		List<ListFilm> films = dashboardService.findAll();
		model.addAttribute("films", films);
		List<String>  col = new ArrayList<String>();
		for(ListFilm si : films ){
		   col.add(si.getName());
		}
		
		
		Query query = em.createQuery("select t from statcine t");
		List<StatCine>distinctElements= query.getResultList();	
		model.addAttribute("distinctElements", distinctElements);

		return "dashboard/dashboard";
	}
 
	
	@RequestMapping(value = "/export/") 
	public void exportFilms(HttpServletResponse response) {
		export.buildPdfDocument(response, null);
	}
} 