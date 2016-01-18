package com.skripsi.beni.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skripsi.beni.apps.entity.Pengajar;
import com.skripsi.beni.apps.repository.PengajarRepository;

@Service
@Transactional
public class PengajarService {

	@Autowired
	private PengajarRepository pengajarRepository;

	public List<Pengajar> findAll() {
		return pengajarRepository.findAll();
	}

	public void save(Pengajar pengajar) {
		pengajarRepository.save(pengajar);
	}

	public void delete(Long id) {
		pengajarRepository.delete(id);
	}

	public Pengajar findOneById(Long id) {
		return pengajarRepository.findOne(id);
	}

	public void update(Pengajar pengajar) {
		pengajarRepository.save(pengajar);
	}
}
