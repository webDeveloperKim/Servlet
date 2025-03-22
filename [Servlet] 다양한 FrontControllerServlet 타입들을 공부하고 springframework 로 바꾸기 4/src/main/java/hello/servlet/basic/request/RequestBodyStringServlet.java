package hello.servlet.basic.request;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StreamUtils;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletInputStream inputStream = request.getInputStream();
		// request.inputstream()하면 http메세지 바디의 데이터를 바이트코드로 바로 얻을 수 있음
		// 바이트 코드로 얻은 정보를, String으로 변환해서 담을예정
		
		String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
		System.out.println(" messageBody: " + messageBody);
		
		// 브라우저 화면에 바로 출력하는 메서드
		response.getWriter().write("ok");
	}
}
