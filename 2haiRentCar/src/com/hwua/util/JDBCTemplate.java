package com.hwua.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCTemplate {
	//��ɾ��
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
	 * ��ɾ���漰����ķ�װ
	 * 
	 * @param sql:Ҫִ�е�sql���
	 * @param params
	 *            sql��Ӧ�Ĳ���ֵ ������ʺ�һһ��Ӧ
	 * @param conn:���Ӷ���
	 * @return
	 * @throws SQLException
	 */
	public static int update(String sql, Object[] params,Connection conn) throws SQLException {
		// 3.��������ִ��sql����PreparedStatement����
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// 4.ִ��sql���
		// ������ռλ����ֵ
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
		}
		int rows = pstmt.executeUpdate();
		// 6.�ͷ���Դ
		ConnectionFactory.close(pstmt);
		return rows;
	}

	// T:�ж�Ӧ��Ԫ������
	/**
	 * 
	 * 
	 * ͨ�õĶ��в�ѯ
	 * 
	 * @param sql:��ѯ���
	 * @param params:ռλ����Ӧ��ֵ
	 * @param handler:�����һ�еĴ���Ķ���
	 * @return �����Ķ���ļ���
	 * @throws SQLException
	 */
	public static <T> List<T> query(String sql, Object[] params, ResultSetHandler<T> handler) throws SQLException {
		// 1.ע�����ݿ����� 2.�����ݿ⽨������
		Connection conn = ConnectionFactory.getConnection();
		// 3.��������ִ��sql����PreparedStatement����
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// 4.ִ��sql���
		// ������ռλ����ֵ
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
		}
		ResultSet rs = pstmt.executeQuery();
		// 5.��������
		List<T> list = new ArrayList<>();
		if (handler != null) {
			while (rs.next()) {
				// ÿ�δ���һ��
				// �ص�����Ķ���ķ���
				T obj = handler.handleRow(rs);
				// ��ӵ�������
				list.add(obj);
			}
		}
		// 6.�ͷ���Դ
		ConnectionFactory.close(rs, pstmt, conn);
		return list;
	}

	// T:�ж�Ӧ��Ԫ������
	/**
	 * ͨ�õĵ��в�ѯ
	 * 
	 * @param sql:��ѯ���
	 * @param params:ռλ����Ӧ��ֵ
	 * @param handler:�����һ�еĴ���Ķ���
	 * @return �����Ķ���ļ���
	 * @throws SQLException
	 */
	public static <T> T queryOne(String sql, Object[] params, ResultSetHandler<T> handler) throws SQLException {
		// 1.ע�����ݿ����� 2.�����ݿ⽨������
		Connection conn = ConnectionFactory.getConnection();
		// 3.��������ִ��sql����PreparedStatement����
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// 4.ִ��sql���
		// ������ռλ����ֵ
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
		}
		ResultSet rs = pstmt.executeQuery();
		T obj = null;
		// 5.��������
		if (handler != null) {
			if (rs.next()) {
				// ÿ�δ���һ��
				// �ص�����Ķ���ķ���
				obj = handler.handleRow(rs);
			}
		}
		// 6.�ͷ���Դ
		ConnectionFactory.close(rs, pstmt, conn);
		return obj;
	}

	public static void main(String[] args) throws SQLException {
		String sql="UPDATE t_user SET password=? WHERE id=?";
		int rows=JDBCTemplate.update(sql, new Object[] {"333",1});
		System.out.println(rows);
	}
}
