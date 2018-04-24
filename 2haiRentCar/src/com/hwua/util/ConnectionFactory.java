package com.hwua.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionFactory {
	private static String driver;
	private static String url;
	private static String uname;
	private static String upass;
	
	//静态代码块:特性,类加载时就会执行
	static {
		//获取四个属性
		Properties prop = new Properties();
		//加载文件中的数据
		try {
			//load(流对象指向一个文件) 把文件中的数据加载到prop对象中
			//Class对象的getResoureAsStream()传入同包下的资源,返回对应的流对象
			prop.load(ConnectionFactory.class.
					getResourceAsStream("jdbcinfo.properties"));
			//获取四个值
			//String value = prop.getProperty(key)
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			uname = prop.getProperty("uname");
			upass = prop.getProperty("upass");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			// 1.注册数据库驱动
			Class.forName(driver);
			// 2.与数据库建立连接
			conn = DriverManager.getConnection(
					url,uname,upass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(ResultSet rs,PreparedStatement pstmt,Connection conn) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(PreparedStatement pstmt,Connection conn) {
		close(null,pstmt,conn);
	}
	
	public static void close(PreparedStatement pstmt) {
		close(null,pstmt,null);
	}
	
	public static void close(Connection conn) {
		close(null,null,conn);
	}
	public static void close(ResultSet rs) {
		close(rs,null,null);
	}
}
