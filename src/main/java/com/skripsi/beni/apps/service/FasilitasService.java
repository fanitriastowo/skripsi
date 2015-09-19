package com.skripsi.beni.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skripsi.beni.apps.entity.Fasilitas;
import com.skripsi.beni.apps.repository.FasilitasRepository;

@Service
@Transactional
public class FasilitasService {

	@Autowired
	private FasilitasRepository fasilitasRepository;

	public List<Fasilitas> findAll() {
		return fasilitasRepository.findAll();
	}

	public void save(Fasilitas fasilitas) {
		fasilitasRepository.save(fasilitas);
	}

	public void delete(Integer id) {
		fasilitasRepository.delete(id);
	}

	public Fasilitas findOneById(Integer id) {
		return fasilitasRepository.findOne(id);
	}

	public void update(Fasilitas fasilitas) {
		fasilitasRepository.save(fasilitas);
	}
}
