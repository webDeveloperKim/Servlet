<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>    
<%@ page import="hello.servlet.domain.member.Member" %>        

<!-- 자바 코드 수행 -->
<!-- jsp에서는 <%%> 가 없으면 모두 화면에 바로 찍어냄 (ex)print.write()) -->
 
<%
    // jsp도 결국 servlet으로 변환되기때문에 request, response 바로 사용가능
    // 사실상 jsp 변환된 코드가 servlet 코드랑 같아짐(=service메서드 호출함)
	MemberRepository memberRepository = MemberRepository.getInstance();
	
	System.out.print("save.jsp \n");
	String username = request.getParameter("username");
	int age = Integer.parseInt(request.getParameter("age")); 
	
	Member member = new Member(username,age);
	System.out.print("member:" + member);
	
	memberRepository.save(member);
%>

<!-- 화면작업 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>id=<%=member.getId()%></li>
		<li>username=<%=member.getUsername()%></li>
		<li>age=<%=member.getAge()%></li>
	</ul>
	<a href="/index.html">메인</a>
</body>
</html>


