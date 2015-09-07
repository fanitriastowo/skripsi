package com.skripsi.beni.apps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.skripsi.beni.apps.entity.Metode;
import com.skripsi.beni.apps.service.MetodeService;

@Controller
public class MetodeController {
	
	@Autowired
	private MetodeService metodeService;

	@RequestMapping("/metode")
	public ModelAndView halamanMetode() {
		List<Metode> tampilSemuaMetode = metodeService.tampilSemuaMetode();
		ModelAndView modelAndView = new ModelAndView("metode");
		modelAndView.addObject("metodes", tampilSemuaMetode);
		return modelAndView;
	}	
}
