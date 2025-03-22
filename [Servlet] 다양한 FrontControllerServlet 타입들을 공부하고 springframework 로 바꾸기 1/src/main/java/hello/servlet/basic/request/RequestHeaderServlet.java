package hello.servlet.basic.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RequestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		printStartLine(request);
	}
	
	private void printStartLine(HttpServletRequest request) {
		System.out.println("시작");
		
		System.out.println(request.getMethod());
		System.out.println(request.getProtocol());
		System.out.println(request.getScheme());
		
		System.out.println(request.getRequestURL());
		System.out.println(request.getRequestURI());
		
		System.out.println(request.getQueryString());
		
		System.out.println("종료");
	}
	
}
