package com.skripsi.beni.apps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skripsi.beni.apps.entity.BobotSpk;
import com.skripsi.beni.apps.service.BobotService;
import com.skripsi.beni.apps.service.MetodeService;

@Controller
@RequestMapping("/spk")
public class SPKController {

	@Autowired
	private MetodeService metodeService;

	@Autowired
	private BobotService bobotService;

	@ModelAttribute("bobotModel")
	public BobotSpk constructBobotModel() {
		return new BobotSpk();
	}

	@RequestMapping(value = "/ubah_bobot", method = RequestMethod.POST)
	public ModelAndView ubahBobot(@ModelAttribute("bobotModel") BobotSpk bobotSpk) {
		bobotService.update(bobotSpk);
		return new ModelAndView("redirect:/spk");
	}

	/**
	 * buka halaman daftar metode untuk selanjutnya dihitung
	 * 
	 * @return mav
	 */
	@RequestMapping
	public ModelAndView halamanSPK() {
		ModelAndView mav = new ModelAndView("spk");
		BobotSpk bobot = bobotService.getOneById();
		mav.addObject("tempBobot", bobot);
		mav.addObject("metodes", metodeService.tampilSemuaMetode());
		return mav;
	}
}
