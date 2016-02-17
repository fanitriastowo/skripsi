package com.skripsi.beni.apps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.skripsi.beni.apps.entity.kriteria.MateriPengajaran;
import com.skripsi.beni.apps.service.MateriPengajaranService;

@Controller
@RequestMapping("/materi_pengajaran")
public class MateriPengajaranController {
	
	@Autowired
	private MateriPengajaranService materiPengajaranService;

	@ModelAttribute("materiPengajaran")
	public MateriPengajaran constructModel() {
		return new MateriPengajaran();
	}
	
	@RequestMapping
	public ModelAndView halamanMateriPengajaran() {
		ModelAndView modelAndView = new ModelAndView("materi_pengajaran");
		List<MateriPengajaran> materis = materiPengajaranService.findAll();
		modelAndView.addObject("materis", materis);
		return modelAndView;
	}
	
	@RequestMapping("/save")
	public ModelAndView addMateriPengajaran(@ModelAttribute("materiPengajaran") MateriPengajaran materiPengajaran) {
		materiPengajaranService.save(materiPengajaran);
		return new ModelAndView("redirect:/materi_pengajaran");
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView deleteMateriPengajaran(@PathVariable("id") Long id) {
		materiPengajaranService.delete(id);
		return new ModelAndView("redirect:/materi_pengajaran");
	}
	
	@RequestMapping("/prepare_update/{id}")
	@ResponseBody
	public MateriPengajaran prepareUpdate(@PathVariable("id") Long id) {
		MateriPengajaran materiPengajaran = materiPengajaranService.findOneById(id);
		return materiPengajaran;
	}
	
	@RequestMapping("/update")
	public ModelAndView updateMateriPengajaran(@ModelAttribute("materiPengajaran") MateriPengajaran materiPengajaran) {
		materiPengajaranService.update(materiPengajaran);
		return new ModelAndView("redirect:/materi_pengajaran");
	}
}
