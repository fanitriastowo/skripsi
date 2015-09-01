package com.skripsi.beni.apps.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skripsi.beni.apps.entity.Role;
import com.skripsi.beni.apps.repository.RoleRepository;

@Service
@Transactional
public class InitDbService implements InitializingBean {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void afterPropertiesSet() throws Exception {
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
	}

}
