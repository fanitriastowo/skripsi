package com.skripsi.beni.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skripsi.beni.apps.entity.BobotSPK;
import com.skripsi.beni.apps.repository.BobotSpkRepository;

@Service
@Transactional
public class BobotSpkService {

	@Autowired
	private BobotSpkRepository bobotSpkRepository;

	public void save(BobotSPK bobotSPK) {
		bobotSpkRepository.save(bobotSPK);
	}

	public BobotSPK findOneById(Long id) {
		return bobotSpkRepository.findOne(id);
	}

	public List<BobotSPK> findAllDesc() {
		return bobotSpkRepository.findAllByOrderByTanggalDesc();
	}
	
}
