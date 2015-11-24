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
		return kondisiRepository.findAll();
	}

	public void save(Kondisi kondisi) {
		kondisiRepository.save(kondisi);
	}

	public void delete(Integer id) {
		kondisiRepository.delete(id);
	}

	public Kondisi findOneById(Integer id) {
		return kondisiRepository.findOne(id);
	}

	public void update(Kondisi kondisi) {
		kondisiRepository.save(kondisi);
	}

}
