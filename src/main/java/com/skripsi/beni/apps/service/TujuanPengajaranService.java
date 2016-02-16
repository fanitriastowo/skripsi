package com.skripsi.beni.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skripsi.beni.apps.entity.kriteria.TujuanPengajaran;
import com.skripsi.beni.apps.repository.TujuanPengajaranRepository;

@Service
@Transactional
public class TujuanPengajaranService {

	@Autowired
	private TujuanPengajaranRepository tujuanPengajaranRepository;

	public List<TujuanPengajaran> findAll() {
		return tujuanPengajaranRepository.findAll();
	}

}
