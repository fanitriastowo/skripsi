package com.skripsi.beni.apps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class KondisiController {
	
	@RequestMapping("/kondisi")
	public ModelAndView halamanKondisi() {
		ModelAndView modelAndView = new ModelAndView("kondisi");

		return modelAndView;
	}
}
