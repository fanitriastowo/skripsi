package com.skripsi.beni.apps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class KeaktifanController {
	@RequestMapping("/keaktifan")
	public ModelAndView halamanKeaktifan() {
		ModelAndView modelAndView = new ModelAndView("keaktifan");

		return modelAndView;
	}
}
