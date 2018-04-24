package com.hwua.service.impl;

import java.sql.SQLException;

import com.hwua.dao.IUserDao;
import com.hwua.dao.impl.UserDaoImpl;
import com.hwua.entity.User;
import com.hwua.service.IUserService;

public class UserServiceImpl implements IUserService {
	IUserDao userDao;
	public UserServiceImpl() {
		userDao=new UserDaoImpl();
	}
	@Override
	public int register(User user) {
		try {
			// 1.判断用户名是否存在
			User user2 = userDao.queryUser(user.getUsername());
			if (user2 == null) {// 用户名不存在
				// 2.添加用户
				int rows = userDao.addUser(user);
				if (rows > 0) {// 添加成功
					return 1;// 成功则返回1
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	public User login(String username,String password) {
		User user=null;
		try {
			 user = userDao.queryUser(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}


}
