package com.skripsi.beni.apps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.skripsi.beni.apps.dto.MetodeDTO;
import com.skripsi.beni.apps.entity.Metode;
import com.skripsi.beni.apps.service.FasilitasService;
import com.skripsi.beni.apps.service.JumlahSiswaService;
import com.skripsi.beni.apps.service.KeaktifanService;
import com.skripsi.beni.apps.service.KondisiKelasService;
import com.skripsi.beni.apps.service.MetodeService;
import com.skripsi.beni.apps.service.PengajarService;

@Controller
@RequestMapping("/metode")
public class MetodeController {

	@Autowired
	private MetodeService metodeService;
	
	@Autowired
	private JumlahSiswaService jumlahSiswaService;
	
	@Autowired
	private KeaktifanService keaktifanService;
	
	@Autowired
	private KondisiKelasService kondisiService;
	
	@Autowired
	private FasilitasService fasilitasService;
	
	@Autowired
	private PengajarService pengajarService;

	@ModelAttribute("metode")
	public MetodeDTO construct() {
		return new MetodeDTO();
	}

	@RequestMapping
	public ModelAndView halamanMetode() {
		List<Metode> tampilSemuaMetode = metodeService.tampilSemuaMetode();
		ModelAndView modelAndView = new ModelAndView("metode");
		modelAndView.addObject("metodes", tampilSemuaMetode);
		modelAndView.addObject("lookUpJumlahSiswa", jumlahSiswaService.findAll());
		modelAndView.addObject("lookUpkeaktifanSiswa", keaktifanService.findAll());
		modelAndView.addObject("lookUpKondisiKelas", kondisiService.findAll());
		modelAndView.addObject("lookUpFasilitas", fasilitasService.findAll());
		modelAndView.addObject("lookUpPengajar", pengajarService.findAll());
		return modelAndView;
	}

	@RequestMapping("/add")
	public ModelAndView addMetode(@ModelAttribute("metode") MetodeDTO metodeDTO) {
		ModelAndView modelAndView = new ModelAndView("redirect:/metode");
		metodeService.save(metodeDTO);
		return modelAndView;
	}

	@RequestMapping("/prepare_edit/{id}")
	@ResponseBody
	public Metode prepareEdit(@PathVariable Long id) {
		Metode metode = new Metode();
		metode = metodeService.findOneById(id);
		return metode;
	}

	@RequestMapping("/edit")
	public ModelAndView submitEdit(@ModelAttribute("metode") MetodeDTO metodeDTO) {
		if (metodeDTO != null) {
			metodeService.update(metodeDTO);
		}
		ModelAndView modelAndView = new ModelAndView("redirect:/metode");
		return modelAndView;
	}

	@RequestMapping("/delete/{id}")
	public ModelAndView deleteMetode(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/metode");
		metodeService.delete(id);
		return modelAndView;
	}
}
