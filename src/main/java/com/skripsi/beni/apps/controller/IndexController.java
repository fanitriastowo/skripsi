package com.skripsi.beni.apps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skripsi.beni.apps.dto.MetodeSearchResultDTO;
import com.skripsi.beni.apps.service.FasilitasService;
import com.skripsi.beni.apps.service.JumlahSiswaService;
import com.skripsi.beni.apps.service.KemampuanGuruService;
import com.skripsi.beni.apps.service.KemampuanSiswaService;
import com.skripsi.beni.apps.service.MateriPengajaranService;
import com.skripsi.beni.apps.service.MetodeService;
import com.skripsi.beni.apps.service.TujuanPengajaranService;
import com.skripsi.beni.apps.service.WaktuPembelajaranService;

@Controller
public class IndexController {
	
	@Autowired
	private MetodeService metodeService;
	
	@Autowired
	private MateriPengajaranService materiPengajaranService;

	@Autowired
	private TujuanPengajaranService tujuanPengajaranService;

	@Autowired
	private WaktuPembelajaranService waktuPembelajaranService;

	@Autowired
	private JumlahSiswaService jumlahSiswaService;

	@Autowired
	private FasilitasService fasilitasService;

	@Autowired
	private KemampuanGuruService kemampuanGuruService;

	@Autowired
	private KemampuanSiswaService kemampuanSiswaService;
	
	@ModelAttribute("metodeSearchResult")
	public MetodeSearchResultDTO constructModel() {
		return new MetodeSearchResultDTO();
	}

	@RequestMapping("/")
	public ModelAndView indexPage() {
		ModelAndView modelAndView = new ModelAndView("home");
		return modelAndView;
	}
	
	@PreAuthorize("hasRole('ROLE_GURU')")
	@RequestMapping("/cari_metode")
	public ModelAndView halamanPencarianMetode() {
		ModelAndView modelAndView = new ModelAndView("cari_metode");
		modelAndView.addObject("lookUpMateriPengajaran", materiPengajaranService.findAll());
		modelAndView.addObject("lookUpTujuanPengajaran", tujuanPengajaranService.findAll());
		modelAndView.addObject("lookUpWaktuPembelajaran", waktuPembelajaranService.findAll());
		modelAndView.addObject("lookUpFasilitas", fasilitasService.findAll());
		modelAndView.addObject("lookUpKemampuanGuru", kemampuanGuruService.findAll());
		modelAndView.addObject("lookUpJumlahSiswa", jumlahSiswaService.findAll());
		modelAndView.addObject("lookUpKemampuanSiswa", kemampuanSiswaService.findAll());
		return modelAndView;
	}

	/*
	@PreAuthorize("hasRole('ROLE_GURU')")
	@RequestMapping(value = "/cari", method = RequestMethod.POST)
	@ResponseBody
	public Metode submitPencarianMetodeAjax(@ModelAttribute("metodeSearchResult") MetodeSearchResultDTO dto) {
		Metode metode = metodeService.findOneByProperty(dto);
		return metode;
	}
	*/
	
	@PreAuthorize("hasRole('ROLE_GURU')")
	@RequestMapping(value = "/cari", method = RequestMethod.POST)
	public ModelAndView submitPencarianMetode(@ModelAttribute("metodeSearchResult") MetodeSearchResultDTO dto) {
		ModelAndView mav = new ModelAndView("cari_result");
		mav.addObject("metode", metodeService.findOneByProperty(dto));
		return mav;
	}
	
	@RequestMapping("/login")
	public ModelAndView loginPage() {
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/loginfail")
	public ModelAndView loginFailPage(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("success", false);
		return new ModelAndView("redirect:/login");
	}
}
