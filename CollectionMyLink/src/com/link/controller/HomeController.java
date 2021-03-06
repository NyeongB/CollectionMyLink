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
	public String showMain(Model model, HttpServletRequest request)
	{
		
		ILinkDAO dao = SqlSession.getMapper(ILinkDAO.class);

		
		int count = dao.getCount();
		//System.out.println(count);
		
		// 두개 반드시 선언
		Paging paging = new Paging();
		String pageNum = request.getParameter("pageNum");		
		
		
		//테이블에서 가져올 리스트의 시작과 끝 위치
		int start = paging.getStart(pageNum,count );
		int end = paging.getEnd(pageNum, count);
		
		// 페이지번호를 받아온 
		String pageIndexList = paging.pageIndexList(pageNum, count);
		
		
		// 시작과 끝 dto에 담기( 여기선 IndexDTO로 했지만 매개변수로 DTO를 쓰고있는경우는 그 DTO안에 start,end만들어야함)
		IndexDTO dto = new IndexDTO();
		dto.setStart(start);
		dto.setEnd(end);
		
		// 리스트 불러올때 시작과 끝점 추가해야함 
		// 참고 com.banana.admin.IAdminPointDAO
		
		
		model.addAttribute("pageIndexList", pageIndexList);
		
		
		
		model.addAttribute("list", dao.list(dto));
		
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
		
		
		//model.addAttribute("list", dao.list());
		
		return "/main.action";
	}
	
	@RequestMapping(value = "/del.action", method= {RequestMethod.GET, RequestMethod.POST})
	public String del(Model model, HttpServletRequest request)
	{
		
		ILinkDAO dao = SqlSession.getMapper(ILinkDAO.class);
		
		String link_num = request.getParameter("link_num");
		
		//System.out.println(link_num);
		
		dao.del(link_num);
		
		
		//model.addAttribute("list", dao.list());
		
		return "/main.action";
	}
}
	