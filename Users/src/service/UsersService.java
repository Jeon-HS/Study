package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UsersService {
	public void emailCheck(HttpServletRequest request, HttpServletResponse response);
	public void signup(HttpServletRequest request, HttpServletResponse response);
}
