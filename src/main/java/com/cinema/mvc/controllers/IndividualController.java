package com.cinema.mvc.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cinema.mvc.dao.entities.Film;
import com.cinema.mvc.dao.entities.Individual;
import com.cinema.mvc.service.FilmService;
import com.cinema.mvc.service.IndividualService;
import com.cinema.mvc.service.PlayService;

@Controller
@RequestMapping(value="/individual")
public class IndividualController {
	
	@Autowired
	private IndividualService indService;
	
	@RequestMapping(value="/")
	public String individual(Model model) {
		
		List<Individual> individuals = indService.findAll();
		if (individuals == null) {
			individuals = new ArrayList<Individual>();
		}
		model.addAttribute("individuals", individuals);

		return "individual/individual";
	}
	
	
	@RequestMapping(value="/new",method=RequestMethod.GET)
	public String addIndividual(Model model) {
		Individual individual=new Individual();
		model.addAttribute("individual", individual);
		return "individual/addIndividual";
		
	}

	@RequestMapping(value="/save")
	public String save(@ModelAttribute("individual") @Valid Individual individual, BindingResult result,Model model,HttpServletRequest request) {
		 List<Individual> ind= indService.findByName2(individual.getName(),individual.getSurname());
			
		
		  if (result.hasErrors() ) {
	
	            return "individual/addIndividual";
	            
	        }
		  if (!ind.isEmpty()) {
			  
				request.setAttribute("MsgInd", "Already exist"); 
	            return "individual/addIndividual";
	            
	        }
		  
		if (individual!=null) {
			
			if(individual.getNumInd()!=null) {
				indService.edite(individual);
			} else {
				indService.add(individual);
			}
			 List<Individual> individual2= indService.findlist(individual.getNumInd());	
			
			model.addAttribute("individuals", individual2);
		
		}
	
		return "individual/addIndividual";
		
	}
	@RequestMapping(value="/update/{numInd}")
	public String updateIndividual(Model model, @PathVariable Long numInd){
		
		if(numInd!=null) {
			Individual individual=indService.findById(numInd);
		
		if (individual!=null) {
			model.addAttribute("individual", individual);
		}
		
		}
		return "individual/addIndividual";
		
	}
	
	@RequestMapping(value="/delete/{numInd}")
	public String deleteIndividual(Model model, @PathVariable Long numInd){
		
		if(numInd!=null) {
			Individual individual=indService.findById(numInd);
			
								if (individual!=null) {
									indService.delete(numInd);
								}
								
						}
		return "redirect:/individual/";
		
	}
	
}
