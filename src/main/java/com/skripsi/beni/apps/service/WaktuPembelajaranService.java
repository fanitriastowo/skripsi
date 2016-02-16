package com.skripsi.beni.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skripsi.beni.apps.entity.kriteria.WaktuPembelajaran;
import com.skripsi.beni.apps.repository.WaktuPembelajaranRepository;

@Service
@Transactional
public class WaktuPembelajaranService {

	@Autowired
	private WaktuPembelajaranRepository waktuPembelajaranRepository;

	public List<WaktuPembelajaran> findAll() {
		return waktuPembelajaranRepository.findAll();
	}

}
