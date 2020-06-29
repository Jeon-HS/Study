package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UsersService {
	//이메일 중복 검사를 위한 메소드
	public void emailCheck(HttpServletRequest request, HttpServletResponse response);
	//회원가입을 위한 메소드
	public void signup(HttpServletRequest request, HttpServletResponse response);
	//로그인을 위한 메소드
	public void login(HttpServletRequest request, HttpServletResponse response);
	//proxy 서비스를 위한 메소드
	public void proxy(HttpServletRequest request, HttpServletResponse response);
}
