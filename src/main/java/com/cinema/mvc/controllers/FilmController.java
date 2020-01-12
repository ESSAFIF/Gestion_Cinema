package com.cinema.mvc.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Date;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.scribe.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cinema.mvc.dao.entities.Film;
import com.cinema.mvc.dao.entities.Individual;
import com.cinema.mvc.dao.entities.Play;
import com.cinema.mvc.dao.entities.PlayPK;
import com.cinema.mvc.dao.entities.Roles;
import com.cinema.mvc.dao.entities.Users;
import com.cinema.mvc.export.FileExporter;
import com.cinema.mvc.service.FilmService;
import com.cinema.mvc.service.AmazonService;
import com.cinema.mvc.service.IndividualService;


@Controller
@RequestMapping(value="/film")
public class FilmController {
	
	@Autowired
	private FilmService filmService;
	
	@Autowired
	private IndividualService indService;

	
	@Autowired
	private AmazonService flickrService;
	
	private String fileLocation;
	
	@Autowired
	@Qualifier("filmExporter")
	private FileExporter export;

	@PersistenceContext
	EntityManager em;
	
	@RequestMapping(value="/")
	public String film(Model model,HttpServletRequest request) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		HttpSession session = request.getSession(true); //create a new session

	// put the UserDetails object here.
	session.setAttribute("userDetails", principal);

	
		List<Film> films = filmService.findAll();
		if (films == null) {
			films = new ArrayList<Film>();
		}
		model.addAttribute("films", films);

		return "film/film";
	}
	
	
	@RequestMapping(value="/new",method=RequestMethod.GET)
	public String addFilm(Model model) {
		Film film=new Film();
		List<Individual> individuals=indService.findAll();
	
	
		if (individuals == null) {
			individuals = new ArrayList<Individual>();
		}
		
		model.addAttribute("film", film);
		model.addAttribute("individuals", individuals);
		
		return "film/addFilm";
		
	}

	@RequestMapping(value="/save")
	public String save(@ModelAttribute("film") @Valid Film film, BindingResult result,Model model, MultipartFile file,HttpServletRequest request) {
		new DateFilmValidator().validate(film, result);
		
		  if (result.hasErrors()) {
				List<Individual> individuals=indService.findAll();

				model.addAttribute("individuals", individuals);
	            return "film/addFilm";
	            
	        }
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date DateVal = new java.util.Date();
			try {
		
					DateVal = dateFormat.parse(film.getDateStringIn());
					java.sql.Date sd = new java.sql.Date(DateVal.getTime());	
				film.setDateRelease(sd);
				System.out.println("DATE:" +sd);
				System.out.println("DATEin:" +film.getDateStringIn());

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
			
		    URL  photoUrl = null;
		if (film!=null) {
			
			if (file != null && !file.isEmpty()) {
				InputStream stream = null;
				try {
					stream = file.getInputStream();
					photoUrl = flickrService.savePhoto(stream, film.getTitle());
					String photoUrl2=photoUrl.toString();
					film.setPhoto(photoUrl2);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						stream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
	
			
			if(film.getNumFilm()!=null) {
				filmService.edite(film);
			} else {
				 List<Film> flm= filmService.findByName2(film.getTitle());
				if (!flm.isEmpty()) {
					List<Individual> individuals=indService.findAll();

					model.addAttribute("individuals", individuals);
					request.setAttribute("MsgFilm", "Already exist"); 
		            return "film/addFilm";
		            
		        }else {
				    filmService.add(film);
		    	}
			}
			 List<Film> film2= filmService.findlist(film.getNumFilm());	
				List<Individual> individuals=indService.findAll();

				model.addAttribute("individuals", individuals);
				model.addAttribute("films", film2);
		}
	
		return "film/addFilm";
		
	}
	@RequestMapping(value="/update/{numFilm}")
	public String updateFilm(Model model, @PathVariable Long numFilm,HttpServletRequest request){


		if(numFilm!=null) {
			Film film=filmService.findById(numFilm);
			
			List<Individual> individuals=indService.findAll();
			
			if (individuals == null) {
				individuals = new ArrayList<Individual>();
			}
		
		if (film!=null) {
			SimpleDateFormat format  = new SimpleDateFormat("dd-MM-yyyy");
			film.setDateStringIn( format.format(film.getDateRelease()));
			
			model.addAttribute("film", film);
			request.setAttribute("idDirector", film.getIndividual().getNumInd()); 
		}
		model.addAttribute("individuals", individuals);
		
		}
		return "film/addFilm";
		
	}
	
	@RequestMapping(value="/delete/{numFilm}")
	public String deleteFilm(Model model, @PathVariable Long numFilm){
		
		if(numFilm!=null) {
							Film film=filmService.findById(numFilm);
					
							
							  if (film!=null) {
			 
								  filmService.delete(numFilm);
								}
								
						}
		return "redirect:/film/";
		
	}
	
	@RequestMapping(value = "/export/") 
	public void exportFilms(HttpServletResponse response) {
		export.exportDataToExcel(response, null, null);
	}
	
	 @RequestMapping(method = RequestMethod.GET, value = "/excelProcessing")
	    public String getExcelProcessingPage() {
	        return "import/import_film";
	    }


	@RequestMapping("/uploadExcelFile")
	public String uploadFile(Model model, MultipartFile file) throws IOException {
	    InputStream in = file.getInputStream();
	    File currDir = new File("C:/wamp64/www/phpCurl/out/out.xlsx");
	    String path = currDir.getAbsolutePath();
	    fileLocation = path.substring(0, path.length() - 1) + file.getOriginalFilename();
	    FileOutputStream f = new FileOutputStream(fileLocation);
	    int ch = 0;
	    while ((ch = in.read()) != -1) {
	        f.write(ch);
	    }
	    f.flush();
	    f.close();
	    model.addAttribute("message", "File: " + file.getOriginalFilename() 
	      + " has been uploaded successfully!");
	    return "import/import_film";
	}
	
	  
}
