package com.skripsi.beni.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skripsi.beni.apps.entity.KondisiSekolah;
import com.skripsi.beni.apps.repository.KondisiSekolahRepository;

@Service
@Transactional
public class KondisiSekolahService {

	@Autowired
	private KondisiSekolahRepository kondisiSekolahRepository;

	public List<KondisiSekolah> findAll() {
		return kondisiSekolahRepository.findAll();
	}

	public void save(KondisiSekolah kondisi) {
		kondisiSekolahRepository.save(kondisi);
	}

	public void delete(Long id) {
		kondisiSekolahRepository.delete(id);
	}

	public KondisiSekolah findOneById(Long id) {
		return kondisiSekolahRepository.findOne(id);
	}

	public void update(KondisiSekolah kondisi) {
		kondisiSekolahRepository.save(kondisi);
	}

}
