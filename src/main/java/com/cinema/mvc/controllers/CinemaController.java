package com.cinema.mvc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cinema.mvc.dao.entities.Cinema;
import com.cinema.mvc.dao.entities.Individual;
import com.cinema.mvc.service.CinemaService;
import com.cinema.mvc.service.IndividualService;

@Controller
@RequestMapping(value="/cinema")
public class CinemaController {
	
	@Autowired
	private CinemaService cineService;
	
	@RequestMapping(value="/")
	public String individual(Model model) {
		
		List<Cinema> cinemas = cineService.findAll();
		if (cinemas == null) {
			cinemas = new ArrayList<Cinema>();
		}
		model.addAttribute("cinemas", cinemas);

		return "cinema/cinema";
	}
	
	
	@RequestMapping(value="/new",method=RequestMethod.GET)
	public String addCinema(Model model) {
		Cinema cinema=new Cinema();
		model.addAttribute("cinema", cinema);
		return "cinema/addCinema";
		
	}

	@RequestMapping(value="/save")
	public String save(@ModelAttribute("cinema") @Valid Cinema cinema, BindingResult result,Model model ) {
		
		  if (result.hasErrors()) {
				
	            return "cinema/addCinema";
	            
	        }
		
		if (cinema!=null) {
			
			if(cinema.getNumCine()!=null) {
				cineService.edite(cinema);
			} else {
				cineService.add(cinema);
			}
			
			 List<Cinema> cinema2= cineService.findlist(cinema.getNumCine());	
				
				model.addAttribute("cinemas", cinema2);
		
		}
	
		return "cinema/addCinema";
		
	}
	@RequestMapping(value="/update/{numCine}")
	public String updateCinema(Model model, @PathVariable Long numCine){
		
		if(numCine!=null) {
			Cinema cinema=cineService.findById(numCine);
		
		if (cinema!=null) {
			model.addAttribute("cinema", cinema);
		}
		
		}
		return "cinema/addCinema";
		
	}
	
	@RequestMapping(value="/delete/{numCine}")
	public String deleteCinema(Model model, @PathVariable Long numCine){
		
		if(numCine!=null) {
			Cinema cinema=cineService.findById(numCine);
		
								if (cinema!=null) {
									cineService.delete(numCine);
								}
								
						}
		return "redirect:/cinema/";
		
	}
	
}
