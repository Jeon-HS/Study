package domain;

public class Users {
	private String user_email;
	private String user_password;
	private String user_name;
	private String user_phone;
	private boolean isremove;
	
	//매개변수가 없는 생성자
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//매개변수가 있는 생성자
	public Users(String user_email, String user_password, String user_name, String user_phone, boolean isremove) {
		super();
		this.user_email = user_email;
		this.user_password = user_password;
		this.user_name = user_name;
		this.user_phone = user_phone;
		this.isremove = isremove;
	}
	
	//접근자 메소드
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public boolean isIsremove() {
		return isremove;
	}
	public void setIsremove(boolean isremove) {
		this.isremove = isremove;
	}
	@Override
	public String toString() {
		return "Users [user_email=" + user_email + ", user_password=" + user_password + ", user_name=" + user_name
				+ ", user_phone=" + user_phone + ", isremove=" + isremove + "]";
	}
	
	
}
