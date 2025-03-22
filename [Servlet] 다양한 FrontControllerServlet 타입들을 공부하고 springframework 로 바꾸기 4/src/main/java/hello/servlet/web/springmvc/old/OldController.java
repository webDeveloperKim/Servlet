package hello.servlet.web.springmvc.old;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

// '/springmvc/old-controller' 이 이름으로 스프링 빈 등록
// 빈의 이름으로 URL 매핑
@Component("/springmvc/old-controller")
public class OldController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("OldController 호출");
		
		
		// 스프링부트는 internalResourceViewResolver라는 뷰 리졸버를 자동으로 등록하는데 이때
		// application.properties에 등록한 prefix정보랑,suffix정보를 사용해서 등록
		
		return new ModelAndView("new-form");
	}
	
	// 스프링이 가지고 있는 handlerMapping
	// RequestMmappingHandlerMapping : 어노테이션 기반의 컨트롤러인 @RequestMapping 에서 사용함
	// BeanNameUrlHandlerMapping : 스프링 빈의 이름으로 핸들러를 찾음
	
	// HandlerAdapter
	// RequestMappingHandlerAdapter : 어노테이션 기반의 컨트롤러인 @RequestMapping에서 사용
	// HttpRequestHandlerAdapter : HttpRequestHandler 처리
	// SimpleControllerHandlerAdapter : Controller 인터페이스 (어노테이션x)처리
	
	
	
	
}







