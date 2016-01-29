package com.skripsi.beni.apps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.skripsi.beni.apps.entity.KondisiSekolah;
import com.skripsi.beni.apps.service.KondisiSekolahService;

@Controller
@RequestMapping("/kondisi_sekolah")
public class KondisiSekolahController {

	@Autowired
	private KondisiSekolahService kondisiSekolahService;

	/**
	 * Construct Kondisi Sekolah model
	 * 
	 * @return kondisi
	 */
	@ModelAttribute(value = "kondisiSekolah")
	public KondisiSekolah construct() {
		return new KondisiSekolah();
	}

	/**
	 * Ambil semua kondisi Sekolah dari database dan tampilkan di view
	 * 
	 * @return list of kondisis
	 */
	@RequestMapping
	public ModelAndView halamanKondisiSekolah() {
		ModelAndView modelAndView = new ModelAndView("kondisi_sekolah");
		List<KondisiSekolah> kondisis = kondisiSekolahService.findAll();
		modelAndView.addObject("kondisis", kondisis);
		return modelAndView;
	}
	
	/**
	 * Save new kondisi sekolah and redirect to kondisi sekolah view
	 * @param kondisi sekolah
	 * @return redirect:/kondisi
	 */
	@RequestMapping("/save")
	public ModelAndView saveKondisi(@ModelAttribute("kondisiSekolah") KondisiSekolah kondisi) {
		kondisiSekolahService.save(kondisi);
		return new ModelAndView("redirect:/kondisi_sekolah");
	}
	
	/**
	 * Delete Kondisi sekolah berdasarkan ID
	 * @param id
	 * @return redirect:/kondisi_sekolah
	 */
	@RequestMapping("/delete/{id}")
	public ModelAndView deleteKondisi(@PathVariable("id") Long id) {
		kondisiSekolahService.delete(id);
		return new ModelAndView("redirect:/kondisi_sekolah");
	}
	
	/**
	 * Ambil Fasilitas object dan convert ke JSON
	 * 
	 * @param Integer id
	 * @return fasilitas
	 */
	@RequestMapping("/prepare_update/{id}")
	@ResponseBody
	public KondisiSekolah prepareUpdate(@PathVariable("id") Long id) {
		KondisiSekolah kondisi = kondisiSekolahService.findOneById(id);
		return kondisi;
	}
	
	/**
	 * Update form Kondisi Sekolah dari bootstrap modal
	 * 
	 * @param KondisiSekolah kondisiSekolah
	 * @return ModelAndView
	 */
	@RequestMapping("/update")
	public ModelAndView updateKondisiSekolah(@ModelAttribute("kondisiSekolah") KondisiSekolah kondisi) {
		kondisiSekolahService.update(kondisi);
		return new ModelAndView("redirect:/kondisi_sekolah");
	}
}
