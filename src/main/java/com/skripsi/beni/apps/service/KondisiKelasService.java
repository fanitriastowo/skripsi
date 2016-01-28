package com.skripsi.beni.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skripsi.beni.apps.entity.KondisiSekolah;
import com.skripsi.beni.apps.repository.KondisiSekolahRepository;

@Service
@Transactional
public class KondisiKelasService {

	@Autowired
	private KondisiSekolahRepository kondisiRepository;

	public List<KondisiSekolah> findAll() {
		return kondisiRepository.findAll();
	}

	public void save(KondisiSekolah kondisi) {
		kondisiRepository.save(kondisi);
	}

	public void delete(Long id) {
		kondisiRepository.delete(id);
	}

	public KondisiSekolah findOneById(Long id) {
		return kondisiRepository.findOne(id);
	}

	public void update(KondisiSekolah kondisi) {
		kondisiRepository.save(kondisi);
	}

}
