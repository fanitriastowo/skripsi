package com.skripsi.beni.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skripsi.beni.apps.entity.SPK;
import com.skripsi.beni.apps.repository.SPKRepository;

@Service
@Transactional
public class SPKService {

	@Autowired
	private SPKRepository spkRepository;

	public void save(SPK spk) {
		spkRepository.save(spk);
	}

	public List<SPK> findAllDesc() {
		return spkRepository.findAllByOrderByVectorVDesc();
	}
}
