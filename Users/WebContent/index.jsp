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
		dao.UsersDao usersDao = dao.UsersDao.sharedInstance();
		domain.Users users = new domain.Users();
		users.setUser_email("apfhd0965@naver.com");
		users.setUser_password("0000");
		users.setUser_name("짱구");
		users.setUser_phone("01011112222");
	
		System.out.println(usersDao.signup(users));
	%>
	 

	<%
	dao.UsersDao userDao = dao.UsersDao.sharedInstance();
	System.out.println(
			userDao.emailCheck("qazxsw6636@naver.com"));
	%>

	<!-- 바로 user/main으로 포워딩 하도록 해주는 코드 
	전자 정보 프레임워크가 만들어주는 프로젝트에서 index.jsp에 보면
	이런 코드가 존재합니다.-->
	<jsp:forward page="users/main"></jsp:forward>
	<jsp:forward page="users/login"></jsp:forward>
</body>
</html>