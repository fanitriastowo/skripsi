package com.skripsi.beni.apps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import com.skripsi.beni.apps.entity.Kondisi;
import com.skripsi.beni.apps.service.KondisiService;

@Controller
@RequestMapping(value = "/kondisi")
public class KondisiController {

	@Autowired
	private KondisiService kondisiService;

	/**
	 * Construct Kondisi model
	 * 
	 * @return kondisi
	 */
	@ModelAttribute
	public Kondisi construct() {
		return new Kondisi();
	}

	/**
	 * Ambil semua kondisi dari database dan tampilkan di view
	 * 
	 * @return list of kondisis
	 */
	@RequestMapping
	public ModelAndView halamanKondisi() {
		ModelAndView modelAndView = new ModelAndView("kondisi");
		List<Kondisi> kondisis = kondisiService.findAll();
		modelAndView.addObject("kondisis", kondisis);
		return modelAndView;
	}
}
