<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 관리</title>
</head>
<body>
	<%
	dao.UsersDao userDao = dao.UsersDao.sharedInstance();
	System.out.println(
			userDao.emailCheck("qazxsw6636@naver.com"));
	%>

	<!-- 바로 user/main으로 포워딩 하도록 해주는 코드 
	전자 정보 프레임워크가 만들어주는 프로젝트에서 index.jsp에 보면
	이런 코드가 존재합니다.-->
	<jsp:forward page="users/main"></jsp:forward>
</body>
</html>