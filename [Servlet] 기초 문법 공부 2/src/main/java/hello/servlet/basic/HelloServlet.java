package hello.servlet.basic;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(response);
		System.out.println(request);
	
		String username = request.getParameter("username");
		String age = request.getParameter("age");
	
		System.out.println(username);
		System.out.println(age);
		
		response.setContentType("text/plane");
		response.setCharacterEncoding("utf-8");
	
		response.getWriter().write("username : " + username + "age : " + age);
	}
}
