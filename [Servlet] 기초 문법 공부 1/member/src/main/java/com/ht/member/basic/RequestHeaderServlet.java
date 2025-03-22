package com.ht.member.basic;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;


@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("ok");
		
		printStartLine(req);
		printHeaders(req);
	}
	
	private void printStartLine(HttpServletRequest request) {
		System.out.println("요청값 확인");
		System.out.println("request.getName()" + request.getMethod());
		System.out.println("request.getProtocol()" + request.getProtocol());
		System.out.println("request.getScheme()" + request.getScheme());
		System.out.println("request.getRequestURL()" + request.getRequestURL());
		System.out.println("request.getRequestURI()" + request.getRequestURI());
		System.out.println("request.getQueryString()" + request.getQueryString());
		System.out.println("request.isSecure()" + request.isSecure());
	}
	
	private void printHeaders(HttpServletRequest request) {
		System.out.println("헤더값 확인");
		
		request.getHeaderNames().asIterator().
				forEachRemaining(headerName -> 
				System.out.println(headerName + ": " + request.getHeader(headerName)));
	
		System.out.println("헤더값 확인 끝");
	}
	
}
