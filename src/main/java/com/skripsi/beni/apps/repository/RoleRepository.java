package com.skripsi.beni.apps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skripsi.beni.apps.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findOneByName(String name);

}
