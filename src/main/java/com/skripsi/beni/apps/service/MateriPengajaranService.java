package com.skripsi.beni.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skripsi.beni.apps.entity.kriteria.MateriPengajaran;
import com.skripsi.beni.apps.repository.MateriPengajaranRepository;

@Service
@Transactional
public class MateriPengajaranService {

	@Autowired
	private MateriPengajaranRepository materiPengajaranRepository;

	public List<MateriPengajaran> findAll() {
		return materiPengajaranRepository.findAll();
	}

	public MateriPengajaran findOneById(Long materiPengajaran) {
		return materiPengajaranRepository.findOne(materiPengajaran);
	}

}
