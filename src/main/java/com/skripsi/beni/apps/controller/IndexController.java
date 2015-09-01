package com.skripsi.beni.apps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping("/")
	public ModelAndView indexPage() {
		ModelAndView modelAndView = new ModelAndView("home");
		return modelAndView;
	}
	
	@RequestMapping("/login")
	public ModelAndView loginPage() {
		return new ModelAndView("login");
	}
}
