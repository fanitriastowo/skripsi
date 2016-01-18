package com.skripsi.beni.apps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.skripsi.beni.apps.entity.Kondisi;
import com.skripsi.beni.apps.service.KondisiService;

@Controller
@RequestMapping("/kondisi")
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
	
	/**
	 * Save new kondisi and redirect to kondisi view
	 * @param kondisi
	 * @return redirect:/kondisi
	 */
	@RequestMapping("/save")
	public ModelAndView saveKondisi(@ModelAttribute("kondisi") Kondisi kondisi) {
		kondisiService.save(kondisi);
		return new ModelAndView("redirect:/kondisi");
	}
	
	/**
	 * Delete Kondisi berdasarkan ID
	 * @param id
	 * @return redirect:/kondisi
	 */
	@RequestMapping("/delete/{id}")
	public ModelAndView deleteKondisi(@PathVariable("id") Long id) {
		kondisiService.delete(id);
		return new ModelAndView("redirect:/kondisi");
	}
	
	/**
	 * Ambil Fasilitas object dan convert ke JSON
	 * 
	 * @param Integer id
	 * @return fasilitas
	 */
	@RequestMapping("/prepare_update/{id}")
	@ResponseBody
	public Kondisi prepareUpdate(@PathVariable("id") Long id) {
		Kondisi kondisi = kondisiService.findOneById(id);
		return kondisi;
	}
	
	/**
	 * Update form Fasilitas dari bootstrap modal
	 * 
	 * @param Fasilitas fasilitas
	 * @return ModelAndView
	 */
	@RequestMapping("/update")
	public ModelAndView updateFasilitas(@ModelAttribute("kondisi") Kondisi kondisi) {
		kondisiService.update(kondisi);
		return new ModelAndView("redirect:/kondisi");
	}
}
