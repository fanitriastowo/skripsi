package com.skripsi.beni.apps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skripsi.beni.apps.entity.TempBobot;

@Repository
public interface TempBobotRepository extends JpaRepository<TempBobot, Integer> {

	List<TempBobot> findAllByOrderByTanggalDesc();

}
