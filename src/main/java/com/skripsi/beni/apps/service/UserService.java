package com.skripsi.beni.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skripsi.beni.apps.entity.Role;
import com.skripsi.beni.apps.entity.User;
import com.skripsi.beni.apps.repository.RoleRepository;
import com.skripsi.beni.apps.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public List<User> findAllByRoleUser() {
		Role roleUser = roleRepository.findOneByName("ROLE_GURU");
		return userRepository.findAllByRole(roleUser);
	}

	public void save(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Role roleUser = roleRepository.findOneByName("ROLE_GURU");
		user.setPassword(encoder.encode(user.getPassword()));
		user.setRole(roleUser);
		user.setEnabled(true);
		userRepository.save(user);
	}

	public User findOneById(Long id) {
		return userRepository.findOne(id);
	}

	public void updateIdentity(User user) {
		User userDTO = findOneById(user.getId());
		user.setPassword(userDTO.getPassword());
		user.setRole(userDTO.getRole());
		user.setEnabled(userDTO.getEnabled());
		userRepository.save(user);
	}

	public void delete(Long id) {
		userRepository.delete(id);
	}

}
