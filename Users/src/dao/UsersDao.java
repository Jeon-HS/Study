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

}
