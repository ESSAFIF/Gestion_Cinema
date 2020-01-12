package com.cinema.mvc.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.scribe.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cinema.mvc.dao.entities.Cinema;
import com.cinema.mvc.dao.entities.Film;
import com.cinema.mvc.dao.entities.Individual;
import com.cinema.mvc.dao.entities.Play;
import com.cinema.mvc.dao.entities.PlayPK;
import com.cinema.mvc.dao.entities.Projection;
import com.cinema.mvc.dao.entities.ProjectionPK;
import com.cinema.mvc.service.CinemaService;
import com.cinema.mvc.service.FilmService;

import com.cinema.mvc.service.IndividualService;
import com.cinema.mvc.service.PlayService;
import com.cinema.mvc.service.ProjectionService;

@Controller
@RequestMapping(value="/projection")
public class ProjectionController {
	
	@Autowired
	private FilmService filmService;
	
	@Autowired
	private ProjectionService projService;
	
	@Autowired
	private CinemaService cinemaService;
	
	@Autowired
	@Qualifier("projectionValidator")
	private Validator validator;
	
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(value="/")
	public String projection(Model model) {
		
		List<Projection> projections = projService.findAll();
		
		if (projections == null) {
			projections = new ArrayList<Projection>();
		}
		model.addAttribute("projections", projections);

		return "projection/projection";
	}
	
	
	@RequestMapping(value="/new",method=RequestMethod.GET)
	public String addProjection(Model model) {
		Projection projection=new Projection();
		List<Film> films=filmService.findAll();
	
		if (films == null) {
			films = new ArrayList<Film>();
		}
		
		List<Cinema> cinemas=cinemaService.findAll();
		
		if (cinemas == null) {
			cinemas = new ArrayList<Cinema>();
		}
		
		model.addAttribute("projection", projection);
		model.addAttribute("films", films);
		model.addAttribute("cinemas", cinemas);
		return "projection/addProjection";
		
	}

	@RequestMapping(value="/save")
	public String save(@ModelAttribute("projection") Projection projection,Model model, BindingResult result  ) {	
		new DateProjValidator().validate(projection, result);
		
		  if (result.hasErrors()) {
				List<Cinema> cinemas=cinemaService.findAll();
				model.addAttribute("cinemas", cinemas);
				List<Film> films=filmService.findAll();
				model.addAttribute("films", films);
	            return "projection/addProjection";
	            
	        }
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date DateVal = new java.util.Date();
		

    	Projection p=null;
    	ProjectionPK projectionpk = new ProjectionPK();
        try {
			DateVal = dateFormat.parse(projection.getProjectionPK().getDateStringIn());
			java.sql.Date sd = new java.sql.Date(DateVal.getTime());
			projectionpk.setNumCine(projection.getProjectionPK().getNumCine());
			projectionpk.setNumFilm(projection.getProjectionPK().getNumFilm());			
			projectionpk.setPdate(sd);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
			p=projService.findById(projectionpk);
			
			if(p!=null) {
				
				System.out.println("projectionpk exist");

				projService.edite(p);
				List<Projection> projection2= projService.findlist(projectionpk);				
				model.addAttribute("proj", projection2);
	
				}else {
					
					p=new Projection();
					p.setProjectionPK(projectionpk);
					projService.add(p);
					List<Projection> projection2= projService.findlist(projectionpk);				
					model.addAttribute("proj", projection2);
					System.out.println("projectionpk not exist");
				}
			
			
			
			List<Cinema> cinemas=cinemaService.findAll();
			model.addAttribute("cinemas", cinemas);
			List<Film> films=filmService.findAll();
			model.addAttribute("films", films);
			
			return "projection/addProjection";
		
	}
	@RequestMapping(value="/update/{id1},{id2},{id3}")
	public String updateProjection(Model model, @PathVariable long id1,  @PathVariable long id2,  @PathVariable String id3,HttpServletRequest request){

		Projection projection=null;
		ProjectionPK projectionpk = new ProjectionPK();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date DateVal = new java.util.Date();
		
        try {
			DateVal = dateFormat.parse(id3);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	java.sql.Date sd = new java.sql.Date(DateVal.getTime());
		projectionpk.setNumCine(id1);
		projectionpk.setNumFilm(id2);			
		projectionpk.setPdate(sd);
		projection=projService.findById(projectionpk);
		 System.out.println("existebien");
    	 System.out.println("existebien: " +id1 + id2 +id3);
    	 System.out.println("date: " +id3 +DateVal +sd );
		List<Cinema> cinemas=cinemaService.findAll();
		
		if (cinemas == null) {
			cinemas = new ArrayList<Cinema>();
		}
		List<Film> films=filmService.findAll();
		
		if (films == null) {
			films = new ArrayList<Film>();
		}
		
  
		projection.getProjectionPK().setDateStringIn(id3);
        	model.addAttribute("projection",projection);
     		model.addAttribute("cinemas", cinemas);
     		model.addAttribute("films", films);
     		request.setAttribute("idCine", projection.getCinema().getNumCine()); 
    		request.setAttribute("idFilm",projection.getFilm().getNumFilm());
		return "projection/addProjection";
		
	}
	
	@RequestMapping(value="/delete/{id1},{id2},{id3}")
	public String deletePlay(Model model, @PathVariable long id1,  @PathVariable long id2,  @PathVariable String id3){
		Projection p=null;
		ProjectionPK projectionpk = new ProjectionPK();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date DateVal = new java.util.Date();
        try {
			DateVal = dateFormat.parse(id3);
			java.sql.Date sd = new java.sql.Date(DateVal.getTime());
			projectionpk.setNumCine(id1);
			projectionpk.setNumFilm(id2);			
			projectionpk.setPdate(sd);
			p=projService.findById(projectionpk);
		
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if( p!=null) {
			projService.delete(projectionpk);
					}
								
						
		return "redirect:/projection/";
		
	}
	
}
