package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UsersService;
import service.UsersServiceImpl;


@WebServlet({"/index.html","/users/*"})
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
		else if(command.equals("/users/signup")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("../member/signup.jsp");
			dispatcher.forward(request, response);
		}
		else if(command.equals("/users/emailcheck")) {
			System.out.println("요청 도달");
					
			usersService.emailCheck(request, response);
					
			RequestDispatcher dispatcher = 
				request.getRequestDispatcher("../member/emailcheck.jsp");
			dispatcher.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
