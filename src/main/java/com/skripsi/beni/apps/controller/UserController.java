package com.skripsi.beni.apps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	@RequestMapping("/user")
	public ModelAndView halamanUser() {
		ModelAndView modelAndView = new ModelAndView("user");

		return modelAndView;
	}
}
