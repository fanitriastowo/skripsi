package com.skripsi.beni.apps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skripsi.beni.apps.entity.Role;
import com.skripsi.beni.apps.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findAllByRole(Role role);

}
