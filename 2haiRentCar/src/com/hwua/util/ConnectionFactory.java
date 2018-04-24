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
	
	//��̬�����:����,�����ʱ�ͻ�ִ��
	static {
		//��ȡ�ĸ�����
		Properties prop = new Properties();
		//�����ļ��е�����
		try {
			//load(������ָ��һ���ļ�) ���ļ��е����ݼ��ص�prop������
			//Class�����getResoureAsStream()����ͬ���µ���Դ,���ض�Ӧ��������
			prop.load(ConnectionFactory.class.
					getResourceAsStream("jdbcinfo.properties"));
			//��ȡ�ĸ�ֵ
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
			// 1.ע�����ݿ�����
			Class.forName(driver);
			// 2.�����ݿ⽨������
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
