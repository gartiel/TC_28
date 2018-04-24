package com.hwua.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hwua.dao.IUserDao;
import com.hwua.entity.User;
import com.hwua.util.JDBCTemplate;
import com.hwua.util.ResultSetHandler;

public class UserDaoImpl implements IUserDao{
	public User queryUser(String username, String password) throws SQLException {
		String sql = "SELECT id,username,password,sex,id_number," +
				"tel,addr,type FROM t_user WHERE username=? AND password=?";
		Object[] obj={
				username,password
		};
		return JDBCTemplate.queryOne(sql, obj,new ResultSetHandler<User>() {

			@Override
			public User handleRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				return new User(rs.getLong(1), rs.getString(2), 
						rs.getString(3),rs.getInt(4),rs.getString(5),
						rs.getString(6),rs.getString(7),rs.getInt(8));
			}
		});
	}

	@Override
	public User queryUser(String username) throws SQLException {
		String sql = "SELECT id,username,password,sex,id_number," +
				"tel,addr,type FROM t_user WHERE username=?";
		return JDBCTemplate.queryOne(sql, new Object[] {username}, new ResultSetHandler<User>() {

			@Override
			public User handleRow(ResultSet rs) throws SQLException {
				//把结果集中的一行转换成一个实体类对象并返回
				return new User(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7),rs.getInt(8));
			}
		});
		
	}

	@Override
	public int addUser(User user) throws SQLException {
		String sql = "INSERT INTO t_user (id,username,password,sex,"  
				+"id_number,tel,addr,type) "
				+ "VALUES (t_user_id_seq.nextval,?,?,?,?,?,?,?)";
		Object[] obj = {
				user.getUsername(),user.getPassword(),
				user.getSex(),user.getIdNumber(),
				user.getTel(),user.getAddr(),user.getType()};
		return JDBCTemplate.update(sql, obj);
	} 
	
}
