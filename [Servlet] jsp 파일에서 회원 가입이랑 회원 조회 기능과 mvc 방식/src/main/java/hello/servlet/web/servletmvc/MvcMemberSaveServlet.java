package hello.servlet.web.servletmvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

@WebServlet(name = "mvcMemberSaveServlet", urlPatterns = "/servlet-mvc/members/save")
public class MvcMemberSaveServlet extends HttpServlet{
	
	private MemberRepository memberRepository = MemberRepository.getInstance();
	
	// 비즈니스 로직 수행
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberSaveServlet.service");
		
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		
		Member member = new Member(username, age);
		
		System.out.println("==");
		System.out.println("member = " + member);
		
		memberRepository.save(member);
		
		// model에 데이터를 보관하는 것
		request.setAttribute("member", member);
		
		String viewPath = "/WEB-INF/views/save-result.jsp";
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewPath);
		requestDispatcher.forward(request, response);
		
	}
}
