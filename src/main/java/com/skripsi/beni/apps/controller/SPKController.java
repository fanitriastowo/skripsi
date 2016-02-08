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
import com.skripsi.beni.apps.entity.BobotSpk;
import com.skripsi.beni.apps.entity.Metode;
import com.skripsi.beni.apps.entity.SPK;
import com.skripsi.beni.apps.entity.TempBobot;
import com.skripsi.beni.apps.helper.HelperUmum;
import com.skripsi.beni.apps.service.BobotService;
import com.skripsi.beni.apps.service.MetodeService;
import com.skripsi.beni.apps.service.SPKService;
import com.skripsi.beni.apps.service.TempBobotService;

@Controller
@RequestMapping("/spk")
@SessionAttributes(value = { "metodes", "tempBobot", "daftarRangking" })
public class SPKController {

	@Autowired
	private MetodeService metodeService;

	@Autowired
	private BobotService bobotService;
	
	@Autowired
	private SPKService spkService;
	
	@Autowired
	private TempBobotService tempBobotService;

	@ModelAttribute("bobotModel")
	public BobotSpk constructBobotModel() {
		return new BobotSpk();
	}

	/**
	 * mengubah default bobot
	 * 
	 * @param bobotSpk
	 * @return mav
	 */
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
	public ModelAndView halamanSPK(ModelMap modelMap) {
		
		ModelAndView mav = new ModelAndView("spk");
		BobotSpk bobot = bobotService.getOneById();
		
		if (modelMap.containsAttribute("tempBobot")) {
			modelMap.remove("tempBobot");
			System.out.println("Temp Bobot DIhapus");
		}
		
		if (modelMap.containsAttribute("metodes")) {
			modelMap.remove("tempBobot");
			System.out.println("Metodes DIhapus");
		}
		
		mav.addObject("tempBobot", bobot);
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
									   @ModelAttribute("tempBobot") BobotSpk bobotSpk) {
		
		ModelAndView mav = new ModelAndView("step_1");
		List<MetodeSpk> listMetodeSpk = new ArrayList<>();
		
		// cek jika listMetodeSpk tidak kosong, maka kosongkan list terlebih dahulu
		if (!listMetodeSpk.isEmpty()) {
			listMetodeSpk.clear();
		}
		
		// inisial variable jumlahVectorS
		Double jumlahVectorS = 0.0;
		for (Metode metodeVectorS : metodes) {
			Double pemangkatanFasilitas = Math.pow(metodeVectorS.getFasilitas().getPoint(), bobotSpk.getnFasilitasBobot());
			Double pemangkatanJumlahSiswa = Math.pow(metodeVectorS.getJumlahSiswa().getPoint(), bobotSpk.getnJumlahSiswaBobot());
			Double pemangkatanKeaktifanSiswa = Math.pow(metodeVectorS.getKeaktifan().getPoint(), bobotSpk.getnKeaktifanSiswaBobot());
			Double pemangkatanKondisiSekolah = Math.pow(metodeVectorS.getKondisiSekolah().getPoint(), bobotSpk.getnKondisiSekolahBobot());
			Double pemangkatanKondisiKelas = Math.pow(metodeVectorS.getKondisiKelas().getPoint(), bobotSpk.getnKondisiKelasBobot());
			Double pemangkatanKualitasPengajar = Math.pow(metodeVectorS.getPengajar().getPoint(), bobotSpk.getnKualitasPengajarBobot());
			Double vectorS = pemangkatanFasilitas * pemangkatanJumlahSiswa * pemangkatanKeaktifanSiswa * 
					  		 pemangkatanKondisiKelas * pemangkatanKondisiSekolah * pemangkatanKualitasPengajar;
			
			// jumlahkan jumlahVectorS saat ini dengan vectorS
			jumlahVectorS += vectorS;
		}
		
		for (Metode metode : metodes) {
			
			Double pemangkatanFasilitas = Math.pow(metode.getFasilitas().getPoint(), bobotSpk.getnFasilitasBobot());
			Double pemangkatanJumlahSiswa = Math.pow(metode.getJumlahSiswa().getPoint(), bobotSpk.getnJumlahSiswaBobot());
			Double pemangkatanKeaktifanSiswa = Math.pow(metode.getKeaktifan().getPoint(), bobotSpk.getnKeaktifanSiswaBobot());
			Double pemangkatanKondisiSekolah = Math.pow(metode.getKondisiSekolah().getPoint(), bobotSpk.getnKondisiSekolahBobot());
			Double pemangkatanKondisiKelas = Math.pow(metode.getKondisiKelas().getPoint(), bobotSpk.getnKondisiKelasBobot());
			Double pemangkatanKualitasPengajar = Math.pow(metode.getPengajar().getPoint(), bobotSpk.getnKualitasPengajarBobot());
			Double vectorS = pemangkatanFasilitas * pemangkatanJumlahSiswa * pemangkatanKeaktifanSiswa * 
					  		 pemangkatanKondisiKelas * pemangkatanKondisiSekolah * pemangkatanKualitasPengajar;
			
			MetodeSpk metodeSpk = new MetodeSpk();
			metodeSpk.setNamaMetode(metode.getMetode());
			metodeSpk.setFasilitas(HelperUmum.angkaBelakangKoma(Math.pow(metode.getFasilitas().getPoint(), bobotSpk.getnFasilitasBobot()), 3));
			metodeSpk.setJumlahSiswa(HelperUmum.angkaBelakangKoma(Math.pow(metode.getJumlahSiswa().getPoint(), bobotSpk.getnJumlahSiswaBobot()), 3));
			metodeSpk.setKeaktifanSiswa(HelperUmum.angkaBelakangKoma(Math.pow(metode.getKeaktifan().getPoint(), bobotSpk.getnKeaktifanSiswaBobot()), 3));
			metodeSpk.setKondisiSekolah(HelperUmum.angkaBelakangKoma(Math.pow(metode.getKondisiSekolah().getPoint(), bobotSpk.getnKondisiSekolahBobot()), 3));
			metodeSpk.setKondisiKelas(HelperUmum.angkaBelakangKoma(Math.pow(metode.getKondisiKelas().getPoint(), bobotSpk.getnKondisiKelasBobot()), 3));
			metodeSpk.setKualitasPengajar(HelperUmum.angkaBelakangKoma(Math.pow(metode.getPengajar().getPoint(), bobotSpk.getnKualitasPengajarBobot()), 3));
			metodeSpk.setVectorS(HelperUmum.angkaBelakangKoma(vectorS, 6));
			metodeSpk.setJumlahVectorS(HelperUmum.angkaBelakangKoma(jumlahVectorS, 6));
			listMetodeSpk.add(metodeSpk);
		}
		mav.addObject("metodeSpk", listMetodeSpk);
		
		return mav;
	}
	
