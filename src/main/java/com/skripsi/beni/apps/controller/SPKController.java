package com.skripsi.beni.apps.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.skripsi.beni.apps.dto.MetodeSpk;
import com.skripsi.beni.apps.entity.BobotSpk;
import com.skripsi.beni.apps.entity.Metode;
import com.skripsi.beni.apps.service.BobotService;
import com.skripsi.beni.apps.service.MetodeService;

@Controller
@RequestMapping("/spk")
@SessionAttributes(value = { "metodes", "tempBobot" })
public class SPKController {

	@Autowired
	private MetodeService metodeService;

	@Autowired
	private BobotService bobotService;

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
	public ModelAndView halamanSPK(Model model) {
		ModelAndView mav = new ModelAndView("spk");
		BobotSpk bobot = bobotService.getOneById();

		if (!model.containsAttribute("tempBobot") && !model.containsAttribute("metodes")) {
			mav.addObject("tempBobot", bobot);
			mav.addObject("metodes", metodeService.tampilSemuaMetode());
		} else {
			mav.clear();
			mav.addObject("tempBobot", bobot);
			mav.addObject("metodes", metodeService.tampilSemuaMetode());
		}

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
		if (!listMetodeSpk.isEmpty()) {
			listMetodeSpk.clear();
		}
		
		Double jumlahVectorS = 0.0;
		for (Metode metodeVectorS : metodes) {
			Double pemangkatanFasilitas = Math.pow(metodeVectorS.getFasilitas().getPoint(), bobotSpk.getnFasilitasBobot());
			Double pemangkatanJumlahSiswa = Math.pow(metodeVectorS.getJumlahSiswa().getPoint(), bobotSpk.getnJumlahSiswaBobot());
			Double pemangkatanKeaktifanSiswa = Math.pow(metodeVectorS.getKeaktifan().getPoint(), bobotSpk.getnKeaktifanSiswaBobot());
			Double pemangkatanKondisiKelas = Math.pow(metodeVectorS.getKondisi().getPoint(), bobotSpk.getnKondisiKelasBobot());
			Double pemangkatanKualitasPengajar = Math.pow(metodeVectorS.getKondisi().getPoint(), bobotSpk.getnKualitasPengajarBobot());
			Double vectorS = pemangkatanFasilitas * pemangkatanJumlahSiswa * pemangkatanKeaktifanSiswa * 
					  		 pemangkatanKondisiKelas * pemangkatanKualitasPengajar;
			jumlahVectorS += vectorS;
		}
		
		for (Metode metode : metodes) {
			
			Double pemangkatanFasilitas = Math.pow(metode.getFasilitas().getPoint(), bobotSpk.getnFasilitasBobot());
			Double pemangkatanJumlahSiswa = Math.pow(metode.getJumlahSiswa().getPoint(), bobotSpk.getnJumlahSiswaBobot());
			Double pemangkatanKeaktifanSiswa = Math.pow(metode.getKeaktifan().getPoint(), bobotSpk.getnKeaktifanSiswaBobot());
			Double pemangkatanKondisiKelas = Math.pow(metode.getKondisi().getPoint(), bobotSpk.getnKondisiKelasBobot());
			Double pemangkatanKualitasPengajar = Math.pow(metode.getKondisi().getPoint(), bobotSpk.getnKualitasPengajarBobot());
			Double vectorS = pemangkatanFasilitas * pemangkatanJumlahSiswa * pemangkatanKeaktifanSiswa * 
					  		 pemangkatanKondisiKelas * pemangkatanKualitasPengajar;
			
			MetodeSpk metodeSpk = new MetodeSpk();
			metodeSpk.setNamaMetode(metode.getMetode());
			metodeSpk.setFasilitas(Math.pow(metode.getFasilitas().getPoint(), bobotSpk.getnFasilitasBobot()));
			metodeSpk.setJumlahSiswa(Math.pow(metode.getJumlahSiswa().getPoint(), bobotSpk.getnJumlahSiswaBobot()));
			metodeSpk.setKeaktifanSiswa(Math.pow(metode.getKeaktifan().getPoint(), bobotSpk.getnKeaktifanSiswaBobot()));
			metodeSpk.setKondisiKelas(Math.pow(metode.getKondisi().getPoint(), bobotSpk.getnKondisiKelasBobot()));
			metodeSpk.setKualitasPengajar(Math.pow(metode.getKondisi().getPoint(), bobotSpk.getnKualitasPengajarBobot()));
			metodeSpk.setVectorS(vectorS);
			metodeSpk.setJumlahVectorS(jumlahVectorS);
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
			Double pemangkatanKondisiKelas = Math.pow(metodeVectorS.getKondisi().getPoint(), bobotSpk.getnKondisiKelasBobot());
			Double pemangkatanKualitasPengajar = Math.pow(metodeVectorS.getKondisi().getPoint(), bobotSpk.getnKualitasPengajarBobot());
			Double vectorS = pemangkatanFasilitas * pemangkatanJumlahSiswa * pemangkatanKeaktifanSiswa * 
					  		 pemangkatanKondisiKelas * pemangkatanKualitasPengajar;
			jumlahVectorS += vectorS;
		}
		
		for (Metode metode : metodes) {
			
			Double pemangkatanFasilitas = Math.pow(metode.getFasilitas().getPoint(), bobotSpk.getnFasilitasBobot());
			Double pemangkatanJumlahSiswa = Math.pow(metode.getJumlahSiswa().getPoint(), bobotSpk.getnJumlahSiswaBobot());
			Double pemangkatanKeaktifanSiswa = Math.pow(metode.getKeaktifan().getPoint(), bobotSpk.getnKeaktifanSiswaBobot());
			Double pemangkatanKondisiKelas = Math.pow(metode.getKondisi().getPoint(), bobotSpk.getnKondisiKelasBobot());
			Double pemangkatanKualitasPengajar = Math.pow(metode.getKondisi().getPoint(), bobotSpk.getnKualitasPengajarBobot());
			Double vectorS = pemangkatanFasilitas * pemangkatanJumlahSiswa * pemangkatanKeaktifanSiswa * 
					  		 pemangkatanKondisiKelas * pemangkatanKualitasPengajar;
			
			MetodeSpk metodeSpk = new MetodeSpk();
			metodeSpk.setNamaMetode(metode.getMetode());
			metodeSpk.setFasilitas(Math.pow(metode.getFasilitas().getPoint(), bobotSpk.getnFasilitasBobot()));
			metodeSpk.setJumlahSiswa(Math.pow(metode.getJumlahSiswa().getPoint(), bobotSpk.getnJumlahSiswaBobot()));
			metodeSpk.setKeaktifanSiswa(Math.pow(metode.getKeaktifan().getPoint(), bobotSpk.getnKeaktifanSiswaBobot()));
			metodeSpk.setKondisiKelas(Math.pow(metode.getKondisi().getPoint(), bobotSpk.getnKondisiKelasBobot()));
			metodeSpk.setKualitasPengajar(Math.pow(metode.getKondisi().getPoint(), bobotSpk.getnKualitasPengajarBobot()));
			metodeSpk.setVectorS(vectorS);
			metodeSpk.setJumlahVectorS(jumlahVectorS);
			metodeSpk.setVectorV(vectorS / jumlahVectorS);
			listMetodeSpk.add(metodeSpk);
		}
		mav.addObject("metodeSpk", listMetodeSpk);
		
		return mav;
	}
}
