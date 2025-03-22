package hello.servlet.web.frontcontroller.v5.adapter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;

public class ControV3HandlerAdapter implements MyHandlerAdapter{
	
	
	// ControllerV3을 처리할 수 있는 어댑터
	@Override
	public boolean supports(Object handler) {
		return (handler instanceof ControllerV3);
	}
	
	// 파라미터로 넘어온 handler(=컨트롤러)를 ControllerV3으로 변환한 다음 호출(=객체 사용)
	@Override
	public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws ServletException, IOException {
		
		ControllerV3 controller = (ControllerV3)handler;
		
		Map<String, String> paramMap = createParamMap(request);
		ModelView modelView = controller.process(paramMap);
		
		return modelView;
	}
	
	// 여러 파라미터를 key,value 쌍으로 담아서 return하는 메서드
	private Map<String, String> createParamMap(HttpServletRequest request){
		Map<String, String> paramMap = new HashMap<>();
		request.getParameterNames().asIterator()
		.forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
		
		return paramMap;
	} 
	
}
