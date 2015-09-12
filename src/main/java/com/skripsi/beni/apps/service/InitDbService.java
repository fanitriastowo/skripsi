package com.skripsi.beni.apps.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skripsi.beni.apps.entity.Metode;
import com.skripsi.beni.apps.entity.Role;
import com.skripsi.beni.apps.entity.User;
import com.skripsi.beni.apps.repository.MetodeRepository;
import com.skripsi.beni.apps.repository.RoleRepository;
import com.skripsi.beni.apps.repository.UserRepository;

@Service
@Transactional
public class InitDbService implements InitializingBean {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MetodeRepository metodeRepository;

	@Override
	public void afterPropertiesSet() throws Exception {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);

		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);

		// User Admin
		User userAdmin = new User();
		userAdmin.setUsername("admin");
		userAdmin.setPassword(encoder.encode("admin"));
		userAdmin.setEnabled(true);
		userAdmin.setRole(roleAdmin);
		userRepository.save(userAdmin);
		
		// User Lain
		User userLain = new User();
		userLain.setUsername("user1");
		userLain.setPassword(encoder.encode("user1"));
		userLain.setEnabled(true);
		userLain.setRole(roleUser);
		userRepository.save(userLain);

		// ============================================== //
		Metode metode1 = new Metode();
		metode1.setMetode("Ceramah");
		metodeRepository.save(metode1);
		
		Metode metode2 = new Metode();
		metode2.setMetode("Diskusi");
		metodeRepository.save(metode2);
		
		Metode metode3 = new Metode();
		metode3.setMetode("Problem Solving");
		metodeRepository.save(metode3);
		
		Metode metode4 = new Metode();
		metode4.setMetode("Tanya Jawab");
		metodeRepository.save(metode4);

		Metode metode5 = new Metode();
		metode5.setMetode("Latihan");
		metodeRepository.save(metode5);
		
		Metode metode6 = new Metode();
		metode6.setMetode("Eksperimen");
		metodeRepository.save(metode6);
		
		Metode metode7 = new Metode();
		metode7.setMetode("Membaca dan Berdiskusi");
		metodeRepository.save(metode7);
		
		Metode metode8= new Metode();
		metode8.setMetode("Role Playing");
		metodeRepository.save(metode8);
		
		Metode metode9 = new Metode();
		metode9.setMetode("Karya Wisata");
		metodeRepository.save(metode9);
		
		Metode metode10 = new Metode();
		metode10.setMetode("Demonstrasi");
		metodeRepository.save(metode10);
		// =====================================================//
	}

}
