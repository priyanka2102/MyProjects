package com.ts.us.services;

import com.ts.us.dao.MyUser;
import com.ts.us.dao.MyUserDAO;

public class UserService {
	public static int getUserForm(MyUser user1) {
	
			
			int no = MyUserDAO.insertRecord(user1);
			return no;
			
			
		}

}
