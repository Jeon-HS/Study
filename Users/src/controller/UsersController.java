package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Users;
import service.UsersService;
import service.UsersServiceImpl;


@WebServlet({"/index.html","/users/*"})
@MultipartConfig(location="c:\\upload")
public class UsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UsersService usersService;
    
    public UsersController() {
        super();
        usersService = UsersServiceImpl.sharedInstance();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = 
			requestURI.substring(contextPath.length());
		
		String method = request.getMethod();
		
		if(command.equals("/index.html")) {
			response.sendRedirect("./");
		}
		//단순 페이지 이동은 포워딩
		else if(command.equals("/users/main")) {
			RequestDispatcher dispatcher = 
				request.getRequestDispatcher("../member/main.jsp");
			dispatcher.forward(request, response);
		}
		else if(command.equals("/users/signup") && method.equals("GET") ) {
			
			usersService.signup(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher("../member/signup.jsp");
			dispatcher.forward(request, response);
		}
		else if(command.equals("/users/signup") && method.equals("POST")) {
			//회원가입을 처리해주는 메소드 호출
			usersService.signup(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher("../member/signupresult.jsp");
			dispatcher.forward(request, response);
		}
		else if(command.equals("/users/emailcheck")) {
			//System.out.println("요청 도달");
					
			usersService.emailCheck(request, response);
					
			RequestDispatcher dispatcher = 
				request.getRequestDispatcher("../member/emailcheck.jsp");
			dispatcher.forward(request, response);
		}
		else if(command.equals("/users/login") && method.equals("GET")) {
			RequestDispatcher dispatcher = 
				request.getRequestDispatcher("../member/login.jsp");
			dispatcher.forward(request, response);
		}
		else if(command.equals("/users/login") && method.equals("POST")) {
			//System.out.println("요청도착");
			//로그인 처리를 위한 서비스 메소드 호출
			//작업을 처리하는 경우에는 서비스의 메소드를 호출하는 것이고
			//단순 페이지 이동은 서버스의 메소드를 호출하지 않음
			//정보 수정의 경우는 상세 데이터를 가져오고 수정
			usersService.login(request, response);
			RequestDispatcher dispatcher = 
				request.getRequestDispatcher("../member/loginresult.jsp");
			dispatcher.forward(request, response);
		}
		else if(command.equals("/users/proxy")) {
			RequestDispatcher dispatcher = 
				request.getRequestDispatcher("../member/proxy.jsp");
			dispatcher.forward(request, response);
		}
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
