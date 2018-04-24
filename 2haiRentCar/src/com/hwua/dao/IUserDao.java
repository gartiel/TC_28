package com.hwua.dao;

import java.sql.SQLException;

import com.hwua.entity.User;

public interface IUserDao {
	/**
	 * ͨ���û����������ѯ�û�ʵ�ֵ�¼
	 * @param username
	 * @param password
	 * @return �û�
	 * @throws SQLException
	 */
	public User queryUser(String username, String password) throws SQLException;
	/**
	 * ͨ���û�����ѯ�ж��û��Ƿ��Ѵ���
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public User queryUser(String username) throws SQLException;
	/**
	 * �����û�
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public int addUser(User user) throws SQLException;
}
