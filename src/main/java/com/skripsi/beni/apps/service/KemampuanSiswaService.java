package com.skripsi.beni.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skripsi.beni.apps.entity.kriteria.KemampuanSiswa;
import com.skripsi.beni.apps.repository.KemampuanSiswaRepository;

@Service
@Transactional
public class KemampuanSiswaService {

	@Autowired
	private KemampuanSiswaRepository kemampuanSiswaRepository;

	public List<KemampuanSiswa> findAll() {
		return kemampuanSiswaRepository.findAll();
	}

	public KemampuanSiswa findOneById(Long kemampuanSiswa) {
		return kemampuanSiswaRepository.findOne(kemampuanSiswa);
	}

	public void save(KemampuanSiswa kemampuanSiswa) {
		kemampuanSiswaRepository.save(kemampuanSiswa);
	}

	public void delete(Long id) {
		kemampuanSiswaRepository.delete(id);
	}

	public void update(KemampuanSiswa kemampuanSiswa) {
		kemampuanSiswaRepository.save(kemampuanSiswa);
	}

}
