package hello.servlet.basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(response);
		System.out.println(request);
		
		String username = request.getParameter("username");
		String age = request.getParameter("age");
		
		System.out.println(username);
		System.out.println(age);
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		
		response.getWriter().write("username: " + username + "age :" + age);
		
		
		
	}
}
