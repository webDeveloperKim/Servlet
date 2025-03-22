package hello.servlet.web.frontcontroller.v3.controller;

import java.util.Map;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;

public class MemberFormControllerV3 implements ControllerV3 {
	
	@Override
	public ModelView process(Map<String, String> paramMap){
		return new ModelView("new-form"); // 화면 jsp의 경로가 바뀌어도 한곳에서만 수정해서 관리되도록
		                                  // 논리 이름만 넘기는 방식의 패턴으로 변경   
	}
}
