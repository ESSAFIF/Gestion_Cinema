package com.cinema.mvc.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinema.mvc.LoginController;
import com.cinema.mvc.utils.ApplicationUtils;

@Controller

@RequestMapping(value="/home")

public class HomeController {
	
	@RequestMapping(value="/")
	public String home() {	
		
		return "home/home";
	}
}
