package com.skripsi.beni.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.skripsi.beni.apps.entity.Metode;
import com.skripsi.beni.apps.repository.MetodeRepository;

@Service
public class MetodeService {

	@Autowired
	private MetodeRepository metodeRepository;

	public List<Metode> tampilSemuaMetode() {
		return metodeRepository.findAll(new Sort(Direction.ASC, "metode"));
	}

	public Metode findOneById(Long id) {
		return metodeRepository.findOne(id);
	}

	public void update(Metode metode) {
		metodeRepository.save(metode);
	}

	public void delete(Long id) {
		metodeRepository.delete(id);
	}

	public void save(Metode metode) {
		metodeRepository.save(metode);
	}
}
