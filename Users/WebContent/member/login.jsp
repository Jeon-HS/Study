<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<script src="${pageContext.request.contextPath}/member/js/login.js"></script>
<body>
	<!--  action : 처리할 서버의 URL
	method : 전송방식(get, post)
	enctype : file이 존재하는 경우만 multipart/form-data
	최근에는 조회를 제외하고는 action을 설정하지 않고 method는 post로 설정해서
	get 과 post로 구분 -->
	<form method='post' id="loginform">
		아이디:<input type="text" id="user_email" name="user_email"/><br/>
		비밀번호:<input type="password" id="user_password" name="user_password"/><br/>
		<!-- 하나의 서버로 여러 디바이스의 요청을 처리하는 REST API 서버를
		이용하는 경우에는 submit 대신에 button을 만들어서 버튼을 누르면 ajax로 
		요청을 처리 bootstrap 같은 자바스크립트 라이브러리를 이용하게 되면
		button을 만들면 자동으로 submit을 만드는 경우가 있습니다.
		그런 경우에는 버튼을 form 외부에 생성 -->
		<input type="button" value="로그인" id="loginbtn"/>
		<input type="button" value="메인으로" id="mainbtn"/>
	
	</form>
</body>
</html>