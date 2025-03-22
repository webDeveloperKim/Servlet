package com.ht.member.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(name = "initServlet", urlPatterns = "/init")
public class InitServlet extends HttpServlet{
	private String message;
	
	@Override
	public void init() throws ServletException {
		message = "initServlet";
		System.out.println(message);
		System.out.println("-----");
		
	}
	
}
