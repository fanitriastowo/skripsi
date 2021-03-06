package com.skripsi.beni.apps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skripsi.beni.apps.entity.BobotSPK;

@Repository
public interface BobotSpkRepository extends JpaRepository<BobotSPK, Long> {

	List<BobotSPK> findAllByOrderByTanggalDesc();

}
