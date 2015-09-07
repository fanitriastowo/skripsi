package com.skripsi.beni.apps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PengajarController {

	@RequestMapping("/pengajar")
	public ModelAndView halamanPengajar() {
		ModelAndView modelAndView = new ModelAndView("pengajar");

		return modelAndView;
	}
}
