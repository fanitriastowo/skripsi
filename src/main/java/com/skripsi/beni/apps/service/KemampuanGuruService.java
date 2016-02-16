package com.skripsi.beni.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skripsi.beni.apps.entity.kriteria.KemampuanGuru;
import com.skripsi.beni.apps.repository.KemampuanGuruRepository;

@Service
@Transactional
public class KemampuanGuruService {

	@Autowired
	private KemampuanGuruRepository kemampuanGuruRepository;

	public List<KemampuanGuru> findAll() {
		return kemampuanGuruRepository.findAll();
	}

}
