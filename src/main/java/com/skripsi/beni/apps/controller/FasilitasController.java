package com.skripsi.beni.apps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FasilitasController {
	
	@RequestMapping("/fasilitas")
	public ModelAndView halamanFasilitas() {
		ModelAndView modelAndView = new ModelAndView("fasilitas");

		return modelAndView;
	}
}
