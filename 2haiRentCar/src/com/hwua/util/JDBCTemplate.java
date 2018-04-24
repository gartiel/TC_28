package com.hwua.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCTemplate {
	//增删改
	public static int update(String sql,Object[] params) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		if(params!=null&&params.length>0) {
			for(int i=0;i<params.length;i++) {
			pstmt.setObject(i+1,params[i]);
			}
		}
		int rows = pstmt.executeUpdate();
		ConnectionFactory.close(pstmt, conn);
		return rows;
	}
	/**
	 * 增删改涉及事务的封装
	 * 
	 * @param sql:要执行的sql语句
	 * @param params
	 *            sql对应的参数值 必须和问号一一对应
	 * @param conn:连接对象
	 * @return
	 * @throws SQLException
	 */
	public static int update(String sql, Object[] params,Connection conn) throws SQLException {
		// 3.创建用来执行sql语句的PreparedStatement对象
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// 4.执行sql语句
		// 先设置占位符的值
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
		}
		int rows = pstmt.executeUpdate();
		// 6.释放资源
		ConnectionFactory.close(pstmt);
		return rows;
	}

	// T:行对应的元素类型
	/**
	 * 
	 * 
	 * 通用的多行查询
	 * 
	 * @param sql:查询语句
	 * @param params:占位符对应的值
	 * @param handler:结果集一行的处理的对象
	 * @return 处理后的对象的集合
	 * @throws SQLException
	 */
	public static <T> List<T> query(String sql, Object[] params, ResultSetHandler<T> handler) throws SQLException {
		// 1.注册数据库驱动 2.与数据库建立连接
		Connection conn = ConnectionFactory.getConnection();
		// 3.创建用来执行sql语句的PreparedStatement对象
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// 4.执行sql语句
		// 先设置占位符的值
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
		}
		ResultSet rs = pstmt.executeQuery();
		// 5.处理结果集
		List<T> list = new ArrayList<>();
		if (handler != null) {
			while (rs.next()) {
				// 每次处理一行
				// 回调传入的对象的方法
				T obj = handler.handleRow(rs);
				// 添加到集合中
				list.add(obj);
			}
		}
		// 6.释放资源
		ConnectionFactory.close(rs, pstmt, conn);
		return list;
	}

	// T:行对应的元素类型
	/**
	 * 通用的单行查询
	 * 
	 * @param sql:查询语句
	 * @param params:占位符对应的值
	 * @param handler:结果集一行的处理的对象
	 * @return 处理后的对象的集合
	 * @throws SQLException
	 */
	public static <T> T queryOne(String sql, Object[] params, ResultSetHandler<T> handler) throws SQLException {
		// 1.注册数据库驱动 2.与数据库建立连接
		Connection conn = ConnectionFactory.getConnection();
		// 3.创建用来执行sql语句的PreparedStatement对象
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// 4.执行sql语句
		// 先设置占位符的值
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
		}
		ResultSet rs = pstmt.executeQuery();
		T obj = null;
		// 5.处理结果集
		if (handler != null) {
			if (rs.next()) {
				// 每次处理一行
				// 回调传入的对象的方法
				obj = handler.handleRow(rs);
			}
		}
		// 6.释放资源
		ConnectionFactory.close(rs, pstmt, conn);
		return obj;
	}

	public static void main(String[] args) throws SQLException {
		String sql="UPDATE t_user SET password=? WHERE id=?";
		int rows=JDBCTemplate.update(sql, new Object[] {"333",1});
		System.out.println(rows);
	}
}
