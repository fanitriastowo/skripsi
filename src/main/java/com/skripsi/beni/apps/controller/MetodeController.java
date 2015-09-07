package com.skripsi.beni.apps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MetodeController {
	
	@RequestMapping("/metode")
	public ModelAndView halamanMetode() {
		ModelAndView modelAndView = new ModelAndView("metode");
		return modelAndView;
	}
}
