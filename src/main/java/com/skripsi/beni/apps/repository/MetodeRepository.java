package com.skripsi.beni.apps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skripsi.beni.apps.entity.Metode;
import com.skripsi.beni.apps.entity.kriteria.Fasilitas;
import com.skripsi.beni.apps.entity.kriteria.JumlahSiswa;
import com.skripsi.beni.apps.entity.kriteria.KemampuanGuru;
import com.skripsi.beni.apps.entity.kriteria.KemampuanSiswa;
import com.skripsi.beni.apps.entity.kriteria.MateriPengajaran;
import com.skripsi.beni.apps.entity.kriteria.TujuanPengajaran;
import com.skripsi.beni.apps.entity.kriteria.WaktuPembelajaran;

@Repository
public interface MetodeRepository extends JpaRepository<Metode, Long> {

	Metode findOneByJumlahSiswaAndFasilitasAndKemampuanSiswaAndKemampuanGuruAndMateriPengajaranAndTujuanPengajaranAndWaktuPembelajaran(
			JumlahSiswa jumlahSiswa, Fasilitas fasilitas, KemampuanSiswa kemampuanSiswa, KemampuanGuru kemampuanGuru,
			MateriPengajaran materiPengajaran, TujuanPengajaran tujuanPengajaran, WaktuPembelajaran waktuPembelajaran);

}
