package com.skripsi.beni.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skripsi.beni.apps.entity.PerhitunganTerakhir;
import com.skripsi.beni.apps.repository.PerhitunganTerakhirRepository;

@Service
@Transactional
public class PerhitunganTerakhirService {
	
	@Autowired
	private PerhitunganTerakhirRepository perhitunganTerakhirRepository;

	public void save(PerhitunganTerakhir perhitunganTerakhir) {
		perhitunganTerakhirRepository.save(perhitunganTerakhir);
	}

	public void truncate() {
		perhitunganTerakhirRepository.truncate();
	}

	public List<PerhitunganTerakhir> findAllByVectorVLessThanEqual(Double vectorV) {
		return perhitunganTerakhirRepository.findAllByVectorVLessThanEqualOrderByVectorVDesc(vectorV);
	}

	public List<PerhitunganTerakhir> findAll() {
		return perhitunganTerakhirRepository.findAll();
	}
}
