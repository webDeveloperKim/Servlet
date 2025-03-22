<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="save" method="post">
	username: <input type="text" name="username"/>
	age: <input type="text" name="age"/>
	<button type="submit"> 전송 </button>
</form>

<!-- 
	
	현재 계층 경로 
	/servlet-mvc/members/
	+ form 태그 action 속성 값 (=save)
	
	위의 결과 
	/servlet-mvc/members/save

 -->


</body>
</html>