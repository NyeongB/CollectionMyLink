package com.link.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {

	@Autowired
	private SqlSession SqlSession;
	
	@RequestMapping(value = "/main.action", method= {RequestMethod.GET, RequestMethod.POST})
	public String showMain(Model model)
	{
		
		ILinkDAO dao = SqlSession.getMapper(ILinkDAO.class);
		
		model.addAttribute("list", dao.list());
		
		return "/Main.jsp";
	}
	
	@RequestMapping(value = "/add.action", method= {RequestMethod.GET, RequestMethod.POST})
	public String add(Model model)
	{
		
		ILinkDAO dao = SqlSession.getMapper(ILinkDAO.class);
		
		model.addAttribute("list", dao.list());
		
		return "/Main.jsp";
	}
}
	