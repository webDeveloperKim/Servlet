package hello.servlet.web.servletmvc;

import java.io.IOException;

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
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("mvcMemberSaveServlet.service");
		// username 으로 넘어오는 파라미터값 타입에 맞게 담는거
		String username = request.getParameter("username");
		// age도 동일
		int age = Integer.parseInt(request.getParameter("age"));
		
		
		Member member = new Member(username, age);
					
		System.out.println(memberRepository.save(member)); 
		System.out.println("member :" + member);
		
		
		//Model 에 담기
//		request.setAttribute("member", member);
		
		// 화면에 보내기
//		String viewPath = "/WEB-INF/views/save-result.jsp";
		
		// 실제 요청을 위임하는 것
//		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
//		dispatcher.forward(request, response);	
		
	}
}