	@RequestMapping("/step_2")
	public ModelAndView hituneSPKStep2(@ModelAttribute("metodes") List<Metode> metodes,
			   						   @ModelAttribute("tempBobot") BobotSpk bobotSpk) {
		
		ModelAndView mav = new ModelAndView("step_2");
		List<MetodeSpk> listMetodeSpk = new ArrayList<>();
		if (!listMetodeSpk.isEmpty()) {
			listMetodeSpk.clear();
		}
		
		Double jumlahVectorS = 0.0;
		for (Metode metodeVectorS : metodes) {
			Double pemangkatanFasilitas = Math.pow(metodeVectorS.getFasilitas().getPoint(), bobotSpk.getnFasilitasBobot());
			Double pemangkatanJumlahSiswa = Math.pow(metodeVectorS.getJumlahSiswa().getPoint(), bobotSpk.getnJumlahSiswaBobot());
			Double pemangkatanKeaktifanSiswa = Math.pow(metodeVectorS.getKeaktifan().getPoint(), bobotSpk.getnKeaktifanSiswaBobot());
			Double pemangkatanKondisiSekolah = Math.pow(metodeVectorS.getKondisiSekolah().getPoint(), bobotSpk.getnKondisiSekolahBobot());
			Double pemangkatanKondisiKelas = Math.pow(metodeVectorS.getKondisiKelas().getPoint(), bobotSpk.getnKondisiKelasBobot());
			Double pemangkatanKualitasPengajar = Math.pow(metodeVectorS.getPengajar().getPoint(), bobotSpk.getnKualitasPengajarBobot());
			Double vectorS = pemangkatanFasilitas * pemangkatanJumlahSiswa * pemangkatanKeaktifanSiswa * 
					  		 pemangkatanKondisiKelas * pemangkatanKondisiSekolah * pemangkatanKualitasPengajar;
			jumlahVectorS += vectorS;
		}
		
		for (Metode metode : metodes) {
			
			Double pemangkatanFasilitas = Math.pow(metode.getFasilitas().getPoint(), bobotSpk.getnFasilitasBobot());
			Double pemangkatanJumlahSiswa = Math.pow(metode.getJumlahSiswa().getPoint(), bobotSpk.getnJumlahSiswaBobot());
			Double pemangkatanKeaktifanSiswa = Math.pow(metode.getKeaktifan().getPoint(), bobotSpk.getnKeaktifanSiswaBobot());
			Double pemangkatanKondisiSekolah = Math.pow(metode.getKondisiSekolah().getPoint(), bobotSpk.getnKondisiSekolahBobot());
			Double pemangkatanKondisiKelas = Math.pow(metode.getKondisiKelas().getPoint(), bobotSpk.getnKondisiKelasBobot());
			Double pemangkatanKualitasPengajar = Math.pow(metode.getPengajar().getPoint(), bobotSpk.getnKualitasPengajarBobot());
			Double vectorS = pemangkatanFasilitas * pemangkatanJumlahSiswa * pemangkatanKeaktifanSiswa * 
					  		 pemangkatanKondisiKelas * pemangkatanKondisiSekolah * pemangkatanKualitasPengajar;
			
			MetodeSpk metodeSpk = new MetodeSpk();
			metodeSpk.setNamaMetode(metode.getMetode());
			metodeSpk.setFasilitas(HelperUmum.angkaBelakangKoma(Math.pow(metode.getFasilitas().getPoint(), bobotSpk.getnFasilitasBobot()), 3));
			metodeSpk.setJumlahSiswa(HelperUmum.angkaBelakangKoma(Math.pow(metode.getJumlahSiswa().getPoint(), bobotSpk.getnJumlahSiswaBobot()), 3));
			metodeSpk.setKeaktifanSiswa(HelperUmum.angkaBelakangKoma(Math.pow(metode.getKeaktifan().getPoint(), bobotSpk.getnKeaktifanSiswaBobot()), 3));
			metodeSpk.setKondisiSekolah(HelperUmum.angkaBelakangKoma(Math.pow(metode.getKondisiSekolah().getPoint(), bobotSpk.getnKondisiSekolahBobot()), 3));
			metodeSpk.setKondisiKelas(HelperUmum.angkaBelakangKoma(Math.pow(metode.getKondisiKelas().getPoint(), bobotSpk.getnKondisiKelasBobot()), 3));
			metodeSpk.setKualitasPengajar(HelperUmum.angkaBelakangKoma(Math.pow(metode.getPengajar().getPoint(), bobotSpk.getnKualitasPengajarBobot()), 3));
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
	 * @param bobotSpk
	 * @return
	 */
	@RequestMapping("/simpan")
	public ModelAndView hitungSPKStepFinal(@ModelAttribute("metodes") List<Metode> metodes,
			   							   @ModelAttribute("tempBobot") BobotSpk bobotSpk, ModelMap model) {
		ModelAndView mav = new ModelAndView("redirect:/spk/final_step");
		
		if (model.containsAttribute("daftarRangking")) {
			model.remove("daftarRangking");
		}
		
		TreeSet<SPK> treeSet = new TreeSet<>();
		
		TempBobot tempBobot = new TempBobot();
		tempBobot.setTanggal(new Date());
		tempBobot.setBobotFasilitas(bobotSpk.getFasilitasBobot().intValue());
		tempBobot.setBobotJumlahSiswa(bobotSpk.getJumlahSiswaBobot().intValue());
		tempBobot.setBobotKeaktifanSiswa(bobotSpk.getKeaktifanSiswaBobot().intValue());
		tempBobot.setBobotKondisiKelas(bobotSpk.getKondisiKelasBobot().intValue());
		tempBobot.setBobotKondisiSekolah(bobotSpk.getKondisiSekolahBobot().intValue());
		tempBobot.setBobotKualitasPengajar(bobotSpk.getKualitasPengajarBobot().intValue());
		tempBobotService.save(tempBobot);
		
		// siapkan variable jumlahVectorS untuk menyimpan jumlah dari vectorS
		Double jumlahVectorS = 0.0;
		for (Metode metodeVectorS : metodes) {
			
			// hasil pemangkatan metode dengan bobot untuk mencari jumlahVectorS
			Double pemangkatanFasilitas = Math.pow(metodeVectorS.getFasilitas().getPoint(), bobotSpk.getnFasilitasBobot());
			Double pemangkatanJumlahSiswa = Math.pow(metodeVectorS.getJumlahSiswa().getPoint(), bobotSpk.getnJumlahSiswaBobot());
			Double pemangkatanKeaktifanSiswa = Math.pow(metodeVectorS.getKeaktifan().getPoint(), bobotSpk.getnKeaktifanSiswaBobot());
			Double pemangkatanKondisiSekolah = Math.pow(metodeVectorS.getKondisiSekolah().getPoint(), bobotSpk.getnKondisiSekolahBobot());
			Double pemangkatanKondisiKelas = Math.pow(metodeVectorS.getKondisiKelas().getPoint(), bobotSpk.getnKondisiKelasBobot());
			Double pemangkatanKualitasPengajar = Math.pow(metodeVectorS.getPengajar().getPoint(), bobotSpk.getnKualitasPengajarBobot());
			Double vectorS = pemangkatanFasilitas * pemangkatanJumlahSiswa * pemangkatanKeaktifanSiswa * 
					  		 pemangkatanKondisiKelas * pemangkatanKondisiSekolah * pemangkatanKualitasPengajar;
			jumlahVectorS += vectorS;
		}
		
		for (Metode metode : metodes) {
			
			// hasil pemangkatan metode dengan bobot untuk mencari vectorS
			Double pemangkatanFasilitas = Math.pow(metode.getFasilitas().getPoint(), bobotSpk.getnFasilitasBobot());
			Double pemangkatanJumlahSiswa = Math.pow(metode.getJumlahSiswa().getPoint(), bobotSpk.getnJumlahSiswaBobot());
			Double pemangkatanKeaktifanSiswa = Math.pow(metode.getKeaktifan().getPoint(), bobotSpk.getnKeaktifanSiswaBobot());
			Double pemangkatanKondisiSekolah = Math.pow(metode.getKondisiSekolah().getPoint(), bobotSpk.getnKondisiSekolahBobot());
			Double pemangkatanKondisiKelas = Math.pow(metode.getKondisiKelas().getPoint(), bobotSpk.getnKondisiKelasBobot());
			Double pemangkatanKualitasPengajar = Math.pow(metode.getPengajar().getPoint(), bobotSpk.getnKualitasPengajarBobot());
			Double vectorS = pemangkatanFasilitas * pemangkatanJumlahSiswa * pemangkatanKeaktifanSiswa * 
					  		 pemangkatanKondisiKelas * pemangkatanKondisiSekolah * pemangkatanKualitasPengajar;
			
			SPK spk = new SPK();
			
			// dari hasil penjumlahan vectorS didapat vectorV dengan membagi vectorS masing-masing object dengan jumlahVectorS
			spk.setNamaMetode(metode.getMetode());
			spk.setTanggal(new Date());
			spk.setFasilitas(HelperUmum.angkaBelakangKoma(Math.pow(metode.getFasilitas().getPoint(), bobotSpk.getnFasilitasBobot()), 3));
			spk.setJumlahSiswa(HelperUmum.angkaBelakangKoma(Math.pow(metode.getJumlahSiswa().getPoint(), bobotSpk.getnJumlahSiswaBobot()), 3));
			spk.setKeaktifanSiswa(HelperUmum.angkaBelakangKoma(Math.pow(metode.getKeaktifan().getPoint(), bobotSpk.getnKeaktifanSiswaBobot()), 3));
			spk.setKondisiSekolah(HelperUmum.angkaBelakangKoma(Math.pow(metode.getKondisiSekolah().getPoint(), bobotSpk.getnKondisiSekolahBobot()), 3));
			spk.setKondisiKelas(HelperUmum.angkaBelakangKoma(Math.pow(metode.getKondisiKelas().getPoint(), bobotSpk.getnKondisiKelasBobot()), 3));
			spk.setKualitasPengajar(HelperUmum.angkaBelakangKoma(Math.pow(metode.getPengajar().getPoint(), bobotSpk.getnKualitasPengajarBobot()), 3));
			spk.setVectorS(HelperUmum.angkaBelakangKoma(vectorS, 6));
			spk.setJumlahVectorS(HelperUmum.angkaBelakangKoma(jumlahVectorS, 6));
			spk.setVectorV(HelperUmum.angkaBelakangKoma(vectorS / jumlahVectorS, 6));
			spk.setTempBobot(tempBobot);
			spkService.save(spk);
			treeSet.add(spk);
		}
		mav.addObject("daftarRangking", treeSet);
		return mav;
	}
	
	@RequestMapping("/final_step")
	public ModelAndView daftarRangkingTertinggi(Model model, @ModelAttribute("daftarRangking") TreeSet<SPK> treeSet) {
		ModelAndView mav = new ModelAndView("final_step");
		mav.addObject("tempBobot", bobotService.getOneById());
		mav.addObject("daftarRangking", treeSet);
		return mav;
	}
	
	
}
