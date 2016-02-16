package com.skripsi.beni.apps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.skripsi.beni.apps.entity.kriteria.Fasilitas;
import com.skripsi.beni.apps.service.FasilitasService;

@Controller
@RequestMapping("/fasilitas")
public class FasilitasController {

	@Autowired
	private FasilitasService fasilitasService;

	/**
	 * Construct Fasilitas Object untuk spring form binding
	 * 
	 * @return new Fasilitas
	 */
	@ModelAttribute
	public Fasilitas construct() {
		return new Fasilitas();
	}

	/**
	 * tampilkan halaman fasilitas dan data Fasilitas dari database
	 * 
	 * @return modelAndView
	 */
	@RequestMapping
	public ModelAndView halamanFasilitas() {
		ModelAndView modelAndView = new ModelAndView("fasilitas");
		List<Fasilitas> fasilitases = fasilitasService.findAll();
		modelAndView.addObject("fasilitases", fasilitases);
		return modelAndView;
	}

	/**
	 * save Fasilitas dan redirect ke halaman fasilitas
	 * 
	 * @param Fasilitas fasilitas
	 * @return ModelAndView
	 */
	@RequestMapping("/save")
	public ModelAndView addFasilitas(@ModelAttribute("fasilitas") Fasilitas fasilitas) {
		fasilitasService.save(fasilitas);
		return new ModelAndView("redirect:/fasilitas");
	}

	/**
	 * Delete Fasilitas berdasarkan id
	 * 
	 * @param Integer id
	 * @return ModelAndView
	 */
	@RequestMapping("/delete/{id}")
	public ModelAndView deleteFasilitas(@PathVariable("id") Long id) {
		fasilitasService.delete(id);
		return new ModelAndView("redirect:/fasilitas");
	}
	
	/**
	 * Ambil Fasilitas object dan convert ke JSON
	 * 
	 * @param Integer id
	 * @return fasilitas
	 */
	@RequestMapping("/prepare_update/{id}")
	@ResponseBody
	public Fasilitas prepareUpdate(@PathVariable("id") Long id) {
		Fasilitas fasilitas = fasilitasService.findOneById(id);
		return fasilitas;
	}
	
	/**
	 * Update form Fasilitas dari bootstrap modal
	 * 
	 * @param Fasilitas fasilitas
	 * @return ModelAndView
	 */
	@RequestMapping("/update")
	public ModelAndView updateFasilitas(@ModelAttribute("fasilitas") Fasilitas fasilitas) {
		fasilitasService.update(fasilitas);
		return new ModelAndView("redirect:/fasilitas");
	}
}
