package com.ht.member.basic;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(name = "requestParamSevlet", urlPatterns = "/request-param")	
public class RequestParamSevlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("파라미터 조회");
		
		request.getParameterNames().asIterator()
			.forEachRemaining(param -> System.out.println(param + "=" + request.getParameter(param)));
		System.out.println("파라미터 조회 끝");
		
		String username = request.getParameter("username");
		System.out.println("단일값 확인 : " + username);
	}
	
	
}
