package com.skripsi.beni.apps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.skripsi.beni.apps.entity.PerhitunganTerakhir;

@Repository
public interface PerhitunganTerakhirRepository extends JpaRepository<PerhitunganTerakhir, Long> {

	@Query(value = "TRUNCATE TABLE PERHITUNGAN_TERAKHIR", nativeQuery = true)
	@Modifying
	void truncate();

	List<PerhitunganTerakhir> findAllByVectorVLessThanEqualOrderByVectorVDesc(Double vectorV);

}
