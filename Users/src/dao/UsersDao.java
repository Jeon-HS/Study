package dao;

import domain.Users;

public class UsersDao extends AbstractDao {

	public UsersDao() {}
	
	private static UsersDao usersDao;
	
	public static UsersDao sharedInstance() {
		if(usersDao == null) {
			usersDao = new UsersDao();
		}
		return usersDao;
	}
	
	public boolean emailCheck(String email) {
		boolean result = false;
		connect();
		
		try {
			//sql 생성
			//email을 대문자로 변경해서 비교
			pstmt = con.prepareStatement(
				"select user_email from users where upper(user_email) = ?");
			//데이터 바인딩
			pstmt.setString(1, email.toUpperCase());
			//SQL 실행
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = false;
			}else {
				result = true;
			}
			
		}catch(Exception e) {
			System.out.println("DAO:" + e.getMessage());
			e.printStackTrace();
		}
		close();
		return result;
	}
	
	//데이터 삽입 하는 메소드
	public int signup(Users users) {
		int result = -1;
		connect();
		try{
			pstmt = con.prepareStatement("insert into users (user_email, user_password, user_name, user_phone) values(?,?,?,?);");
			pstmt.setString(1, users.getUser_email());
			pstmt.setString(2, users.getUser_password());
			pstmt.setString(3, users.getUser_name());
			pstmt.setString(4, users.getUser_phone());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("DAO : " + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	//로그인 처리를 위한 메소드
	public Users login(String email) {
		//System.out.println("DAO의 email : " + email);
		
		//없는 아이디인 경우는 null을 리턴
		Users user =null;
		connect();
		try {
			//SQL 만들기
			//Users 테이블에서 id를 가지고 데이터를 찾아오기
			pstmt = con.prepareStatement("select * from users where user_email = ?");
			//SQL 바인딩
			pstmt.setString(1, email);
			//SQL 실행
			rs = pstmt.executeQuery();
			//데이터 읽어서 저장
			if(rs.next()) {
				user = new Users();
				user.setUser_email("user_email");
				user.setUser_password("user_password");
				user.setUser_name("user_name");
				user.setUser_phone("user_phone");
			}
		}catch(Exception e) {
			System.out.println("DAO: " + e.getMessage());
			e.printStackTrace();
		}
		
		close();
		return user;
	}
	
}
