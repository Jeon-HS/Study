<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>

<!-- js/register.js 파일의 링크를 설정 -->
<script src = "${pageContext.request.contextPath}/member/js/signup.js"></script>

<body>
<form id="signupform">
		<div id="msg"></div>
		이메일<input type="text" name="user_email" id="user_email"/>
		<div id="emailmsg"></div>
		비밀번호<input type="password" 
			name="user_password" id="user_password"/>
		<div id="passwordmsg"></div>
		비밀번호 확인<input type="password" 
			name="password1" id="password1"/><br/>
		이름<input type="text" name="user_name" id="user_name"/><br/>
		전화번호<input type="text" name="user_phone" id="user_phone"/><br/>
		
		<input type="button" value="회원가입" 
			id="signupbtn"/>
		<input type="button" value="메인으로" 
			id="mainbtn"/>	
		<input type="button" value="로그인" 
			id="loginbtn"/>
	</form>
	
</body>
</html>