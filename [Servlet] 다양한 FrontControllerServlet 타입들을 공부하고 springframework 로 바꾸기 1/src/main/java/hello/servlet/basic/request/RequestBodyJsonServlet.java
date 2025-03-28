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

import com.fasterxml.jackson.databind.ObjectMapper;

import hello.servlet.basic.HelloData;

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet{
	
	// json으로 파싱된 값을 객체 형태로 다시 파싱할때 씀
	private ObjectMapper mapper = new ObjectMapper();
	
//	계속 오류나
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletInputStream inputStream = request.getInputStream();
		
		String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
		
		System.out.println("message : " + messageBody);
		
		HelloData helloData = mapper.readValue(messageBody, HelloData.class);
		
		System.out.println("helloData.username =" + helloData.getUsername());
		System.out.println("helloData.age =" + helloData.getAge());
		
		response.getWriter().write("ok");
		
	}
}
