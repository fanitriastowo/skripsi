package com.skripsi.beni.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skripsi.beni.apps.entity.Kondisi;
import com.skripsi.beni.apps.repository.KondisiRepository;

@Service
@Transactional
public class KondisiService {

	@Autowired
	private KondisiRepository kondisiRepository;

	public List<Kondisi> findAll() {

		// Cari semua data Kondisi Kelas
		return kondisiRepository.findAll();
	}

	public void delete(Integer id) {

		// Hapus Kondisi Kelas berdasarkan id
		kondisiRepository.delete(id);
	}

	public void save(Kondisi kondisi) {

		// Simpan Kondisi
		kondisiRepository.save(kondisi);
	}

	public Kondisi findOneById(Integer id) {
		
		// get kondisi by id
		return kondisiRepository.findOne(id);
	}

	public void update(Kondisi kondisi) {

		// Update Kondisi
		kondisiRepository.save(kondisi);
	}

}
