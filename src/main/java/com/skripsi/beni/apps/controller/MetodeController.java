package com.skripsi.beni.apps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.skripsi.beni.apps.dto.MetodeDTO;
import com.skripsi.beni.apps.entity.BobotSPK;
import com.skripsi.beni.apps.entity.Metode;
import com.skripsi.beni.apps.service.BobotSpkService;
import com.skripsi.beni.apps.service.FasilitasService;
import com.skripsi.beni.apps.service.JumlahSiswaService;
import com.skripsi.beni.apps.service.KemampuanGuruService;
import com.skripsi.beni.apps.service.KemampuanSiswaService;
import com.skripsi.beni.apps.service.MateriPengajaranService;
import com.skripsi.beni.apps.service.MetodeService;
import com.skripsi.beni.apps.service.SPKService;
import com.skripsi.beni.apps.service.TujuanPengajaranService;
import com.skripsi.beni.apps.service.WaktuPembelajaranService;

@Controller
@RequestMapping("/metode")
public class MetodeController {

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

	@Autowired
	private SPKService spkService;

	@Autowired
	private BobotSpkService bobotSpkService;

	@ModelAttribute("metode")
	public MetodeDTO construct() {
		return new MetodeDTO();
	}

	@PreAuthorize(value = "isAuthenticated()")
	@RequestMapping
	public ModelAndView halamanMetode() {
		List<Metode> tampilSemuaMetode = metodeService.tampilSemuaMetode();
		ModelAndView modelAndView = new ModelAndView("metode");
		modelAndView.addObject("metodes", tampilSemuaMetode);
		modelAndView.addObject("lookUpMateriPengajaran", materiPengajaranService.findAll());
		modelAndView.addObject("lookUpTujuanPengajaran", tujuanPengajaranService.findAll());
		modelAndView.addObject("lookUpWaktuPembelajaran", waktuPembelajaranService.findAll());
		modelAndView.addObject("lookUpFasilitas", fasilitasService.findAll());
		modelAndView.addObject("lookUpKemampuanGuru", kemampuanGuruService.findAll());
		modelAndView.addObject("lookUpJumlahSiswa", jumlahSiswaService.findAll());
		modelAndView.addObject("lookUpKemampuanSiswa", kemampuanSiswaService.findAll());
		return modelAndView;
	}

	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
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

	@RequestMapping("/prepare_edit_guru/{id}")
	@ResponseBody
	@PreAuthorize(value = "hasRole('ROLE_GURU')")
	public Metode prepareEditGuru(@PathVariable Long id) {
		Metode metode = new Metode();
		metode = metodeService.findOneById(id);
		return metode;
	}

	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView submitEdit(@ModelAttribute("metode") MetodeDTO metodeDTO) {
		if (metodeDTO != null) {
			metodeService.update(metodeDTO);
		}
		ModelAndView modelAndView = new ModelAndView("redirect:/metode");
		return modelAndView;
	}

	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@RequestMapping("/delete/{id}")
	public ModelAndView deleteMetode(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/metode");
		metodeService.delete(id);
		return modelAndView;
	}

	@PreAuthorize(value = "isAuthenticated()")
	@RequestMapping("/daftar_rangking")
	public ModelAndView daftarRangking() {
		ModelAndView mav = new ModelAndView("daftar_rangking");
		mav.addObject("daftarRangking", spkService.findAllMaxGroupByVectorV());
		return mav;
	}

	@PreAuthorize(value = "isAuthenticated()")
	@RequestMapping("/cetak_hasil/{id}")
	public String cetakHasil(@PathVariable("id") Long id, ModelMap modelMap) {
		BobotSPK bobotSpk = bobotSpkService.findOneById(id);
		modelMap.addAttribute("dataSource", spkService.findAllByTempBobotDesc(bobotSpk));
		return "hasilPerhitungan";
	}
}
