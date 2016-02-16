package com.skripsi.beni.apps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skripsi.beni.apps.entity.Bobot;
import com.skripsi.beni.apps.helper.HelperUmum;
import com.skripsi.beni.apps.repository.BobotRepository;

@Service
@Transactional
public class BobotService {

	@Autowired
	private BobotRepository bobotRepository;

	public Bobot getOneById() {
		return bobotRepository.getOneById("bobot");
	}

	public void update(Bobot bobot) {
		
		Double jumlahSiswa = bobot.getJumlahSiswa();
		Double fasilitas = bobot.getFasilitas();
		Double kemampuanSiswa = bobot.getKemampuanSiswa();
		Double kemampuanGuru = bobot.getKemampuanGuru();
		Double materiPengajaran = bobot.getMateriPengajaran();
		Double tujuanPengajaran = bobot.getTujuanPengajaran();
		Double waktuPembelajaran = bobot.getWaktuPembelajaran();
		Double jumlahBobot = jumlahSiswa + fasilitas + kemampuanSiswa + kemampuanGuru +
							 materiPengajaran + tujuanPengajaran + waktuPembelajaran;

		Double nJumlahSiswa = jumlahSiswa / jumlahBobot;
		Double nFasilitas = fasilitas / jumlahBobot;
		Double nKemampuanSiswa = kemampuanSiswa / jumlahBobot;
		Double nKemampuanGuru = kemampuanGuru / jumlahBobot;
		Double nMateriPengajaran = materiPengajaran / jumlahBobot;
		Double nTujuanPengajaran = tujuanPengajaran / jumlahBobot;
		Double nWaktuPembelajaran = waktuPembelajaran / jumlahBobot;
		
		Bobot bobotBaru = this.getOneById();
		bobotBaru.setJumlahSiswa(jumlahSiswa);
		bobotBaru.setFasilitas(fasilitas);
		bobotBaru.setKemampuanSiswa(kemampuanSiswa);
		bobotBaru.setKemampuanGuru(kemampuanGuru);
		bobotBaru.setMateriPengajaran(materiPengajaran);
		bobotBaru.setTujuanPengajaran(tujuanPengajaran);
		bobotBaru.setWaktuPembelajaran(waktuPembelajaran);
		
		bobotBaru.setnJumlahSiswa(HelperUmum.angkaBelakangKoma(nJumlahSiswa, 3));
		bobotBaru.setnFasilitas(HelperUmum.angkaBelakangKoma(nFasilitas, 3));
		bobotBaru.setnKemampuanSiswa(HelperUmum.angkaBelakangKoma(nKemampuanSiswa, 3));
		bobotBaru.setnKemampuanGuru(HelperUmum.angkaBelakangKoma(nKemampuanGuru, 3));
		bobotBaru.setnMateriPengajaran(HelperUmum.angkaBelakangKoma(nMateriPengajaran, 3));
		bobotBaru.setnTujuanPengajaran(HelperUmum.angkaBelakangKoma(nTujuanPengajaran, 3));
		bobotBaru.setnWaktuPembelajaran(HelperUmum.angkaBelakangKoma(nWaktuPembelajaran, 3));

		bobotRepository.save(bobotBaru);
	}
}
