package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.mindrot.jbcrypt.BCrypt;

import dao.UsersDao;
import domain.Users;
import sun.net.www.protocol.http.HttpURLConnection;

public class UsersServiceImpl implements UsersService {
		//Service 에서 사용할 UsersDao 변수
		private UsersDao usersDao;
		
		private UsersServiceImpl() {
			usersDao = UsersDao.sharedInstance();
		}
		
		private static UsersService usersService;
		
		public static UsersService sharedInstance() {
			if(usersService == null) {
				usersService = new UsersServiceImpl();
			}
			return usersService;
		}

		@Override
		public void emailCheck(HttpServletRequest request, HttpServletResponse response) {
			//1.파라미터 읽기
			try {
				request.setCharacterEncoding("utf-8");
			}catch(Exception e) {
				System.out.println("Service:" + e.getMessage());
				e.printStackTrace();
			}
			String email = request.getParameter("email");
			
			//2.별도의 작업을 수행해야 하면 처리
			//암호화, 파일 업로드, 파라미터를 다른 자료형으로 변환
			//업무처리에 필요한 알고리즘
				
			//3.DAO 작업이 필요하면 호출할 DAO 메소드의 매개변수를 생성
				
			//4.DAO의 메소드를 호출해서 결과를 변수에 저장
			boolean result = usersDao.emailCheck(email);
				
			//5.단순 웹 페이지를 위한 서버의 경우는 결과들을 request 나 session에 저장
			
			//REST API 서버의 경우는 JSONObject 클래스의 객체를
			//만들어서 저장한 후 request에 저장합니다.
			//웹 페이지를 위한 로그인의 경우에만 session에 저장하던지
			//데이터베이스에 로그인 여부를 저장해 놓습니다.
			JSONObject object = new JSONObject();
			object.put("result", result);
				
			//request에 저장
			request.setAttribute("result", object);
			
		}

		@Override
		public void signup(HttpServletRequest request, HttpServletResponse response) {
			
			try {
				//파라미터 읽기
				//파라미터 이름이 signup.jsp 파일에 있는 form 안에있는
				//요소들의 name과 일치해야합니다.
				request.setCharacterEncoding("utf-8");
				String email = request.getParameter("user_email");
				String password = request.getParameter("user_password");
				String name = request.getParameter("user_name");
				String phone = request.getParameter("user_phone");
				
				//DAO 파라미터 만들기
				Users users = new Users();
				users.setUser_email(email);
				//users.setUser_password(password);
				//암호화해서 저장
				users.setUser_password(BCrypt.hashpw(password, BCrypt.gensalt()));
				users.setUser_name(name);
				users.setUser_phone(phone);
				
				//Dao 메소드 호출
				int result = usersDao.signup(users);
				
				//결과를 저장
				JSONObject object = new JSONObject();
				if(result > 0) {
					object.put("result", true);
				}else {
					object.put("result", false);
				}
				
				request.setAttribute("result", object);
				
				
			}catch(Exception e) {
				System.out.println("service : " + e.getMessage() );
				e.printStackTrace();
			}
			
		}

		@Override
		public void login(HttpServletRequest request, HttpServletResponse response) {
			//1.파라미터 읽기
			try {
				request.setCharacterEncoding("utf-8");
			}catch(Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			String email = request.getParameter("user_email");
			String password = request.getParameter("user_password");
			
			//2.필요한 처리
			
			//3.DAO 메소드를 호출해야하면 DAO 메소드의 매개변수를 생성
			
			//4.DAO 메소드를 호출해서 결과를 저장
			Users user = usersDao.login(email);
			//5.결과를 가지고 필요한 처리를 수행
			if(user != null) {
				//비밀번호 확인
				if(BCrypt.checkpw(password, user.getUser_password())) {
					//비밀번호가 일치하는 경우 - 비밀번호는 삭제
					user.setUser_password(null);
				}else {
					//비밀번호가 틀린 경우 user == null
					user = null;
				}
			}
			
			JSONObject object = new JSONObject();
			if(user != null) {
				object.put(email, user.getUser_email());
				object.put(password, user.getUser_password());
				
			}else {
				object = null;
			}
			//6.요청 처리 결과를 저장
			request.getSession().setAttribute("result", object);
		}

		@Override
		public void proxy(HttpServletRequest request, HttpServletResponse response) {
			//Java Application에 구현할 때는 Thread 안에 구현
			//Android Application 에 구현할 때는 Thread 안에 구현하고
			//회면에 표시할 때는 Handler를 이용하거나 
			//Thread 와 Handler의 조합인 AsycTask를 이용
			
			try {
				//데이터를 가져올 URL을 생성
				URL url = new URL("http://www.kma.go.kr/weather/forecast/mid-term-xml.jsp?stnld=109");
				//연결객체를 생성
				HttpURLConnection conn = (HttpURLConnection)url.openConnection();
				//옵션을 설정
				conn.setConnectTimeout(30000);
				conn.setUseCaches(false);
				//헤더 설정을 해야 하는 경우에는 
				//conn.setRequestProperty("헤더이름", "헤더값");
				
				//post전송이면
				//conn.setRequestMethod("POST");
				
				//데이터 읽어오기
				StringBuilder sb = new StringBuilder();
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				while(true) {
					String line = br.readLine();
					if(line == null) {
						sb.append(line + "\n");
					}
					br.close();
					conn.disconnect();
					request.setAttribute("result", sb.toString());
				}
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
		}
}
