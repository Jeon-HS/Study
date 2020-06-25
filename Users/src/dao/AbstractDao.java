package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class AbstractDao {
	//데이터베이스 연동에 필요한 속성
		Connection con;
		PreparedStatement pstmt;
		ResultSet rs;
		
		//데이터베이스 연결 메소드
		void connect() {
			try {
				//web.xml 파일에서 데이터베이스 접속정보를 가져오기
				Context context = new InitialContext();
				DataSource ds = 
					(DataSource)context.lookup(
						"java:comp/env/DBConn");
				//직접 접속하는 것이 아니라 이미 접속된 연결 객체를
				//빌려와서 사용합니다.
				con = ds.getConnection();
			}catch(Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		
		//데이터베이스 자원을 해제하는 메소드
		void close() {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
}
