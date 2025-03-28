package hello.servlet.web.frontcontroller.v4;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4;

@WebServlet(name = "frontControllerServletV4", urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet{

	private Map<String, ControllerV4> controllerMap = new HashMap<>();
	
	public FrontControllerServletV4() {
		controllerMap.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
		controllerMap.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
		controllerMap.put("/front-controller/v4/members", new MemberListControllerV4());
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		ControllerV4 controller = controllerMap.get(requestURI);
		
		if(controller == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		// httpServlet객체 종속성 없애기 위함
		Map<String, String> paramMap = createParamMap(request); // 아래 createParamMap() 호출한 결과값을 paramMap에 담음
		Map<String, Object> model = new HashMap<>();
		
		String viewName = controller.process(paramMap,model);
		
		MyView myView = viewResolver(viewName);
		myView.render(model, request, response);
	}
	
	private Map<String, String> createParamMap(HttpServletRequest request){
		Map<String, String> paramMap = new HashMap<>();
		request.getParameterNames().asIterator()
		.forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
		
		return paramMap;
	} 
	
	private MyView viewResolver(String viewName) {
		return new MyView("/WEB-INF/views/" + viewName + ".jsp");
	}
	
}
