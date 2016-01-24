package com.skripsi.beni.apps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skripsi.beni.apps.entity.BobotSpk;
import com.skripsi.beni.apps.repository.BobotRepository;

@Service
@Transactional
public class BobotService {

	@Autowired
	private BobotRepository bobotRepository;

	public BobotSpk getOneById() {
		return bobotRepository.getOneById("bobot");
	}

	public void update(BobotSpk bobotSpk) {
		
		float fasilitasBobot = bobotSpk.getFasilitasBobot();
		float jumlahSiswaBobot = bobotSpk.getJumlahSiswaBobot();
		float keaktifanSiswaBobot = bobotSpk.getKeaktifanSiswaBobot();
		float kondisiKelasBobot = bobotSpk.getKondisiKelasBobot();
		float kualitasPengajarBobot = bobotSpk.getKualitasPengajarBobot();
		float jumlahBobot = fasilitasBobot + jumlahSiswaBobot + keaktifanSiswaBobot + kondisiKelasBobot + kualitasPengajarBobot;
		
		BobotSpk bobotBaru = getOneById();
		bobotBaru.setFasilitasBobot(bobotSpk.getFasilitasBobot());
		bobotBaru.setJumlahSiswaBobot(bobotSpk.getJumlahSiswaBobot());
		bobotBaru.setKeaktifanSiswaBobot(bobotSpk.getKeaktifanSiswaBobot());
		bobotBaru.setKondisiKelasBobot(bobotSpk.getKondisiKelasBobot());
		bobotBaru.setKualitasPengajarBobot(bobotSpk.getKualitasPengajarBobot());
		
		bobotBaru.setnFasilitasBobot(fasilitasBobot / jumlahBobot);
		bobotBaru.setnJumlahSiswaBobot(jumlahSiswaBobot / jumlahBobot);
		bobotBaru.setnKeaktifanSiswaBobot(keaktifanSiswaBobot / jumlahBobot);
		bobotBaru.setnKondisiKelasBobot(kondisiKelasBobot / jumlahBobot);
		bobotBaru.setnKualitasPengajarBobot(kualitasPengajarBobot / jumlahBobot);
		
		bobotRepository.save(bobotBaru);
	}
}
