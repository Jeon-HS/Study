<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<script>
	//ajax 요청 객체 생성
	var request = new XMLHttpRequest();
	
	//ajax 요청 생성
	request.open('get', 'users/proxy', true);
	
	//요청을 전송
	request.send('');
	
	//요청을 전송하고 응답이 오면 호출될 콜백 메소드 생성
	request.addEventListener('load', function(event){
		alert(event.target.responseText)
	});
</script>
</head>
<body>
	<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
	<!-- jsp 파일에서 서버에 요청하는 경우는 상대 경로를 이용하지 
	않는 것이 좋습니다. -->
	<a href="${pageContext.request.contextPath}/users/signup">회원가입</a><br/>
	<c:if test = "${result == null}">
	<a href="${pageContext.request.contextPath}/users/login">로그인</a><br/>
	</c:if>
	<c:if test = "${result != null}">
	<a href="${pageContext.request.contextPath}/users/logout">로그아웃</a><br/>
	</c:if>
</body>
</html>


