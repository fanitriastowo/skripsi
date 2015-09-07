package com.skripsi.beni.apps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class IndexController {

	@RequestMapping("/")
	public ModelAndView indexPage() {
		ModelAndView modelAndView = new ModelAndView("home");
		return modelAndView;
	}
	
	@RequestMapping("/login")
	public ModelAndView loginPage() {
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/loginfail")
	public ModelAndView loginFailPage(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("success", false);
		return new ModelAndView("redirect:/login");
	}
}
