package hello.servlet.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

@WebServlet(name = "MemberSaveServlet", urlPatterns = "/servlet/members/save")
public class MemberSaveServlet extends HttpServlet{
	
	private MemberRepository memberRepository = MemberRepository.getInstance();
	
	// 비즈니스 로직 수행
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberSaveServlet.service");
		
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		
		Member member = new Member(username, age);
		
		memberRepository.save(member);
		
		System.out.println("member = " + member);
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter w = response.getWriter();
		w.write("<html>\n" +
				 "<head>\n" +
				 "    <meta charset=\"UTF-8\">\n" +
				 "</head>\n" +
				 "<body>\n" +
				 "성공\n" +
				 "<ul>\n" +
				 "    <li>id="+member.getId()+"</li>\n" +
				 "    <li>username="+member.getUsername()+"</li>\n" +
				 "    <li>age="+member.getAge()+"</li>\n" +
				 "</ul>\n" +
				 "<a href=\"/index.html\">메인</a>\n" +
				 "</body>\n" +
				 "</html>");
	}
}
