package com.skripsi.beni.apps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.skripsi.beni.apps.entity.kriteria.KemampuanGuru;
import com.skripsi.beni.apps.service.KemampuanGuruService;

@Controller
@RequestMapping("/kemampuan_guru")
public class KemampuanGuruController {

	@Autowired
	private KemampuanGuruService kemampuanGuruService;

	@ModelAttribute("kemampuanGuru")
	public KemampuanGuru construct() {
		return new KemampuanGuru();
	}

	@RequestMapping
	public ModelAndView halamanKemampuanGuru() {
		ModelAndView modelAndView = new ModelAndView("kemampuan_guru");
		List<KemampuanGuru> kemampuans = kemampuanGuruService.findAll();
		modelAndView.addObject("kemampuans", kemampuans);
		return modelAndView;
	}

	@RequestMapping("/save")
	public ModelAndView addKemampuanGuru(@ModelAttribute("kemampuanGuru") KemampuanGuru kemampuanGuru) {
		kemampuanGuruService.save(kemampuanGuru);
		return new ModelAndView("redirect:/kemampuan_guru");
	}

	@RequestMapping("/delete/{id}")
	public ModelAndView deleteKemampuanGuru(@PathVariable("id") Long id) {
		kemampuanGuruService.delete(id);
		return new ModelAndView("redirect:/kemampuan_guru");
	}
	
	@RequestMapping("/prepare_update/{id}")
	@ResponseBody
	public KemampuanGuru prepareUpdate(@PathVariable("id") Long id) {
		KemampuanGuru kemampuanGuru = kemampuanGuruService.findOneById(id);
		return kemampuanGuru;
	}
	
	@RequestMapping("/update")
	public ModelAndView updateFasilitas(@ModelAttribute("kemampuanGuru") KemampuanGuru kemampuanGuru) {
		kemampuanGuruService.update(kemampuanGuru);
		return new ModelAndView("redirect:/kemampuan_guru");
	}
}
