package hello.servlet.web.springmvc.v1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
// 스프링 부터 3.0 부터는 클래스 레벨 @RequestMapping 있어도 
// 스프링 컨트롤러로 인식하지 않음. 오직 @Controller 를 포함하고 있어야 인식함


// 스프링이 자동으로 빈 등록하게 하는 어노테이션
// 내부에 @component 이 있어서 컴포넌트 스캔 대상이 됨
@Controller
public class SpringMemberSaveControllerV1 {
	
	// 요청정보를 매핑하는 어노테이션
	// 어노테이션 기반으로 동작하기 때문에 메서드 이름은 개발자 임의로 정하면 됨
	@RequestMapping("/springmvc/v1/members/save")
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
		
		MemberRepository memberRepository = MemberRepository.getInstance();
		
		// username, age 파라미터 값 받아서
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		
		// 멤버 객체 만들고                                                                                                                
		Member member = new Member(username, age);
		
		// save 메서드 호출해서 실제 member 객체에 반영
		memberRepository.save(member);
		
		// modelAndView 객체 만들어서
		ModelAndView modelAndView = new ModelAndView("save-result");
		// 실제 모델 필드에 set 하는거까지 (modelAndView가 가지고 있는 addObject 메서드 써서 모델객체에 set)
		modelAndView.addObject("member",member);
		
		return modelAndView;
	}
}
