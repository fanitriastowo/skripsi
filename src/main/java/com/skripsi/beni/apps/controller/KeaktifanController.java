package com.skripsi.beni.apps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.skripsi.beni.apps.entity.Keaktifan;
import com.skripsi.beni.apps.service.KeaktifanService;

@Controller
@RequestMapping("/keaktifan")
public class KeaktifanController {

	@Autowired
	private KeaktifanService keaktifanService;

	/**
	 * Construct Keaktifan Object untuk spring form binding
	 * 
	 * @return new Keaktifan
	 */
	@ModelAttribute
	public Keaktifan construct() {
		return new Keaktifan();
	}

	/**
	 * tampilkan halaman keaktifan dan data keaktifan dari database
	 * 
	 * @return modelAndView
	 */
	@RequestMapping
	public ModelAndView halamanKeaktifan() {
		ModelAndView modelAndView = new ModelAndView("keaktifan");
		List<Keaktifan> keaktifans = keaktifanService.findAll();
		modelAndView.addObject("keaktifans", keaktifans);
		return modelAndView;
	}

	/**
	 * save keaktifan dan redirect ke halaman keaktifan
	 * 
	 * @param keaktifan
	 * @return ModelAndView
	 */
	@RequestMapping("/save")
	public ModelAndView addKeaktifan(@ModelAttribute("keaktifan") Keaktifan keaktifan) {
		keaktifanService.save(keaktifan);
		return new ModelAndView("redirect:/keaktifan");
	}

	/**
	 * Delete Keaktifan berdasarkan id
	 * 
	 * @param Integer id
	 * @return ModelAndView
	 */
	@RequestMapping("/delete/{id}")
	public ModelAndView deleteKeaktifan(@PathVariable("id") Integer id) {
		keaktifanService.delete(id);
		return new ModelAndView("redirect:/keaktifan");
	}
}
