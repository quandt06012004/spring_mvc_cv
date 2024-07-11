package com.admin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AdminControllor {
	@RequestMapping(value = {"trang-chu"})
	public String index(Model model) {
		model.addAttribute("page", "home");
		return "admin";
	}
}
			