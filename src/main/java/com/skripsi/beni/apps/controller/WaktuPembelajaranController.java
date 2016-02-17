package com.skripsi.beni.apps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.skripsi.beni.apps.entity.kriteria.WaktuPembelajaran;
import com.skripsi.beni.apps.service.WaktuPembelajaranService;

@Controller
@RequestMapping("/waktu_pembelajaran")
public class WaktuPembelajaranController {
	
	@Autowired
	private WaktuPembelajaranService waktuPembelajaranService;

	@ModelAttribute("waktuPembelajaran")
	public WaktuPembelajaran constructModel() {
		return new WaktuPembelajaran();
	}
	
	@RequestMapping
	public ModelAndView halamanWaktuPembelajaran() {
		ModelAndView modelAndView = new ModelAndView("waktu_pembelajaran");
		List<WaktuPembelajaran> waktuPembelajaran = waktuPembelajaranService.findAll();
		modelAndView.addObject("waktuPembelajarans", waktuPembelajaran);
		return modelAndView;
	}
	
	@RequestMapping("/save")
	public ModelAndView addWaktuPembelajaran(@ModelAttribute("waktuPembelajaran") WaktuPembelajaran waktuPembelajaran) {
		waktuPembelajaranService.save(waktuPembelajaran);
		return new ModelAndView("redirect:/waktu_pengajaran");
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView deleteWaktuPembelajaran(@PathVariable("id") Long id) {
		waktuPembelajaranService.delete(id);
		return new ModelAndView("redirect:/waktu_pembelajaran");
	}
	
	@RequestMapping("/prepare_update/{id}")
	@ResponseBody
	public WaktuPembelajaran prepareUpdate(@PathVariable("id") Long id) {
		WaktuPembelajaran waktuPembelajaran = waktuPembelajaranService.findOneById(id);
		return waktuPembelajaran;
	}
	
	@RequestMapping("/update")
	public ModelAndView updateWaktuPembelajaran(@ModelAttribute("waktuPembelajaran") WaktuPembelajaran waktuPembelajaran) {
		waktuPembelajaranService.update(waktuPembelajaran);
		return new ModelAndView("redirect:/waktu_pembelajaran");
	}
}
