package com.skripsi.beni.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skripsi.beni.apps.entity.KondisiKelas;
import com.skripsi.beni.apps.repository.KondisiKelasRepository;

@Service
@Transactional
public class KondisiKelasService {

	@Autowired
	private KondisiKelasRepository kondisiKelasRepository;

	public List<KondisiKelas> findAll() {
		return kondisiKelasRepository.findAll();
	}

}
