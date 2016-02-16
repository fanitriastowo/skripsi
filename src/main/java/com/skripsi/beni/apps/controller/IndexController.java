package com.skripsi.beni.apps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skripsi.beni.apps.dto.MetodeSearchResultDTO;
import com.skripsi.beni.apps.entity.Bobot;
import com.skripsi.beni.apps.entity.PerhitunganTerakhir;
import com.skripsi.beni.apps.entity.SPK;
import com.skripsi.beni.apps.entity.kriteria.Fasilitas;
import com.skripsi.beni.apps.entity.kriteria.JumlahSiswa;
import com.skripsi.beni.apps.entity.kriteria.KemampuanGuru;
import com.skripsi.beni.apps.entity.kriteria.KemampuanSiswa;
import com.skripsi.beni.apps.entity.kriteria.MateriPengajaran;
import com.skripsi.beni.apps.entity.kriteria.TujuanPengajaran;
import com.skripsi.beni.apps.entity.kriteria.WaktuPembelajaran;
import com.skripsi.beni.apps.helper.HelperUmum;
import com.skripsi.beni.apps.service.BobotService;
import com.skripsi.beni.apps.service.FasilitasService;
import com.skripsi.beni.apps.service.JumlahSiswaService;
import com.skripsi.beni.apps.service.KemampuanGuruService;
import com.skripsi.beni.apps.service.KemampuanSiswaService;
import com.skripsi.beni.apps.service.MateriPengajaranService;
import com.skripsi.beni.apps.service.PerhitunganTerakhirService;
import com.skripsi.beni.apps.service.TujuanPengajaranService;
import com.skripsi.beni.apps.service.WaktuPembelajaranService;

@Controller
public class IndexController {
		
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
	private BobotService bobotService;
	
	@Autowired
	private PerhitunganTerakhirService perhitunganTerakhirService;
	
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
	@RequestMapping(value = "/cari", method = RequestMethod.POST,
					produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Metode submitPencarianMetodeAjax(@RequestBody MetodeSearchResultDTO dto) {
		Metode metode = metodeService.findOneByProperty(dto);
		return metode;
	}
	*/
	
	@PreAuthorize("hasRole('ROLE_GURU')")
	@RequestMapping(value = "/hitung", method = RequestMethod.POST)
	public ModelAndView submitPencarianMetode(@ModelAttribute("metodeSearchResult") MetodeSearchResultDTO dto) {
		ModelAndView mav = new ModelAndView("cari_result");
		
		Bobot bobot = bobotService.getOneById();
		SPK hasilPerhitunganGuru = new SPK();
		
		JumlahSiswa jumlahSiswa = jumlahSiswaService.findOneById(dto.getJumlahSiswa());
		Fasilitas fasilitas = fasilitasService.findOneById(dto.getFasilitas());
		KemampuanSiswa kemampuanSiswa = kemampuanSiswaService.findOneById(dto.getKemampuanSiswa());
		KemampuanGuru kemampuanGuru = kemampuanGuruService.findOneById(dto.getKemampuanGuru());
		MateriPengajaran materiPengajaran = materiPengajaranService.findOneById(dto.getMateriPengajaran());
		TujuanPengajaran tujuanPengajaran = tujuanPengajaranService.findOneById(dto.getTujuanPengajaran());
		WaktuPembelajaran waktuPembelajaran = waktuPembelajaranService.findOneById(dto.getWaktuPembelajaran());
		
		List<PerhitunganTerakhir> listPerhitunganTerakhir = perhitunganTerakhirService.findAll();
		for (PerhitunganTerakhir perhitunganTerakhir : listPerhitunganTerakhir) {
			Double pemangkatanJumlahSiswa = Math.pow(jumlahSiswa.getPoint(), bobot.getnJumlahSiswa());
			Double pemangkatanFasilitas = Math.pow(fasilitas.getPoint(), bobot.getnFasilitas());
			Double pemangkatanKemampuanSiswa = Math.pow(kemampuanSiswa.getPoint(), bobot.getnKemampuanSiswa());
			Double pemangkatanKemampuanGuru = Math.pow(kemampuanGuru.getPoint(), bobot.getnKemampuanGuru());
			Double pemangkatanMateriPengajaran = Math.pow(materiPengajaran.getPoint(), bobot.getnMateriPengajaran());
			Double pemangkatanTujuanPengajaran = Math.pow(tujuanPengajaran.getPoint(), bobot.getnTujuanPengajaran());
			Double pemangkatanWaktuPembelajaran = Math.pow(waktuPembelajaran.getPoint(), bobot.getnWaktuPembelajaran());
			Double vectorS = pemangkatanJumlahSiswa * pemangkatanFasilitas * pemangkatanKemampuanSiswa * pemangkatanKemampuanGuru *
							 pemangkatanMateriPengajaran * pemangkatanTujuanPengajaran * pemangkatanWaktuPembelajaran;
			Double jumlahVectorS = perhitunganTerakhir.getJumlahVectorS();
			Double vectorV = vectorS / jumlahVectorS;
			
			hasilPerhitunganGuru.setJumlahSiswa(HelperUmum.angkaBelakangKoma(pemangkatanJumlahSiswa, 3));
			hasilPerhitunganGuru.setFasilitas(HelperUmum.angkaBelakangKoma(pemangkatanFasilitas, 3));
			hasilPerhitunganGuru.setKemampuanSiswa(HelperUmum.angkaBelakangKoma(pemangkatanKemampuanSiswa, 3));
			hasilPerhitunganGuru.setKemampuanGuru(HelperUmum.angkaBelakangKoma(pemangkatanKemampuanGuru, 3));
			hasilPerhitunganGuru.setMateriPengajaran(HelperUmum.angkaBelakangKoma(pemangkatanMateriPengajaran, 3));
			hasilPerhitunganGuru.setTujuanPengajaran(HelperUmum.angkaBelakangKoma(pemangkatanTujuanPengajaran, 3));
			hasilPerhitunganGuru.setWaktuPembelajaran(HelperUmum.angkaBelakangKoma(pemangkatanWaktuPembelajaran, 3));
			hasilPerhitunganGuru.setVectorV(HelperUmum.angkaBelakangKoma(vectorV, 6));
			
		}
		
		mav.addObject("hasilPerhitunganGuru", hasilPerhitunganGuru);
		mav.addObject("bobot", bobot);
		mav.addObject("daftarRangking", perhitunganTerakhirService.findAllByVectorVLessThanEqual(hasilPerhitunganGuru.getVectorV()));
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
