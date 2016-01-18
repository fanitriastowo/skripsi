package com.skripsi.beni.apps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.skripsi.beni.apps.entity.Pengajar;
import com.skripsi.beni.apps.service.PengajarService;

@Controller
@RequestMapping("/pengajar")
public class PengajarController {

	@Autowired
	private PengajarService pengajarService;

	/**
	 * Construct Pengajar Object untuk spring form binding
	 * 
	 * @return new Keaktifan
	 */
	@ModelAttribute
	public Pengajar construct() {
		return new Pengajar();
	}

	/**
	 * tampilkan halaman pengajar dan data kualitas pengajar dari database
	 * 
	 * @return modelAndView
	 */
	@RequestMapping
	public ModelAndView halamanPengajar() {
		ModelAndView modelAndView = new ModelAndView("pengajar");
		List<Pengajar> pengajars = pengajarService.findAll();
		modelAndView.addObject("pengajars", pengajars);
		return modelAndView;
	}

	/**
	 * save pengajar dan redirect ke halaman pengajar
	 * 
	 * @param Pengajar pengajar
	 * @return ModelAndView
	 */
	@RequestMapping("/save")
	public ModelAndView addPengajar(@ModelAttribute("pengajar") Pengajar pengajar) {
		pengajarService.save(pengajar);
		return new ModelAndView("redirect:/pengajar");
	}

	/**
	 * Delete Kualitas Pengajar berdasarkan id
	 * 
	 * @param Integer id
	 * @return ModelAndView
	 */
	@RequestMapping("/delete/{id}")
	public ModelAndView deletePengajar(@PathVariable("id") Long id) {
		pengajarService.delete(id);
		return new ModelAndView("redirect:/pengajar");
	}

	/**
	 * Ambil pengajar object dan convert ke JSON
	 * 
	 * @param Integer id
	 * @return Pengajar
	 */
	@RequestMapping("/prepare_update/{id}")
	@ResponseBody
	public Pengajar prepareUpdate(@PathVariable("id") Long id) {
		Pengajar pengajar = pengajarService.findOneById(id);
		return pengajar;
	}

	/**
	 * Update form pengajar dari bootstrap modal
	 * 
	 * @param Pengajar pengajar
	 * @return ModelAndView
	 */
	@RequestMapping("/update")
	public ModelAndView updatePengajar(@ModelAttribute("pengajar") Pengajar pengajar) {
		pengajarService.update(pengajar);
		return new ModelAndView("redirect:/pengajar");
	}
}
