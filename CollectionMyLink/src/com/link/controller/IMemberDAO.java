/*=================
 	IMemberDAO.java
 	- 인터페이스
=======================*/

package com.link.controller;

import java.util.ArrayList;

public interface IMemberDAO
{
	public int add(MemberDTO dto);
	public int count();
	public ArrayList<MemberDTO> list();
	
	public int modify(MemberDTO dto);
	public int remove(int mid);
}
