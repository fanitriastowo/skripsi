package com.skripsi.beni.apps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skripsi.beni.apps.entity.SPK;
import com.skripsi.beni.apps.entity.TempBobot;

@Repository
public interface SPKRepository extends JpaRepository<SPK, Integer> {

	List<SPK> findAllByOrderByVectorVDesc();

	List<SPK> findAllByTempBobotOrderByVectorVDesc(TempBobot tempBobot);

}
