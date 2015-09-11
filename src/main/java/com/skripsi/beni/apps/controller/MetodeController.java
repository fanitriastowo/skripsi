package com.skripsi.beni.apps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.skripsi.beni.apps.entity.Metode;
import com.skripsi.beni.apps.service.MetodeService;

@Controller
@RequestMapping("/metode")
public class MetodeController {
	
	@Autowired
	private MetodeService metodeService;

	@RequestMapping
	public ModelAndView halamanMetode() {
		List<Metode> tampilSemuaMetode = metodeService.tampilSemuaMetode();
		ModelAndView modelAndView = new ModelAndView("metode");
		modelAndView.addObject("metodes", tampilSemuaMetode);
		return modelAndView;
	}
	
	@RequestMapping("/prepare_edit/{id}")
	@ResponseBody
	public Metode prepareEdit(@PathVariable Integer id) {
		Metode metode = new Metode();
		metode = metodeService.findOneById(id);
		return metode;
	}
}
