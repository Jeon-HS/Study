package service;

import dao.UsersDao;

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
}
