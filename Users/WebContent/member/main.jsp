<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
</head>
<body>
	<!-- jsp 파일에서 서버에 요청하는 경우는 상대 경로를 이용하지 
	않는 것이 좋습니다. -->
	<a href="${pageContext.request.contextPath}/users/signup">회원가입</a><br/>
</body>
</html>


