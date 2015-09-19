package com.skripsi.beni.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skripsi.beni.apps.entity.Keaktifan;
import com.skripsi.beni.apps.repository.KeaktifanRepository;

@Service
@Transactional
public class KeaktifanService {

	@Autowired
	private KeaktifanRepository keaktifanRepository;

	public List<Keaktifan> findAll() {
		return keaktifanRepository.findAll();
	}

	public void save(Keaktifan keaktifan) {
		keaktifanRepository.save(keaktifan);
	}
	
	
}
