package com.skripsi.beni.apps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.skripsi.beni.apps.entity.KondisiKelas;
import com.skripsi.beni.apps.service.KondisiKelasService;

@Controller
@RequestMapping("/kondisi_kelas")
public class KondisiKelasController {

	@Autowired
	private KondisiKelasService kondisiKelasService;

	@ModelAttribute("kondisiKelas")
	public KondisiKelas constructModel() {
		return new KondisiKelas();
	}

	@RequestMapping
	public ModelAndView halamanKondisiKelas() {
		ModelAndView mav = new ModelAndView("kondisi_kelas");
		List<KondisiKelas> list = kondisiKelasService.findAll();
		mav.addObject("kondisiKelases", list);
		return mav;
	}

	@RequestMapping("/save")
	public ModelAndView saveKondisiKelas(@ModelAttribute("kondisiKelas") KondisiKelas kondisiKelas) {
		kondisiKelasService.save(kondisiKelas);
		return new ModelAndView("redirect:/kondisi_kelas");
	}

	@RequestMapping("/delete/{id}")
	public ModelAndView deleteKondisiKelas(@PathVariable("id") Long id) {
		kondisiKelasService.delete(id);
		return new ModelAndView("redirect:/kondisi_kelas");
	}

	@RequestMapping("/prepare_update/{id}")
	@ResponseBody
	public KondisiKelas prepareUpdate(@PathVariable("id") Long id) {
		KondisiKelas kondisiKelas = kondisiKelasService.findOneById(id);
		return kondisiKelas;
	}

	@RequestMapping("/update")
	public ModelAndView updateKondisiKelas(@ModelAttribute("kondisiKelas") KondisiKelas kondisiKelas) {
		kondisiKelasService.update(kondisiKelas);
		return new ModelAndView("redirect:/kondisi_kelas");
	}

}
