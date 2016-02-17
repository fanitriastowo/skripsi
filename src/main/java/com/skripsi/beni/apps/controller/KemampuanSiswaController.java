package com.skripsi.beni.apps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.skripsi.beni.apps.entity.kriteria.KemampuanSiswa;
import com.skripsi.beni.apps.service.KemampuanSiswaService;

@Controller
@RequestMapping("/kemampuan_siswa")
public class KemampuanSiswaController {

	@Autowired
	private KemampuanSiswaService kemampuanSiswaService;

	@ModelAttribute("kemampuanSiswa")
	public KemampuanSiswa construct() {
		return new KemampuanSiswa();
	}

	@RequestMapping
	public ModelAndView halamanKemampuanSiswa() {
		ModelAndView modelAndView = new ModelAndView("kemampuan_siswa");
		List<KemampuanSiswa> kemampuans = kemampuanSiswaService.findAll();
		modelAndView.addObject("kemampuans", kemampuans);
		return modelAndView;
	}

	@RequestMapping("/save")
	public ModelAndView addKemampuanSiswa(@ModelAttribute("kemampuanSiswa") KemampuanSiswa kemampuanSiswa) {
		kemampuanSiswaService.save(kemampuanSiswa);
		return new ModelAndView("redirect:/kemampuan_siswa");
	}

	@RequestMapping("/delete/{id}")
	public ModelAndView deleteKemampuanSiswa(@PathVariable("id") Long id) {
		kemampuanSiswaService.delete(id);
		return new ModelAndView("redirect:/kemampuan_siswa");
	}
	
	@RequestMapping("/prepare_update/{id}")
	@ResponseBody
	public KemampuanSiswa prepareUpdate(@PathVariable("id") Long id) {
		KemampuanSiswa kemampuanSiswa = kemampuanSiswaService.findOneById(id);
		return kemampuanSiswa;
	}
	
	@RequestMapping("/update")
	public ModelAndView updateFasilitas(@ModelAttribute("kemampuanSiswa") KemampuanSiswa kemampuanSiswa) {
		kemampuanSiswaService.update(kemampuanSiswa);
		return new ModelAndView("redirect:/kemampuan_siswa");
	}
}
