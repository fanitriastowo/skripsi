package com.skripsi.beni.apps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.skripsi.beni.apps.entity.kriteria.TujuanPengajaran;
import com.skripsi.beni.apps.service.TujuanPengajaranService;

@Controller
@RequestMapping("/tujuan_pengajaran")
public class TujuanPengajaranController {
	
	@Autowired
	private TujuanPengajaranService tujuanPengajaranService;

	@ModelAttribute("tujuanPengajaran")
	public TujuanPengajaran constructModel() {
		return new TujuanPengajaran();
	}
	
	@RequestMapping
	public ModelAndView halamanTujuanPengajaran() {
		ModelAndView modelAndView = new ModelAndView("tujuan_pengajaran");
		List<TujuanPengajaran> tujuanPengajaran = tujuanPengajaranService.findAll();
		modelAndView.addObject("tujuanPengajarans", tujuanPengajaran);
		return modelAndView;
	}
	
	@RequestMapping("/save")
	public ModelAndView addTujuanPengajaran(@ModelAttribute("tujuanPengajaran") TujuanPengajaran tujuanPengajaran) {
		tujuanPengajaranService.save(tujuanPengajaran);
		return new ModelAndView("redirect:/tujuan_pengajaran");
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView deleteTujuanPengajaran(@PathVariable("id") Long id) {
		tujuanPengajaranService.delete(id);
		return new ModelAndView("redirect:/tujuan_pengajaran");
	}
	
	@RequestMapping("/prepare_update/{id}")
	@ResponseBody
	public TujuanPengajaran prepareUpdate(@PathVariable("id") Long id) {
		TujuanPengajaran tujuanPengajaran = tujuanPengajaranService.findOneById(id);
		return tujuanPengajaran;
	}
	
	@RequestMapping("/update")
	public ModelAndView updateTujuanPengajaran(@ModelAttribute("tujuanPengajaran") TujuanPengajaran tujuanPengajaran) {
		tujuanPengajaranService.update(tujuanPengajaran);
		return new ModelAndView("redirect:/tujuan_pengajaran");
	}
}
