package com.skripsi.beni.apps.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.skripsi.beni.apps.dto.MetodeSpk;
import com.skripsi.beni.apps.entity.Bobot;
import com.skripsi.beni.apps.entity.BobotSPK;
import com.skripsi.beni.apps.entity.Metode;
import com.skripsi.beni.apps.entity.SPK;
import com.skripsi.beni.apps.helper.HelperUmum;
import com.skripsi.beni.apps.service.BobotService;
import com.skripsi.beni.apps.service.BobotSpkService;
import com.skripsi.beni.apps.service.MetodeService;
import com.skripsi.beni.apps.service.SPKService;

@Controller
@RequestMapping("/spk")
@SessionAttributes(value = { "metodes", "bobot", "daftarRangking" })
public class SPKController {

	@Autowired
	private MetodeService metodeService;

	@Autowired
	private BobotService bobotService;
	
	@Autowired
	private SPKService spkService;
	
	@Autowired
	private BobotSpkService bobotSpkService;

	@ModelAttribute("bobotModel")
	public Bobot constructBobotModel() {
		return new Bobot();
	}

	/**
	 * mengubah default bobot
	 * 
	 * @param bobot
	 * @return mav
	 */
	@RequestMapping(value = "/ubah_bobot", method = RequestMethod.POST)
	public ModelAndView ubahBobot(@ModelAttribute("bobotModel") Bobot bobot) {
		bobotService.update(bobot);
		return new ModelAndView("redirect:/spk");
	}

	/**
	 * buka halaman daftar metode untuk selanjutnya dihitung
	 * 
	 * @return mav
	 */
	@RequestMapping
	public ModelAndView halamanSPK(ModelMap modelMap) {
		
		ModelAndView mav = new ModelAndView("spk");
		Bobot bobot = bobotService.getOneById();
		
		if (modelMap.containsAttribute("bobot")) {
			modelMap.remove("bobot");
		}
		
		if (modelMap.containsAttribute("metodes")) {
			modelMap.remove("metodes");
		}
		
		mav.addObject("bobot", bobot);
		mav.addObject("metodes", metodeService.tampilSemuaMetode());

		return mav;
	}

	/**
	 * Perhitungan SPK step 1
	 * 
	 * @param metodes
	 * @return mav
	 */
	@RequestMapping("/step_1")
	public ModelAndView hitungSPKStep1(@ModelAttribute("metodes") List<Metode> metodes,
									   @ModelAttribute("bobot") Bobot bobot) {
		
		ModelAndView mav = new ModelAndView("step_1");
		List<MetodeSpk> listMetodeSpk = new ArrayList<>();
		
		// cek jika listMetodeSpk tidak kosong, maka kosongkan list terlebih dahulu
		if (!listMetodeSpk.isEmpty()) {
			listMetodeSpk.clear();
		}
		
		// inisial variable jumlahVectorS
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
			
			MetodeSpk metodeSpk = new MetodeSpk();
			metodeSpk.setNamaMetode(metode.getMetode());
			metodeSpk.setFasilitas(HelperUmum.angkaBelakangKoma(Math.pow(metode.getFasilitas().getPoint(), bobot.getnFasilitas()), 3));
			metodeSpk.setJumlahSiswa(HelperUmum.angkaBelakangKoma(Math.pow(metode.getJumlahSiswa().getPoint(), bobot.getnJumlahSiswa()), 3));
			metodeSpk.setKemampuanGuru(HelperUmum.angkaBelakangKoma(Math.pow(metode.getKemampuanGuru().getPoint(), bobot.getnKemampuanGuru()), 3));
			metodeSpk.setKemampuanSiswa(HelperUmum.angkaBelakangKoma(Math.pow(metode.getKemampuanSiswa().getPoint(), bobot.getnKemampuanSiswa()), 3));
			metodeSpk.setMateriPengajaran(HelperUmum.angkaBelakangKoma(Math.pow(metode.getMateriPengajaran().getPoint(), bobot.getnMateriPengajaran()), 3));
			metodeSpk.setTujuanPengajaran(HelperUmum.angkaBelakangKoma(Math.pow(metode.getTujuanPengajaran().getPoint(), bobot.getnTujuanPengajaran()), 3));
			metodeSpk.setWaktuPembelajaran(HelperUmum.angkaBelakangKoma(Math.pow(metode.getWaktuPembelajaran().getPoint(), bobot.getnTujuanPengajaran()), 3));
			metodeSpk.setVectorS(HelperUmum.angkaBelakangKoma(vectorS, 6));
			metodeSpk.setJumlahVectorS(HelperUmum.angkaBelakangKoma(jumlahVectorS, 6));
			listMetodeSpk.add(metodeSpk);
		}
		mav.addObject("metodeSpk", listMetodeSpk);
		
