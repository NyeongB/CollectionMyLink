package com.link.controller;

import java.util.ArrayList;

public interface ILinkDAO
{
	public ArrayList<LinkDTO> list(IndexDTO dto);
	
	public void add(LinkDTO dto);
	
	public void del(String link_num);
	
	public int getCount();
}
