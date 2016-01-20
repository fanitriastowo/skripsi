package com.skripsi.beni.apps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.skripsi.beni.apps.service.MetodeService;

@Controller
@RequestMapping("/spk")
public class SPKController {
	
	@Autowired
	private MetodeService metodeService;

	/**
	 * buka halaman daftar metode untuk selanjutnya dihitung
	 * 
	 * @return mav
	 */
	@RequestMapping
	public ModelAndView halamanSPK() {
		ModelAndView mav = new ModelAndView("spk");
		mav.addObject("metodes", metodeService.tampilSemuaMetode());
		return mav;
	}
}
