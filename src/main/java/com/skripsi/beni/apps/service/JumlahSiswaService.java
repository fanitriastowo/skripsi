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
	private JumlahSiswaRepository kondisiRepository;

	public List<JumlahSiswa> findAll() {

		// Cari semua data Kondisi Kelas
		return kondisiRepository.findAll();
	}

	public void delete(Integer id) {

		// Hapus Kondisi Kelas berdasarkan id
		kondisiRepository.delete(id);
	}

	public void save(JumlahSiswa kondisi) {

		// Simpan Kondisi
		kondisiRepository.save(kondisi);
	}

	public JumlahSiswa findOneById(Integer id) {
		
		// get kondisi by id
		return kondisiRepository.findOne(id);
	}

	public void update(JumlahSiswa kondisi) {

		// Update Kondisi
		kondisiRepository.save(kondisi);
	}

}
