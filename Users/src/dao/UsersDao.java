package dao;

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
				"select user_email from user where upper(user_email) = ?");
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
	
}
