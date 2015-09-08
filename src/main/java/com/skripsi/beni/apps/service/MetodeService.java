package com.skripsi.beni.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skripsi.beni.apps.entity.Metode;
import com.skripsi.beni.apps.repository.MetodeRepository;

@Service
public class MetodeService {

	@Autowired
	private MetodeRepository metodeRepository;
	
	public List<Metode> tampilSemuaMetode() {
		return metodeRepository.findAll();
	}
	
}