package com.link.controller;

import java.util.ArrayList;

public interface ILinkDAO
{
	public ArrayList<LinkDTO> list();
	
	public void add(LinkDTO dto);
	
	public void del(String link_num);
}
