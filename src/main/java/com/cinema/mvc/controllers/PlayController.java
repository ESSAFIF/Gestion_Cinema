package com.cinema.mvc.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.scribe.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cinema.mvc.dao.entities.Film;
import com.cinema.mvc.dao.entities.Individual;
import com.cinema.mvc.dao.entities.Play;
import com.cinema.mvc.dao.entities.PlayPK;
import com.cinema.mvc.service.FilmService;

import com.cinema.mvc.service.IndividualService;
import com.cinema.mvc.service.PlayService;

@Controller
@RequestMapping(value="/play")
public class PlayController {
	
	@Autowired
	private FilmService filmService;
	
	
	@Autowired
	private PlayService playService;
	
	@Autowired
	private IndividualService indService;
	
	@RequestMapping(value="/")
	public String film(Model model) {
		
		List<Play> plays = playService.findAll();
		if (plays == null) {
			plays = new ArrayList<Play>();
		}
		model.addAttribute("plays", plays);

		return "play/play";
	}
	
	
	@RequestMapping(value="/new",method=RequestMethod.GET)
	public String addPlay(Model model) {
		Play play=new Play();
		List<Individual> individuals=indService.findAll();
	
		if (individuals == null) {
			individuals = new ArrayList<Individual>();
		}
		
		List<Film> films=filmService.findAll();
		
		if (films == null) {
			films = new ArrayList<Film>();
		}
		
		model.addAttribute("play", play);
		model.addAttribute("films", films);
		model.addAttribute("individuals", individuals);
		return "play/addPlay";
		
	}

	@RequestMapping(value="/save")
	public String save(HttpServletRequest request,@ModelAttribute("play") @Valid Play play,Model model, BindingResult result ) {
	
		
		  if (result.hasErrors()) {
				List<Individual> individuals=indService.findAll();
				model.addAttribute("individuals", individuals);
				List<Film> films=filmService.findAll();
				model.addAttribute("films", films);
	            return "play/addPlay";
	            
	        }
			Play p=null;
			PlayPK playpk = new PlayPK();
			playpk.setNumInd(play.getPlayPK().getNumInd());
			playpk.setNumFilm(play.getPlayPK().getNumFilm());
			
			p=playService.findById(playpk);
			
			if(p!=null) {
				
				System.out.println("playPK exist:" +p.getRole());
				System.out.println("playPK exist:" +play.getRole());
				playService.edite(play);
				
	
				}else {
					
					playService.add(play);
					System.out.println("result:" + play.getRole() + play.getPlayPK().getNumFilm() + play.getPlayPK().getNumInd()  );
					System.out.println("playPK not exist");
				}
			List<Individual> individuals=indService.findAll();
			model.addAttribute("individuals", individuals);
			List<Film> films=filmService.findAll();
			model.addAttribute("films", films);
			 	List<Play> play2= playService.findlist(playpk);	
				
				model.addAttribute("plays", play2);
				return "play/addPlay";
		
	}
	@RequestMapping(value="/update/{id1},{id2}")
	public String updateFilm(Model model, @PathVariable long id1,  @PathVariable long id2,HttpServletRequest request){
		Play play=null;
		PlayPK playpk = new PlayPK();
		playpk.setNumInd(id1);
		playpk.setNumFilm(id2);
		play=playService.findById(playpk);
		
		if(play!=null) {
			
			List<Individual> individuals=indService.findAll();
			
			if (individuals == null) {
				individuals = new ArrayList<Individual>();
			}
			
		List<Film> films=filmService.findAll();
			
			if (films == null) {
				films = new ArrayList<Film>();
			}
		
		model.addAttribute("play", play);
		model.addAttribute("individuals", individuals);
		model.addAttribute("films", films);
		request.setAttribute("idActor", play.getIndividual().getNumInd()); 
		request.setAttribute("idFilm",play.getFilm().getNumFilm());
		}
		return "play/addPlay";
		
	}
	
	@RequestMapping(value="/delete/{id1},{id2}")
	public String deletePlay(Model model, @PathVariable long id1,  @PathVariable long id2){
		Play p=null;
		PlayPK playpk = new PlayPK();
		playpk.setNumInd(id1);
		playpk.setNumFilm(id2);
		p=playService.findById(playpk);
		if( p!=null) {
						playService.delete(playpk);
					}
								
						
		return "redirect:/play/";
		
	}
	
}
