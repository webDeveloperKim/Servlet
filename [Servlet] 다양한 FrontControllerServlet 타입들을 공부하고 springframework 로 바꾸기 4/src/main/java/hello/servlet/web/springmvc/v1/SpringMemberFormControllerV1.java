package hello.servlet.web.springmvc.v1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
// 스프링 부터 3.0 부터는 클래스 레벨 @RequestMapping 있어도 
// 스프링 컨트롤러로 인식하지 않음. 오직 @Controller 를 포함하고 있어야 인식함


// 스프링이 자동으로 빈 등록하게 하는 어노테이션
// 내부에 @component 이 있어서 컴포넌트 스캔 대상이 됨
@Controller
public class SpringMemberFormControllerV1 {
	
	// 요청정보를 매핑하는 어노테이션
	// 어노테이션 기반으로 동작하기 때문에 메서드 이름은 개발자 임의로 정하면 됨
	@RequestMapping("/springmvc/v1/members/new-form")
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("new-form");
	}
}
