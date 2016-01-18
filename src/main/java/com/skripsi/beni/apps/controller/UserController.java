package com.skripsi.beni.apps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.skripsi.beni.apps.entity.User;
import com.skripsi.beni.apps.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@ModelAttribute
	public User construct() {
		return new User();
	}

	@RequestMapping
	public ModelAndView halamanUser() {
		ModelAndView modelAndView = new ModelAndView("user");
		List<User> users = userService.findAllByRoleUser();
		modelAndView.addObject("users", users);
		return modelAndView;
	}

	@RequestMapping("/add")
	public ModelAndView addUser(@ModelAttribute("user") User user) {
		userService.save(user);
		ModelAndView modelAndView = new ModelAndView("redirect:/user");
		return modelAndView;
	}

	@RequestMapping("/prepare_update/{id}")
	@ResponseBody
	public User prepareUpdate(@PathVariable("id") Long id) {
		User user = userService.findOneById(id);
		return user;
	}

	@RequestMapping("/update")
	public ModelAndView updateUser(@ModelAttribute("user") User user) {
		userService.updateIdentity(user);
		return new ModelAndView("redirect:/user");
	}

	@RequestMapping("/delete/{id}")
	public ModelAndView deleteUser(@PathVariable("id") Long id) {
		userService.delete(id);
		return new ModelAndView("redirect:/user");
	}

}
