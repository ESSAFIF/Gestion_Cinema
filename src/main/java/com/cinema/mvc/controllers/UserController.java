package com.cinema.mvc.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.Validator;

import com.cinema.mvc.dao.entities.Film;
import com.cinema.mvc.dao.entities.Individual;
import com.cinema.mvc.dao.entities.Roles;
import com.cinema.mvc.dao.entities.Users;
import com.cinema.mvc.service.RoleService;
import com.cinema.mvc.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	 @Autowired
	    private UserService userService;
	 
	 @Autowired
	    private RoleService roleService;
	 
	 @RequestMapping(value="/")
	    public String userForm( Model model) {
			List<Users> users = userService.findAll();
			
			if (users == null) {
				users = new ArrayList<Users>();
			}
			model.addAttribute("users", users);
			
		List<Roles> roles = roleService.findAll();
			
			if (roles == null) {
				roles = new ArrayList<Roles>();
			}
			model.addAttribute("roles", roles);
			return "user/addUser";
	    }
	     
		
		@RequestMapping(value="/new",method=RequestMethod.GET)
		public String addUser(Model model) {
			List<Users> users=userService.findAll();
			Users user=new Users();
			if (users == null) {
				users = new ArrayList<Users>();
			}
			
			List<Roles> roles=roleService.findAll();
			
			if (roles == null) {
				roles = new ArrayList<Roles>();
			}
			model.addAttribute("user", user);
			model.addAttribute("users", users);
			model.addAttribute("roles", roles);
			
			return "user/addUser";
			
		}
		
		@RequestMapping(value="/save")
		public String save(@ModelAttribute("user") @Valid Users user,   BindingResult result, Model model) {
			
			  if (result.hasErrors()) {
					List<Roles> roles=roleService.findAll();
					List<Users> users=userService.findAll();

					model.addAttribute("roles", roles);
					model.addAttribute("users", users);
		            return "user/addUser";
		            
		        }
			  
			if (user!=null) {				
				if(user.getIdUser()!=null) {
					userService.edite(user);
					System.out.println("projectionpk exist" + user.getIdUser());
				} 
				
				else {
					userService.add(user);
					System.out.println("projectionpk not exist"  + user.getIdUser());
				}
				List<Roles> roles=roleService.findAll();
				model.addAttribute("roles", roles);
				List<Users> users=userService.findAll();
				model.addAttribute("users", users);
			}

			return "user/addUser";
			
		}
		
		@RequestMapping(value="/update/{idUser}")
		public String updateUser(Model model, @PathVariable Long idUser){
			
			if(idUser!=null) {
				Users user2=userService.findById(idUser);
				
				List<Roles> roles=roleService.findAll();
				
				if (roles == null) {
					roles = new ArrayList<Roles>();
				}
			
				List<Users> users=userService.findAll();
				
				if (users == null) {
					users = new ArrayList<Users>();
				}
				
		
				model.addAttribute("user", user2);
				model.addAttribute("roles", roles);
				model.addAttribute("users", users);
			}
			return "user/addUser";
			
		}
		
		@RequestMapping(value="/delete/{idUser}")
		public String deleteFilm(Model model, @PathVariable Long idUser){
			
			if(idUser!=null) {
				Users user=userService.findById(idUser);
					if (user!=null) {
										userService.delete(idUser);
									}
									
			}
			return "redirect:/user/new";
			
		}

}