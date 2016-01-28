package com.skripsi.beni.apps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skripsi.beni.apps.entity.KondisiKelas;

@Repository
public interface KondisiKelasRepository extends JpaRepository<KondisiKelas, Long> {

}
