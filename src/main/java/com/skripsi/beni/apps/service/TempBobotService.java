package com.skripsi.beni.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skripsi.beni.apps.entity.TempBobot;
import com.skripsi.beni.apps.repository.TempBobotRepository;

@Service
@Transactional
public class TempBobotService {

	@Autowired
	private TempBobotRepository tempBobotRepository;

	public void save(TempBobot tempBobot) {
		tempBobotRepository.save(tempBobot);
	}

	public TempBobot findOneById(Integer id) {
		return tempBobotRepository.findOne(id);
	}

	public List<TempBobot> findAllDesc() {
		return tempBobotRepository.findAllByOrderByTanggalDesc();
	}
	
}
