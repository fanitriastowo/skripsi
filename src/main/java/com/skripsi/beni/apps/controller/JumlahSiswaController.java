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
	 * Construt new Kondisi
	 * 
	 * @return new Kondisi
	 */
	@ModelAttribute
	public Kondisi construct() {
		return new Kondisi();
	}

	/**
	 * Halaman Kondisi Kelas, Menampilkan daftar Kondisi 
	 * Kelas dari database
	 * 
	 * @return modelAndView
	 */
	@RequestMapping
	public ModelAndView halamanKondisi() {
		ModelAndView modelAndView = new ModelAndView("kondisi");
		List<Kondisi> kondisis = kondisiService.findAll();
		modelAndView.addObject("kondisis", kondisis);
		return modelAndView;
	}
	
	/**
	 * simpan kondisi dan redirect ke halaman kondisi
	 * 
	 * @return ModelAndView
	 */
	@RequestMapping("/save")
	public ModelAndView addKondisi(@ModelAttribute("kondisi") Kondisi kondisi) {
		kondisiService.save(kondisi);
		return new ModelAndView("redirect:/kondisi");
	}
	
	/**
	 * ambil object Kondisi dan convert ke JSON
	 * 
	 * @param id
	 * @return kondisi
	 */
	@RequestMapping("/prepare_update/{id}")
	@ResponseBody
	public Kondisi prepareUpdate(@PathVariable("id") Integer id) {
		Kondisi kondisi = kondisiService.findOneById(id);
		return kondisi;
	}
	
	/**
	 * submit form update dan redirect ke halaman Kondisi
	 * 
	 * @param kondisi
	 * @return ModelAndView
	 */
	@RequestMapping("/update")
	public ModelAndView updateKondisi(@ModelAttribute("kondisi") Kondisi kondisi) {
		kondisiService.update(kondisi);
		return new ModelAndView("redirect:/kondisi");
	}
	
	/**
	 * Hapus Kondisi Kelas dan redirect ke halaman kondisi
	 * 
	 * @param id
	 * @return modelAndView
	 */
	@RequestMapping("/delete/{id}")
	public ModelAndView deleteKondisi(@PathVariable("id") Integer id) {
		kondisiService.delete(id);
		return new ModelAndView("redirect:/kondisi");
	}
}
