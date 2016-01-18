package com.skripsi.beni.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skripsi.beni.apps.entity.JumlahSiswa;
import com.skripsi.beni.apps.repository.JumlahSiswaRepository;

@Service
@Transactional
public class JumlahSiswaService {

	@Autowired
	private JumlahSiswaRepository jumlahSiswaRepository;

	public List<JumlahSiswa> findAll() {

		// Cari semua data Kondisi Kelas
		return jumlahSiswaRepository.findAll();
	}

	public void delete(Integer id) {

		// Hapus Kondisi Kelas berdasarkan id
		jumlahSiswaRepository.delete(id);
	}

	public void save(JumlahSiswa kondisi) {

		// Simpan Kondisi
		jumlahSiswaRepository.save(kondisi);
	}

	public JumlahSiswa findOneById(Integer id) {
		
		// get kondisi by id
		return jumlahSiswaRepository.findOne(id);
	}

	public void update(JumlahSiswa kondisi) {

		// Update Kondisi
		jumlahSiswaRepository.save(kondisi);
	}

}
