package com.link.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

		
	@RequestMapping(value = "/main.action", method= {RequestMethod.GET, RequestMethod.POST})
	public String showMain(Model model)
	{
		return "/Main.jsp";
	}
}
	