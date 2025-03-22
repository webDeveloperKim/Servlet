package hello.servlet.basic.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet{
	
	// 서블릿을 만드는 이유 : http로 데이터 통신하기 위함
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("전체 파라미터조회 시작");
		
		request.getParameterNames().asIterator()
				.forEachRemaining(paramName -> System.out.println(paramName + ": " + request.getParameter(paramName)));
		
		System.out.println("전체 파라미터 조회 끝");
		
		System.out.println("단일파라미터 조회");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		System.out.println(name + " " + email);
		
	}
	
	
}
