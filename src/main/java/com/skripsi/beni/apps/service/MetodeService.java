package com.skripsi.beni.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.skripsi.beni.apps.dto.MetodeDTO;
import com.skripsi.beni.apps.entity.Fasilitas;
import com.skripsi.beni.apps.entity.JumlahSiswa;
import com.skripsi.beni.apps.entity.Keaktifan;
import com.skripsi.beni.apps.entity.KondisiSekolah;
import com.skripsi.beni.apps.entity.Metode;
import com.skripsi.beni.apps.entity.Pengajar;
import com.skripsi.beni.apps.repository.FasilitasRepository;
import com.skripsi.beni.apps.repository.JumlahSiswaRepository;
import com.skripsi.beni.apps.repository.KeaktifanRepository;
import com.skripsi.beni.apps.repository.KondisiSekolahRepository;
import com.skripsi.beni.apps.repository.MetodeRepository;
import com.skripsi.beni.apps.repository.PengajarRepository;

@Service
public class MetodeService {

	@Autowired
	private MetodeRepository metodeRepository;

	@Autowired
	private JumlahSiswaRepository jumlahSiswaRepository;
	
	@Autowired
	private KeaktifanRepository keaktifanRepository;
	
	@Autowired
	private KondisiSekolahRepository kondisiRepository;
	
	@Autowired
	private FasilitasRepository fasilitasRepository;
	
	@Autowired
	private PengajarRepository pengajarRepository;

	public List<Metode> tampilSemuaMetode() {
		return metodeRepository.findAll(new Sort(Direction.ASC, "metode"));
	}

	public Metode findOneById(Long id) {
		return metodeRepository.findOne(id);
	}

	public void update(MetodeDTO metodeDTO) {

		JumlahSiswa jumlahSiswa = jumlahSiswaRepository.findOne(metodeDTO.getJumlahSiswa());
		Keaktifan keaktifan = keaktifanRepository.findOne(metodeDTO.getKeaktifan());
		KondisiSekolah kondisi = kondisiRepository.findOne(metodeDTO.getKondisiSekolah());
		Fasilitas fasilitas = fasilitasRepository.findOne(metodeDTO.getFasilitas());
		Pengajar pengajar = pengajarRepository.findOne(metodeDTO.getPengajar());

		Metode metode = metodeRepository.findOne(metodeDTO.getId());
		metode.setMetode(metodeDTO.getMetode());
		metode.setJumlahSiswa(jumlahSiswa);
		metode.setKeaktifan(keaktifan);
		metode.setKondisi(kondisi);
		metode.setFasilitas(fasilitas);
		metode.setPengajar(pengajar);
		
		metodeRepository.save(metode);

	}

	public void delete(Long id) {
		metodeRepository.delete(id);
	}

	public void save(MetodeDTO metodeDTO) {
		
		JumlahSiswa jumlahSiswa = jumlahSiswaRepository.findOne(metodeDTO.getJumlahSiswa());
		Keaktifan keaktifan = keaktifanRepository.findOne(metodeDTO.getKeaktifan());
		KondisiSekolah kondisi = kondisiRepository.findOne(metodeDTO.getKondisiSekolah());
		Fasilitas fasilitas = fasilitasRepository.findOne(metodeDTO.getFasilitas());
		Pengajar pengajar = pengajarRepository.findOne(metodeDTO.getPengajar());
		
		Metode metode = new Metode();
		metode.setMetode(metodeDTO.getMetode());
		metode.setJumlahSiswa(jumlahSiswa);
		metode.setKeaktifan(keaktifan);
		metode.setKondisi(kondisi);
		metode.setFasilitas(fasilitas);
		metode.setPengajar(pengajar);
		
		metodeRepository.save(metode);
	}
}
