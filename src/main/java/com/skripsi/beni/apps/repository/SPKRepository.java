package com.skripsi.beni.apps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.skripsi.beni.apps.entity.SPK;
import com.skripsi.beni.apps.entity.BobotSPK;

@Repository
public interface SPKRepository extends JpaRepository<SPK, Integer> {

	List<SPK> findAllByOrderByVectorVDesc();

	List<SPK> findAllByBobotSpkOrderByVectorVDesc(BobotSPK bobotSpk);

	@Query(value = "SELECT S1.* FROM SPK S1 "
				 + "LEFT JOIN SPK S2 "
				 + "ON S1.bobotspk_id = S2.bobotspk_id "
				 + "AND S1.vectorV < S2.vectorV "
				 + "WHERE S2.vectorV IS NULL", nativeQuery = true)
	List<SPK> findAllMaxGroupByVectorV();

	List<SPK> findAllByVectorVLessThanEqualOrderByVectorVDesc(Double vectorV);
	
}
