package hello.servlet.web.frontcontroller.v5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import hello.servlet.web.frontcontroller.v5.adapter.ControV3HandlerAdapter;

@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet{
	private final Map<String, Object> handlerMappingMap = new HashMap<>();
	private List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();
	
	// 생성자 
	public FrontControllerServletV5() {
		initHandlerMapping();
		initHandlerAdapters();
	}
	
	// 핸들러 역할하는 컨트롤러를 매핑하는 메서드
	private void initHandlerMapping() {
		handlerMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
		handlerMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
		handlerMappingMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());
	}
	
	private void initHandlerAdapters() {
		handlerAdapters.add(new ControV3HandlerAdapter());
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object handler = getHandler(request);
		if(handler == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		MyHandlerAdapter adapter = getHandlerAdapter(handler);
		ModelView modelView = adapter.handle(request, response, handler);
		
		MyView myView = viewResolver(modelView.getViewName());
		myView.render(handlerMappingMap, request, response);
		
	}
	
	// 핸들러 컨트롤러 가져오는 메서드
	private Object getHandler(HttpServletRequest request) {
		String requestURI = request.getRequestURI();
		return handlerMappingMap.get(requestURI);
	}
	
	// 핸들러 컨트롤러가 v3컨트롤러가 맞는지 확인하는 어댑터
	private MyHandlerAdapter getHandlerAdapter(Object handler) {	
		for (MyHandlerAdapter adapter : handlerAdapters) {
			if(adapter.supports(handler)) {
				return adapter;
			}
		}
		throw new IllegalArgumentException("handler adapter를 찾을 수 없음. handler :: " + handler);
	}
	
	
	// 논리적인 뷰이름으로 viewPath에 맞는 객체 생성
	private MyView viewResolver(String viewName) {
		return new MyView("/WEB-INF/views/" + viewName + ".jsp");
	}
}






