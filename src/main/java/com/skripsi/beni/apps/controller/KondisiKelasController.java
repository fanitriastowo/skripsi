package com.skripsi.beni.apps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
