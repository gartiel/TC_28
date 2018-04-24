package com.hwua.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.hwua.dao.ICarDao;
import com.hwua.entity.Car;
import com.hwua.entity.User;
import com.hwua.entity.Car;
import com.hwua.util.ConnectionFactory;
import com.hwua.util.JDBCTemplate;
import com.hwua.util.ResultSetHandler;

public class CarDaoImpl implements ICarDao{
	public int addRecord(Car car,User user,String date) throws SQLException{
		String sql="INSERT INTO t_record(ID,USER_ID,CAR_ID,START_DATE,RETURN_DATE,PAYMENT) " + 
				"VALUES(t_record_id_seq.nextval,?,?,to_date(?,'yyyy-mm-dd hh24:mi:ss'),?,?)";
		Object[] obj= {
				user.getId(),car.getId(),date,car.getReturnDate(),car.getPayment()
		};
		return JDBCTemplate.update(sql, obj);
	}
	public List<Car> queryCars() throws SQLException{
		String sql = "SELECT c.id,c.car_number,c.brand_id,c.model,c.color,c.category_id,c.t_comments," + 
				"c.price,c.rent,c.status,c.useable,b.name brandname,g.name catename " + 
				"FROM t_car c,t_brand b,t_category g " + 
				"WHERE C.brand_id=b.id AND C.category_id=g.id " + 
				"ORDER BY c.id";
		return JDBCTemplate.query(sql, null, new ResultSetHandler<Car>() {

			@Override
			public Car handleRow(ResultSet rs) throws SQLException {
				return new Car(rs.getLong(1),rs.getString(2),rs.getLong(3),
						rs.getString(4),rs.getString(5),rs.getLong(6),
						rs.getString(7),rs.getDouble(8),rs.getDouble(9),
						rs.getInt(10),rs.getInt(11),rs.getString(12),rs.getString(13));
			}
		});

	}
	public List<Car> queryCarsRecord(User user) throws SQLException{
		String sql = "SELECT r.id,c.id,c.model,r.payment,"
				+ "c.t_comments,b.name bname,g.name gname,r.start_date,r.return_date " + 
				"FROM t_car c,t_record r,t_brand b,t_category g " + 
				"WHERE c.id=r.car_id AND c.category_id=g.id "
				+ "AND c.brand_id=b.id AND r.user_id=? " + 
				"ORDER BY r.id";
		return JDBCTemplate.query(sql, new Object[] {user.getId()}, new ResultSetHandler<Car>() {

			@Override
			public Car handleRow(ResultSet rs) throws SQLException {
				return new Car(rs.getLong(1),rs.getLong(2),rs.getString(3),rs.getDouble(4),
						rs.getString(5),rs.getString(6),rs.getString(7),
						rs.getString(8),rs.getString(9));
			}
		});

	}
	public List<Car> queryCarsAllRecord() throws SQLException{
		String sql = "SELECT r.id,c.id,c.model,u.id,u.username,c.rent,r.payment,"
				+ "c.t_comments,b.name bname,g.name gname,r.start_date,r.return_date " + 
				"FROM t_car c,t_record r,t_brand b,t_category g,t_user u " + 
				"WHERE c.id=r.car_id AND c.category_id=g.id AND c.brand_id=b.id "
				+ "AND r.user_id=u.id " + 
				"ORDER BY r.id";
		return JDBCTemplate.query(sql, null, new ResultSetHandler<Car>() {

			@Override
			public Car handleRow(ResultSet rs) throws SQLException {
				return new Car(rs.getLong(1),rs.getLong(2),rs.getString(3),
						rs.getLong(4),rs.getString(5),rs.getDouble(6),rs.getDouble(7),
						rs.getString(8),rs.getString(9),rs.getString(10),
						rs.getString(11),rs.getString(12));
			}
		});

	}
	public List<Car> queryCarsRecordByUserId(long id) throws SQLException{
		String sql = "SELECT r.id,c.id,c.model,u.id,u.username,c.rent,r.payment,"
				+ "c.t_comments,b.name bname,g.name gname,r.start_date,r.return_date " + 
				"FROM t_car c,t_record r,t_brand b,t_category g,t_user u " + 
				"WHERE c.id=r.car_id AND c.category_id=g.id "
				+ "AND c.brand_id=b.id "
				+ "AND r.user_id=u.id AND u.id=? " + 
				"ORDER BY r.id";
		return JDBCTemplate.query(sql, new Object[] {id}, new ResultSetHandler<Car>() {

			@Override
			public Car handleRow(ResultSet rs) throws SQLException {
				return new Car(rs.getLong(1),rs.getLong(2),rs.getString(3),
						rs.getLong(4),rs.getString(5),rs.getDouble(6),rs.getDouble(7),
						rs.getString(8),rs.getString(9),rs.getString(10),
						rs.getString(11),rs.getString(12));
			}
		});

	}
	public List<Car> queryCarsRecordByCarId(long carId) throws SQLException{
		String sql = "SELECT r.id,c.id,c.model,u.id,u.username,c.rent,r.payment,"
				+ "c.t_comments,b.name bname,g.name gname,r.start_date,r.return_date " + 
				"FROM t_car c,t_record r,t_brand b,t_category g,t_user u " + 
				"WHERE c.id=r.car_id AND c.category_id=g.id AND c.brand_id=b.id "
				+ "AND r.user_id=u.id AND c.id=? " + 
				"ORDER BY r.id";
		return JDBCTemplate.query(sql, new Object[] {carId}, new ResultSetHandler<Car>() {

			@Override
			public Car handleRow(ResultSet rs) throws SQLException {
				return new Car(rs.getLong(1),rs.getLong(2),rs.getString(3),
						rs.getLong(4),rs.getString(5),rs.getDouble(6),rs.getDouble(7),
						rs.getString(8),rs.getString(9),rs.getString(10),
						rs.getString(11),rs.getString(12));
			}
		});

	}
	public List<Car> queryCarsByPriceASC() throws SQLException{
		String sql = "SELECT c.id,c.car_number,c.brand_id,c.model,c.color,c.category_id,c.t_comments," + 
				"c.price,c.rent,c.status,c.useable,b.name brandname,g.name catename " + 
				"FROM t_car c,t_brand b,t_category g " + 
				"WHERE C.brand_id=b.id AND C.category_id=g.id AND c.status=0 " + 
				"ORDER BY c.rent ASC";
		return JDBCTemplate.query(sql, null, new ResultSetHandler<Car>() {

			@Override
			public Car handleRow(ResultSet rs) throws SQLException {
				//解析一行,转换成对象并返回
				return new Car(rs.getLong(1),rs.getString(2),rs.getLong(3),
						rs.getString(4),rs.getString(5),rs.getLong(6),
						rs.getString(7),rs.getDouble(8),rs.getDouble(9),
						rs.getInt(10),rs.getInt(11),rs.getString(12),rs.getString(13));
			}
		});

	}
	public List<Car> queryCarsByPriceDESC() throws SQLException{
		String sql = "SELECT c.id,c.car_number,c.brand_id,c.model,c.color,c.category_id,c.t_comments," + 
				"c.price,c.rent,c.status,c.useable,b.name brandname,g.name catename " + 
				"FROM t_car c,t_brand b,t_category g " + 
				"WHERE C.brand_id=b.id AND C.category_id=g.id AND c.status=0 " + 
				"ORDER BY c.rent DESC";
		return JDBCTemplate.query(sql, null, new ResultSetHandler<Car>() {

			@Override
			public Car handleRow(ResultSet rs) throws SQLException {
				//解析一行,转换成对象并返回
				return new Car(rs.getLong(1),rs.getString(2),rs.getLong(3),
						rs.getString(4),rs.getString(5),rs.getLong(6),
						rs.getString(7),rs.getDouble(8),rs.getDouble(9),
						rs.getInt(10),rs.getInt(11),rs.getString(12),rs.getString(13));
			}
		});

	}
	public Car queryCar(long id) throws SQLException {
		String sql = "SELECT c.id,c.car_number,c.brand_id,c.model,c.color,c.category_id,c.t_comments," + 
				"c.price,c.rent,c.status,c.useable,b.name brandname,g.name catename " + 
				"FROM t_car c,t_brand b,t_category g " + 
				"WHERE C.brand_id=b.id AND C.category_id=g.id AND C.ID=? ";
		return JDBCTemplate.queryOne(sql, new Object[] {id}, new ResultSetHandler<Car>() {

			@Override
			public Car handleRow(ResultSet rs) throws SQLException {
				return new Car(rs.getLong(1),rs.getString(2),rs.getLong(3),
						rs.getString(4),rs.getString(5),rs.getLong(6),
						rs.getString(7),rs.getDouble(8),rs.getDouble(9),
						rs.getInt(10),rs.getInt(11),rs.getString(12),rs.getString(13));
			}
		});
		
	}
	public Car queryCarStart(long id,User user) throws SQLException {
		String sql = "SELECT c.id,c.car_number,c.brand_id,c.model,c.color,c.category_id,c.t_comments," + 
				"c.price,c.rent,c.status,c.useable,b.name brandname,g.name catename,r.start_date " + 
				"FROM t_car c,t_brand b,t_category g,t_record r " + 
				"WHERE c.brand_id=b.id AND c.category_id=g.id "
				+ "AND r.car_id=c.id AND r.user_id=? AND c.id=? AND r.payment=0";
		return JDBCTemplate.queryOne(sql, new Object[] {user.getId(),id}, new ResultSetHandler<Car>() {

			@Override
			public Car handleRow(ResultSet rs) throws SQLException {
				return new Car(rs.getLong(1),rs.getString(2),rs.getLong(3),
						rs.getString(4),rs.getString(5),rs.getLong(6),
						rs.getString(7),rs.getDouble(8),rs.getDouble(9),
						rs.getInt(10),rs.getInt(11),rs.getString(12),rs.getString(13),rs.getString(14));
			}
		});
		
	}
	public Car queryCarReturn(long id,User user,long recordId) throws SQLException {
		String sql = "SELECT c.id,c.car_number,c.brand_id,c.model,c.color,c.category_id,c.t_comments," + 
				"c.price,c.rent,c.status,c.useable,b.name brandname,g.name catename,r.start_date,r.return_date,"
				+ "r.payment " + 
				"FROM t_car c,t_brand b,t_category g,t_record r " + 
				"WHERE c.brand_id=b.id AND c.category_id=g.id "
				+ "AND r.car_id=c.id AND r.user_id=? AND c.id=? AND r.id=? ";
		return JDBCTemplate.queryOne(sql, new Object[] {user.getId(),id,recordId}, new ResultSetHandler<Car>() {

			@Override
			public Car handleRow(ResultSet rs) throws SQLException {
				//把结果集中的一行转换成一个实体类对象并返回
				return new Car(rs.getLong(1),rs.getString(2),rs.getLong(3),
						rs.getString(4),rs.getString(5),rs.getLong(6),
						rs.getString(7),rs.getDouble(8),rs.getDouble(9),
						rs.getInt(10),rs.getInt(11),rs.getString(12),rs.getString(13),
						rs.getString(14),rs.getString(15),rs.getDouble(16));
			}
		});
		
	}
	public long queryRecordId(User user,long carId) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		String sql="SELECT r.id FROM t_record r "
				+ "WHERE r.user_id=? AND r.car_id=? AND r.return_date is null";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, user.getId());
		pstmt.setLong(2, carId);
		ResultSet rs = pstmt.executeQuery();
		long recordId=0;
		if(rs.next()) {
			recordId=rs.getLong(1);
		}
		ConnectionFactory.close(rs, pstmt, conn);
		return recordId;
		
	}
	@Override
	public int updateCarOn(Car car) throws SQLException {
		String sql = "UPDATE t_car SET useable=1 WHERE id=?";
		Object[] obj = {
				car.getId()};
		return JDBCTemplate.update(sql, obj);
	}
	public int updateCarReturnDate(long id,String date,Connection conn) throws SQLException {
		String sql = "UPDATE t_record SET return_date=to_date(?,'yyyy-mm-dd hh24:mi:ss') WHERE car_id=?";
		Object[] obj = {
				date,id};
		return JDBCTemplate.update(sql, obj,conn);
	}
	public int updateCarOff(long id,Connection conn) throws SQLException {
		String sql = "UPDATE t_car SET useable=0 WHERE id=?";
		Object[] obj = {
				id};
		return JDBCTemplate.update(sql, obj,conn);
	}
	public int updatePayment(long CarId,User user,Connection conn) throws SQLException {
		String sql = "UPDATE t_record SET payment=(select trunc(return_date-start_date)+1 "
				+ "from t_record where car_id=? AND user_id=? AND payment=0)*(select rent from t_car where id=?) "
				+ "WHERE user_id=? AND car_id=? AND payment=0";
		Object[] obj = { CarId,user.getId(),CarId,user.getId(),CarId};
		return JDBCTemplate.update(sql, obj,conn);
	}

	public List<Car> queryCarsByCate(long cateId) throws SQLException{
		String sql = "SELECT c.id,c.car_number,c.brand_id,c.model,c.color,c.category_id,c.t_comments," + 
				"c.price,c.rent,c.status,c.useable,b.name brandname,g.name catename " + 
				"FROM t_car c,t_brand b,t_category g " + 
				"WHERE C.brand_id=b.id AND C.category_id=g.id " + 
				"AND g.id=? AND c.status=0 ";
		return JDBCTemplate.query(sql,new Object[] {cateId}, new ResultSetHandler<Car>() {

			@Override
			public Car handleRow(ResultSet rs) throws SQLException {
				//解析一行,转换成对象并返回
				return new Car(rs.getLong(1),rs.getString(2),rs.getLong(3),
						rs.getString(4),rs.getString(5),rs.getLong(6),
						rs.getString(7),rs.getDouble(8),rs.getDouble(9),
						rs.getInt(10),rs.getInt(11),rs.getString(12),rs.getString(13));
			}
		});

	}
	public List<Car> queryCarsByBrand(long brandId) throws SQLException{
		String sql = "SELECT c.id,c.car_number,c.brand_id,c.model,c.color,c.category_id,c.t_comments," + 
				"c.price,c.rent,c.status,c.useable,b.name brandname,g.name catename " + 
				"FROM t_car c,t_brand b,t_category g " + 
				"WHERE C.brand_id=b.id AND C.category_id=g.id " + 
				"AND b.id=? AND c.status=0 ";
		return JDBCTemplate.query(sql,new Object[] {brandId}, new ResultSetHandler<Car>() {

			@Override
			public Car handleRow(ResultSet rs) throws SQLException {
				//解析一行,转换成对象并返回
				return new Car(rs.getLong(1),rs.getString(2),rs.getLong(3),
						rs.getString(4),rs.getString(5),rs.getLong(6),
						rs.getString(7),rs.getDouble(8),rs.getDouble(9),
						rs.getInt(10),rs.getInt(11),rs.getString(12),rs.getString(13));
			}
		});

	}
	/**
	 * 	id NUMBER(11),
	car_number VARCHAR2(10),
	brand_id NUMBER(11),
	model VARCHAR2(40),
	color VARCHAR2(20),
	category_id NUMBER(11),
	t_comments VARCHAR2(100),
	price NUMBER(11,2),
	
	rent NUMBER(9,2),
	status NUMBER(1) DEFAULT 0,
	useable NUMBER(1) DEFAULT 0,*/
	public int addCar(Car car) throws SQLException {
		String sql = "INSERT INTO t_car (id,car_number,brand_id,model,"  
				+"color,category_id,t_comments,price,rent,status,useable) "
				+ "VALUES (t_car_id_seq.nextval,?,?,?,?,?,?,?,?,?,?)";
		Object[] obj = {
				car.getCarNumber(),car.getBrandId(),car.getModel(),
				car.getColor(),car.getCategoryId(),car.gettComments(),
				car.getPrice(),car.getRent(),car.getStatus(),car.getUserable()};
		return JDBCTemplate.update(sql, obj);
	}
	//修改租金
	public int updateRent(Car car,double rent) throws SQLException {
		String sql = "UPDATE t_car SET rent=? WHERE id=?";
		Object[] obj = {
				rent,car.getId()};
		return JDBCTemplate.update(sql, obj);
	}
	public int updateStatus(Car car,int status) throws SQLException {
		String sql = "UPDATE t_car SET status=? WHERE id=?";
		Object[] obj = {
				status,car.getId()};
		return JDBCTemplate.update(sql, obj);
	}
	public int deleteCar(long carId) throws SQLException{
		String sql="DELETE FROM t_car WHERE id=?";
		Object[] obj = {
				carId};
		return JDBCTemplate.update(sql, obj);
	}
}
