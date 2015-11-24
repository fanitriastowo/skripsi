package com.skripsi.beni.apps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.skripsi.beni.apps.entity.JumlahSiswa;
import com.skripsi.beni.apps.service.JumlahSiswaService;

@Controller
@RequestMapping("/jumlah_siswa")
public class JumlahSiswaController {

	@Autowired
	private JumlahSiswaService jumlahSiswaService;
	
	/**
	 * Construct new JumlahSiswa
	 * 
	 * @return new JumlahSiswa
	 */
	@ModelAttribute
	public JumlahSiswa construct() {
		return new JumlahSiswa();
	}

	/**
	 * Halaman JumlahSiswa, Menampilkan daftar Point berdasarkan banyaknya siswa 
	 * 
	 * @return modelAndView
	 */
	@RequestMapping
	public ModelAndView halamanJumlahSiswa() {
		ModelAndView modelAndView = new ModelAndView("jumlah_siswa");
		List<JumlahSiswa> jumlahSiswas = jumlahSiswaService.findAll();
		modelAndView.addObject("jumlahSiswas", jumlahSiswas);
		return modelAndView;
	}
	
	/**
	 * simpan jumlah siswa dan redirect ke halaman jumlah_siswa
	 * 
	 * @return ModelAndView
	 */
	@RequestMapping("/save")
	public ModelAndView addJumlahSiswa(@ModelAttribute("jumlahSiswa") JumlahSiswa jumlahSiswa) {
		jumlahSiswaService.save(jumlahSiswa);
		return new ModelAndView("redirect:/jumlah_siswa");
	}
	
	/**
	 * ambil object JumlahSiswa dan convert ke JSON
	 * 
	 * @param id
	 * @return jumlahSiswa
	 */
	@RequestMapping("/prepare_update/{id}")
	@ResponseBody
	public JumlahSiswa prepareUpdate(@PathVariable("id") Integer id) {
		JumlahSiswa jumlahSiswa = jumlahSiswaService.findOneById(id);
		return jumlahSiswa;
	}
	
	/**
	 * submit form update dan redirect ke halaman JumlahSiswa
	 * 
	 * @param jumlahSiswa
	 * @return ModelAndView
	 */
	@RequestMapping("/update")
	public ModelAndView updateJumlahSiswa(@ModelAttribute("jumlahSiswa") JumlahSiswa jumlahSiswa) {
		jumlahSiswaService.update(jumlahSiswa);
		return new ModelAndView("redirect:/jumlah_siswa");
	}
	
	/**
	 * Hapus JumlahSiswa dan redirect ke halaman jumlah_siswa
	 * 
	 * @param id
	 * @return modelAndView
	 */
	@RequestMapping("/delete/{id}")
	public ModelAndView deleteKondisi(@PathVariable("id") Integer id) {
		jumlahSiswaService.delete(id);
		return new ModelAndView("redirect:/jumlah_siswa");
	}
}
