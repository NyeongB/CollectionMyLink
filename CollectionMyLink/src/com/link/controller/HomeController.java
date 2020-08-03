package com.link.controller;

import javax.servlet.http.HttpServletRequest;

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
	public String add(Model model, HttpServletRequest request)
	{
		
		ILinkDAO dao = SqlSession.getMapper(ILinkDAO.class);
		
		String link = request.getParameter("link");
		String title = request.getParameter("title");
		
		System.out.println("link : " + link);
		System.out.println("title : "+ title);
		LinkDTO dto = new LinkDTO();
		dto.setLink_title(title);
		dto.setLink_url(link);
		
		dao.add(dto);
		
		
		model.addAttribute("list", dao.list());
		
		return "/Main.jsp";
	}
	
	@RequestMapping(value = "/del.action", method= {RequestMethod.GET, RequestMethod.POST})
	public String del(Model model, HttpServletRequest request)
	{
		
		ILinkDAO dao = SqlSession.getMapper(ILinkDAO.class);
		
		String link_num = request.getParameter("link_num");
		
		//System.out.println(link_num);
		
		dao.del(link_num);
		
		
		model.addAttribute("list", dao.list());
		
		return "/Main.jsp";
	}
}
	