		return mav;
	}
	
	@RequestMapping("/step_2")
	public ModelAndView hituneSPKStep2(@ModelAttribute("metodes") List<Metode> metodes,
			   						   @ModelAttribute("bobot") Bobot bobot) {
		
		ModelAndView mav = new ModelAndView("step_2");
		List<MetodeSpk> listMetodeSpk = new ArrayList<>();
		if (!listMetodeSpk.isEmpty()) {
			listMetodeSpk.clear();
		}
		
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
			
			MetodeSpk metodeSpk = new MetodeSpk();
			metodeSpk.setNamaMetode(metode.getMetode());
			metodeSpk.setFasilitas(HelperUmum.angkaBelakangKoma(Math.pow(metode.getFasilitas().getPoint(), bobot.getnFasilitas()), 3));
			metodeSpk.setJumlahSiswa(HelperUmum.angkaBelakangKoma(Math.pow(metode.getJumlahSiswa().getPoint(), bobot.getnJumlahSiswa()), 3));
			metodeSpk.setKemampuanGuru(HelperUmum.angkaBelakangKoma(Math.pow(metode.getKemampuanGuru().getPoint(), bobot.getnKemampuanGuru()), 3));
			metodeSpk.setKemampuanSiswa(HelperUmum.angkaBelakangKoma(Math.pow(metode.getKemampuanSiswa().getPoint(), bobot.getnKemampuanSiswa()), 3));
			metodeSpk.setMateriPengajaran(HelperUmum.angkaBelakangKoma(Math.pow(metode.getMateriPengajaran().getPoint(), bobot.getnMateriPengajaran()), 3));
			metodeSpk.setTujuanPengajaran(HelperUmum.angkaBelakangKoma(Math.pow(metode.getTujuanPengajaran().getPoint(), bobot.getnTujuanPengajaran()), 3));
			metodeSpk.setWaktuPembelajaran(HelperUmum.angkaBelakangKoma(Math.pow(metode.getWaktuPembelajaran().getPoint(), bobot.getnTujuanPengajaran()), 3));
			metodeSpk.setVectorS(HelperUmum.angkaBelakangKoma(vectorS, 6));
			metodeSpk.setJumlahVectorS(HelperUmum.angkaBelakangKoma(jumlahVectorS, 6));
			metodeSpk.setVectorV(HelperUmum.angkaBelakangKoma(vectorS / jumlahVectorS, 6));
			listMetodeSpk.add(metodeSpk);
		}
		mav.addObject("metodeSpk", listMetodeSpk);
		
		return mav;
	}
	
	/**
	 * Simpan ke database kemudian redirect ke halaman final_step
	 * 
	 * @param metodes
	 * @param bobot
	 * @return
	 */
	@RequestMapping("/simpan")
	public ModelAndView hitungSPKStepFinal(@ModelAttribute("metodes") List<Metode> metodes,
			   							   @ModelAttribute("bobot") Bobot bobot, ModelMap model) {
		ModelAndView mav = new ModelAndView("redirect:/spk/final_step");
		
		if (model.containsAttribute("daftarRangking")) {
			model.remove("daftarRangking");
		}
		
		TreeSet<SPK> treeSet = new TreeSet<>();
		
		BobotSPK bobotSpk = new BobotSPK();
		bobotSpk.setTanggal(new Date());
		bobotSpk.setBobotFasilitas(bobot.getFasilitas().intValue());
		bobotSpk.setBobotJumlahSiswa(bobot.getJumlahSiswa().intValue());
		bobotSpk.setBobotKemampuanSiswa(bobot.getKemampuanSiswa().intValue());
		bobotSpk.setBobotKemampuanGuru(bobot.getKemampuanGuru().intValue());
		bobotSpk.setBobotMateriPengajaran(bobot.getMateriPengajaran().intValue());
		bobotSpk.setBobotTujuanPengajaran(bobot.getTujuanPengajaran().intValue());
		bobotSpk.setBobotWaktuPembelajaran(bobot.getWaktuPembelajaran().intValue());
		bobotSpkService.save(bobotSpk);
		
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
			
			SPK spk = new SPK();
			
			// dari hasil penjumlahan vectorS didapat vectorV dengan membagi vectorS masing-masing object dengan jumlahVectorS
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
			spkService.save(spk);
			treeSet.add(spk);
		}
		mav.addObject("daftarRangking", treeSet);
		return mav;
	}
	
	@RequestMapping("/final_step")
	public ModelAndView daftarRangkingTertinggi(Model model, @ModelAttribute("daftarRangking") TreeSet<SPK> treeSet) {
		ModelAndView mav = new ModelAndView("final_step");
		mav.addObject("bobot", bobotService.getOneById());
		mav.addObject("daftarRangking", treeSet);
		return mav;
	}
	
	
}
