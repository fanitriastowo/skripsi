package com.skripsi.beni.apps.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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
import com.skripsi.beni.apps.entity.BobotSPK;
import com.skripsi.beni.apps.entity.Metode;
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
import com.skripsi.beni.apps.service.MetodeService;
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
	private MetodeService metodeService;
	
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
		
		// ambil semua metode (Pure Metode tanpa perhitungan)
		List<Metode> metodes = metodeService.tampilSemuaMetode(); 
		
		// Ambil bobot dari database entah sudah di rubah atau belum
		Bobot bobot = bobotService.getOneById();
		
		// Set Ke Integer
		BobotSPK bobotSpk = new BobotSPK();
        bobotSpk.setTanggal(new Date());
        bobotSpk.setBobotFasilitas(bobot.getFasilitas().intValue());
        bobotSpk.setBobotJumlahSiswa(bobot.getJumlahSiswa().intValue());
        bobotSpk.setBobotKemampuanSiswa(bobot.getKemampuanSiswa().intValue());
        bobotSpk.setBobotKemampuanGuru(bobot.getKemampuanGuru().intValue());
        bobotSpk.setBobotMateriPengajaran(bobot.getMateriPengajaran().intValue());
        bobotSpk.setBobotTujuanPengajaran(bobot.getTujuanPengajaran().intValue());
        bobotSpk.setBobotWaktuPembelajaran(bobot.getWaktuPembelajaran().intValue());
		
        // Ambil input dari guru dan set ke masing-masing entity
		JumlahSiswa jumlahSiswa = jumlahSiswaService.findOneById(dto.getJumlahSiswa());
		Fasilitas fasilitas = fasilitasService.findOneById(dto.getFasilitas());
		KemampuanSiswa kemampuanSiswa = kemampuanSiswaService.findOneById(dto.getKemampuanSiswa());
		KemampuanGuru kemampuanGuru = kemampuanGuruService.findOneById(dto.getKemampuanGuru());
		MateriPengajaran materiPengajaran = materiPengajaranService.findOneById(dto.getMateriPengajaran());
		TujuanPengajaran tujuanPengajaran = tujuanPengajaranService.findOneById(dto.getTujuanPengajaran());
		WaktuPembelajaran waktuPembelajaran = waktuPembelajaranService.findOneById(dto.getWaktuPembelajaran());

		// cari jumlahVectorS
		// siapkan variable jumlahVectorS untuk menyimpan jumlah dari vectorS
        Double jumlahVectorS = 0.0;
        for (Metode metodeVectorS : metodes) {
            
            Double pemangkatanFasilitas = Math.pow(metodeVectorS.getFasilitas().getPoint(), bobot.getnFasilitas());
            Double pemangkatanJumlahSiswa = Math.pow(metodeVectorS.getJumlahSiswa().getPoint(), bobot.getnJumlahSiswa());
            Double pemangkatanKemampuanSiswa = Math.pow(metodeVectorS.getKemampuanSiswa().getPoint(), bobot.getnKemampuanSiswa());
            Double pemangkatanKemampuanGuru = Math.pow(metodeVectorS.getKemampuanGuru().getPoint(), bobot.getnKemampuanGuru());
            Double pemangkatanMateriPengajaran = Math.pow(metodeVectorS.getMateriPengajaran().getPoint(), bobot.getnMateriPengajaran());
            Double pemangkatanTujuanPengajaran = Math.pow(metodeVectorS.getTujuanPengajaran().getPoint(), bobot.getnTujuanPengajaran());
            Double pemangkatanWaktuPembelajaran = Math.pow(metodeVectorS.getWaktuPembelajaran().getPoint(), bobot.getnWaktuPembelajaran());
            Double vectorS = pemangkatanFasilitas * pemangkatanJumlahSiswa * pemangkatanKemampuanSiswa * pemangkatanKemampuanGuru * 
                             pemangkatanMateriPengajaran * pemangkatanTujuanPengajaran * pemangkatanWaktuPembelajaran; 
            
            // jumlahkan jumlahVectorS saat ini dengan vectorS
            jumlahVectorS += vectorS;
        }
        
        // List untuk menyimpan daftarRangking
        List<SPK> daftarRangking = new ArrayList<>();
        
        // jumlahVectorS digunakan sebagai pembanding
        for (Metode metode : metodes) {
            
            Double pemangkatanFasilitas = Math.pow(metode.getFasilitas().getPoint(), bobot.getnFasilitas());
            Double pemangkatanJumlahSiswa = Math.pow(metode.getJumlahSiswa().getPoint(), bobot.getnJumlahSiswa());
            Double pemangkatanKemampuanSiswa = Math.pow(metode.getKemampuanSiswa().getPoint(), bobot.getnKemampuanSiswa());
            Double pemangkatanKemampuanGuru = Math.pow(metode.getKemampuanGuru().getPoint(), bobot.getnKemampuanGuru());
            Double pemangkatanMateriPengajaran = Math.pow(metode.getMateriPengajaran().getPoint(), bobot.getnMateriPengajaran());
            Double pemangkatanTujuanPengajaran = Math.pow(metode.getTujuanPengajaran().getPoint(), bobot.getnTujuanPengajaran());
            Double pemangkatanWaktuPembelajaran = Math.pow(metode.getWaktuPembelajaran().getPoint(), bobot.getnWaktuPembelajaran());
            Double vectorS = pemangkatanFasilitas * pemangkatanJumlahSiswa * pemangkatanKemampuanSiswa * pemangkatanKemampuanGuru * 
                             pemangkatanMateriPengajaran * pemangkatanTujuanPengajaran * pemangkatanWaktuPembelajaran; 
            
            // dari hasil penjumlahan vectorS didapat vectorV dengan membagi vectorS masing-masing object dengan jumlahVectorS
            SPK spk = new SPK();
            spk.setNamaMetode(metode.getMetode());
            spk.setTanggal(new Date());
            spk.setFasilitas(HelperUmum.angkaBelakangKoma(Math.pow(metode.getFasilitas().getPoint(), bobot.getnFasilitas()), 3));
            spk.setJumlahSiswa(HelperUmum.angkaBelakangKoma(Math.pow(metode.getJumlahSiswa().getPoint(), bobot.getnJumlahSiswa()), 3));
            spk.setKemampuanGuru(HelperUmum.angkaBelakangKoma(Math.pow(metode.getKemampuanGuru().getPoint(), bobot.getnKemampuanGuru()), 3));
            spk.setKemampuanSiswa(HelperUmum.angkaBelakangKoma(Math.pow(metode.getKemampuanSiswa().getPoint(), bobot.getnKemampuanSiswa()), 3));
            spk.setMateriPengajaran(HelperUmum.angkaBelakangKoma(Math.pow(metode.getMateriPengajaran().getPoint(), bobot.getnMateriPengajaran()), 3));
            spk.setTujuanPengajaran(HelperUmum.angkaBelakangKoma(Math.pow(metode.getTujuanPengajaran().getPoint(), bobot.getnTujuanPengajaran()), 3));
            spk.setWaktuPembelajaran(HelperUmum.angkaBelakangKoma(Math.pow(metode.getWaktuPembelajaran().getPoint(), bobot.getnTujuanPengajaran()), 3));
            spk.setVectorS(HelperUmum.angkaBelakangKoma(vectorS, 6));
            spk.setJumlahVectorS(HelperUmum.angkaBelakangKoma(jumlahVectorS, 6));
            spk.setVectorV(HelperUmum.angkaBelakangKoma(vectorS / jumlahVectorS, 6));
            spk.setBobotSpk(bobotSpk);
            daftarRangking.add(spk);
            
        }
        Collections.sort(daftarRangking);
        
        // Cari Double point yang diinputkan Guru dahulu
        Double pemangkatanJumlahSiswa = Math.pow(jumlahSiswa.getPoint(), bobot.getnJumlahSiswa());
        Double pemangkatanFasilitas = Math.pow(fasilitas.getPoint(), bobot.getnFasilitas());
        Double pemangkatanKemampuanSiswa = Math.pow(kemampuanSiswa.getPoint(), bobot.getnKemampuanSiswa());
        Double pemangkatanKemampuanGuru = Math.pow(kemampuanGuru.getPoint(), bobot.getnKemampuanGuru());
        Double pemangkatanMateriPengajaran = Math.pow(materiPengajaran.getPoint(), bobot.getnMateriPengajaran());
        Double pemangkatanTujuanPengajaran = Math.pow(tujuanPengajaran.getPoint(), bobot.getnTujuanPengajaran());
        Double pemangkatanWaktuPembelajaran = Math.pow(waktuPembelajaran.getPoint(), bobot.getnWaktuPembelajaran());
        Double vectorS = pemangkatanJumlahSiswa * pemangkatanFasilitas * pemangkatanKemampuanSiswa * pemangkatanKemampuanGuru *
                         pemangkatanMateriPengajaran * pemangkatanTujuanPengajaran * pemangkatanWaktuPembelajaran;
        Double vectorV = vectorS / jumlahVectorS;
        
        SPK hasilPerhitunganGuru = new SPK();
        hasilPerhitunganGuru.setJumlahSiswa(HelperUmum.angkaBelakangKoma(pemangkatanJumlahSiswa, 3));
        hasilPerhitunganGuru.setFasilitas(HelperUmum.angkaBelakangKoma(pemangkatanFasilitas, 3));
        hasilPerhitunganGuru.setKemampuanSiswa(HelperUmum.angkaBelakangKoma(pemangkatanKemampuanSiswa, 3));
        hasilPerhitunganGuru.setKemampuanGuru(HelperUmum.angkaBelakangKoma(pemangkatanKemampuanGuru, 3));
        hasilPerhitunganGuru.setMateriPengajaran(HelperUmum.angkaBelakangKoma(pemangkatanMateriPengajaran, 3));
        hasilPerhitunganGuru.setTujuanPengajaran(HelperUmum.angkaBelakangKoma(pemangkatanTujuanPengajaran, 3));
        hasilPerhitunganGuru.setWaktuPembelajaran(HelperUmum.angkaBelakangKoma(pemangkatanWaktuPembelajaran, 3));
        hasilPerhitunganGuru.setVectorV(HelperUmum.angkaBelakangKoma(vectorV, 6));
            
		
		/*
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
		*/
        
        // List untuk simpan hasil perhitungan tetapi yang kurang dari hasilPerhitunganGuru
        List<SPK> result = new ArrayList<>();
        for (SPK spk : daftarRangking) {
            if(spk.getVectorV() <= hasilPerhitunganGuru.getVectorV()) {
                result.add(spk);
            }
        }
		
		mav.addObject("hasilPerhitunganGuru", hasilPerhitunganGuru);
		mav.addObject("bobot", bobot);
		mav.addObject("daftarRangking", result);
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
