package com.hwua.dao;

import java.sql.SQLException;

import com.hwua.entity.User;

public interface IUserDao {
	/**
	 * 通过用户名及密码查询用户实现登录
	 * @param username
	 * @param password
	 * @return 用户
	 * @throws SQLException
	 */
	public User queryUser(String username, String password) throws SQLException;
	/**
	 * 通过用户名查询判断用户是否已存在
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public User queryUser(String username) throws SQLException;
	/**
	 * 增加用户
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public int addUser(User user) throws SQLException;
}
