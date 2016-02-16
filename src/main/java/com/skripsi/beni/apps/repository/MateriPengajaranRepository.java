package com.skripsi.beni.apps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skripsi.beni.apps.entity.kriteria.MateriPengajaran;

@Repository
public interface MateriPengajaranRepository extends JpaRepository<MateriPengajaran, Long> {

}
