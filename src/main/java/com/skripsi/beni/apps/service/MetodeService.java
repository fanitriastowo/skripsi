package com.skripsi.beni.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.skripsi.beni.apps.dto.MetodeDTO;
import com.skripsi.beni.apps.dto.MetodeSearchResultDTO;
import com.skripsi.beni.apps.entity.Metode;
import com.skripsi.beni.apps.entity.kriteria.Fasilitas;
import com.skripsi.beni.apps.entity.kriteria.JumlahSiswa;
import com.skripsi.beni.apps.entity.kriteria.KemampuanGuru;
import com.skripsi.beni.apps.entity.kriteria.KemampuanSiswa;
import com.skripsi.beni.apps.entity.kriteria.MateriPengajaran;
import com.skripsi.beni.apps.entity.kriteria.TujuanPengajaran;
import com.skripsi.beni.apps.entity.kriteria.WaktuPembelajaran;
import com.skripsi.beni.apps.repository.FasilitasRepository;
import com.skripsi.beni.apps.repository.JumlahSiswaRepository;
import com.skripsi.beni.apps.repository.KemampuanGuruRepository;
import com.skripsi.beni.apps.repository.KemampuanSiswaRepository;
import com.skripsi.beni.apps.repository.MateriPengajaranRepository;
import com.skripsi.beni.apps.repository.MetodeRepository;
import com.skripsi.beni.apps.repository.TujuanPengajaranRepository;
import com.skripsi.beni.apps.repository.WaktuPembelajaranRepository;

@Service
public class MetodeService {

	@Autowired
	private MetodeRepository metodeRepository;

	@Autowired
	private FasilitasRepository fasilitasRepository;

	@Autowired
	private JumlahSiswaRepository jumlahSiswaRepository;

	@Autowired
	private KemampuanGuruRepository kemampuanGuruRepository;

	@Autowired
	private KemampuanSiswaRepository kemampuanSiswaRepository;

	@Autowired
	private MateriPengajaranRepository materiPengajaranRepository;

	@Autowired
	private TujuanPengajaranRepository tujuanPengajaranRepository;

	@Autowired
	private WaktuPembelajaranRepository waktuPembelajaranRepository;

	public List<Metode> tampilSemuaMetode() {
		return metodeRepository.findAll(new Sort(Direction.ASC, "metode"));
	}

	public Metode findOneById(Long id) {
		return metodeRepository.findOne(id);
	}

	public void update(MetodeDTO metodeDTO) {

		String namaMetode = metodeDTO.getMetode();
		Fasilitas fasilitas = fasilitasRepository.findOne(metodeDTO.getFasilitas());
		JumlahSiswa jumlahSiswa = jumlahSiswaRepository.findOne(metodeDTO.getJumlahSiswa());
		KemampuanGuru kemampuanGuru = kemampuanGuruRepository.findOne(metodeDTO.getKemampuanGuru());
		KemampuanSiswa kemampuanSiswa = kemampuanSiswaRepository.findOne(metodeDTO.getKemampuanSiswa());
		MateriPengajaran materiPengajaran = materiPengajaranRepository.findOne(metodeDTO.getMateriPengajaran());
		TujuanPengajaran tujuanPengajaran = tujuanPengajaranRepository.findOne(metodeDTO.getTujuanPengajaran());
		WaktuPembelajaran waktuPembelajaran = waktuPembelajaranRepository.findOne(metodeDTO.getWaktuPembelajaran());

		Metode metode = metodeRepository.findOne(metodeDTO.getId());
		metode.setMetode(namaMetode);
		metode.setFasilitas(fasilitas);
		metode.setJumlahSiswa(jumlahSiswa);
		metode.setKemampuanGuru(kemampuanGuru);
		metode.setKemampuanSiswa(kemampuanSiswa);
		metode.setMateriPengajaran(materiPengajaran);
		metode.setTujuanPengajaran(tujuanPengajaran);
		metode.setWaktuPembelajaran(waktuPembelajaran);
		metodeRepository.save(metode);

	}

	public void delete(Long id) {
		metodeRepository.delete(id);
	}

	public void save(MetodeDTO metodeDTO) {

		String namaMetode = metodeDTO.getMetode();
		Fasilitas fasilitas = fasilitasRepository.findOne(metodeDTO.getFasilitas());
		JumlahSiswa jumlahSiswa = jumlahSiswaRepository.findOne(metodeDTO.getJumlahSiswa());
		KemampuanGuru kemampuanGuru = kemampuanGuruRepository.findOne(metodeDTO.getKemampuanGuru());
		KemampuanSiswa kemampuanSiswa = kemampuanSiswaRepository.findOne(metodeDTO.getKemampuanSiswa());
		MateriPengajaran materiPengajaran = materiPengajaranRepository.findOne(metodeDTO.getMateriPengajaran());
		TujuanPengajaran tujuanPengajaran = tujuanPengajaranRepository.findOne(metodeDTO.getTujuanPengajaran());
		WaktuPembelajaran waktuPembelajaran = waktuPembelajaranRepository.findOne(metodeDTO.getWaktuPembelajaran());

		Metode metode = new Metode();
		metode.setMetode(namaMetode);
		metode.setFasilitas(fasilitas);
		metode.setJumlahSiswa(jumlahSiswa);
		metode.setKemampuanGuru(kemampuanGuru);
		metode.setKemampuanSiswa(kemampuanSiswa);
		metode.setMateriPengajaran(materiPengajaran);
		metode.setTujuanPengajaran(tujuanPengajaran);
		metode.setWaktuPembelajaran(waktuPembelajaran);
		metodeRepository.save(metode);
	}

	public Metode findOneByProperty(MetodeSearchResultDTO dto) {
		JumlahSiswa jumlahSiswa = jumlahSiswaRepository.findOne(dto.getJumlahSiswa());
		Fasilitas fasilitas = fasilitasRepository.findOne(dto.getFasilitas());
		KemampuanSiswa kemampuanSiswa = kemampuanSiswaRepository.findOne(dto.getKemampuanSiswa());
		KemampuanGuru kemampuanGuru = kemampuanGuruRepository.findOne(dto.getKemampuanGuru());
		MateriPengajaran materiPengajaran = materiPengajaranRepository.findOne(dto.getMateriPengajaran());
		TujuanPengajaran tujuanPengajaran = tujuanPengajaranRepository.findOne(dto.getTujuanPengajaran());
		WaktuPembelajaran waktuPembelajaran = waktuPembelajaranRepository.findOne(dto.getWaktuPembelajaran());
		
		return metodeRepository.findOneByJumlahSiswaAndFasilitasAndKemampuanSiswaAndKemampuanGuruAndMateriPengajaranAndTujuanPengajaranAndWaktuPembelajaran(
									jumlahSiswa, fasilitas, kemampuanSiswa, kemampuanGuru, materiPengajaran, tujuanPengajaran, waktuPembelajaran);
	}

}
