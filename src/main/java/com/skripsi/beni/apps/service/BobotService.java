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
		BobotSpk bobotBaru = getOneById();
		
		bobotBaru.setFasilitasBobot(bobotSpk.getFasilitasBobot());
		bobotBaru.setJumlahSiswaBobot(bobotSpk.getJumlahSiswaBobot());
		bobotBaru.setKeaktifanSiswaBobot(bobotSpk.getKeaktifanSiswaBobot());
		bobotBaru.setKondisiKelasBobot(bobotSpk.getKondisiKelasBobot());
		bobotBaru.setKualitasPengajarBobot(bobotSpk.getKualitasPengajarBobot());
		
		bobotRepository.save(bobotBaru);
	}
}
