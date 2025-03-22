package hello.servlet.web.springmvc.v2;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

// 클래스 레벨 + 메서드 레벨
// 공통 매핑
@Controller
@RequestMapping("/springmvc/v2/members/")
public class SpringMemberControllerV2 {
	
	private MemberRepository memberRepository = MemberRepository.getInstance();
	
	// get 방식은 단순조회
	// 공통매핑 + 메서드 레벨 url 매핑 조합
	// /springmvc/v2/members/new-form
	@GetMapping("/new-form")
	public ModelAndView newForm() {
		return new ModelAndView("new-form");
	}
	
	// post 방식은 비즈니스 로직처리
	// /springmvc/v2/members/save
	@PostMapping("/save")
	public String save(
			@RequestParam("username") String username,
			@RequestParam("age") int age,
			Model model) {
		
		MemberRepository memberRepository = MemberRepository.getInstance();                                                                                       
		Member member = new Member(username, age);
		
		memberRepository.save(member);
		
		model.addAttribute("member", member);
		
		return "save-result";
	}
	
	// /springmvc/v2/members
	@GetMapping()
	public String members(Model model) {
		List<Member> members = memberRepository.findAll();
		model.addAttribute("members", members);
			
		return "members";
	}
}
