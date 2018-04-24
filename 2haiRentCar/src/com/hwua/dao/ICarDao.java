package com.hwua.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.hwua.entity.Car;
import com.hwua.entity.User;

public interface ICarDao {
	/**
	 * 通过汽车信息,用户信息,生成时间 增加汽车租赁记录
	 * @param car
	 * @param user
	 * @param date
	 * @return
	 * @throws SQLException
	 */
	public int addRecord(Car car,User user,String date) throws SQLException;
	/**
	 * 查询所有汽车信息
	 * @return List<Car> 汽车集合
	 * @throws SQLException
	 */
	public List<Car> queryCars() throws SQLException;
	/**
	 * 通过用户信息查询汽车租赁记录信息
	 * @return List<Car> 用户汽车租赁记录集合
	 * @throws SQLException
	 */
	public List<Car> queryCarsRecord(User user) throws SQLException;
	/**
	 * 管理员查询所有汽车租赁记录
	 * @return
	 * @throws SQLException
	 */
	public List<Car> queryCarsAllRecord() throws SQLException;
	/**
	 * 管理员通过输入用户id 查询该用户所有汽车租赁记录
	 * @param id 用户id
	 * @return List<Car> 用户租赁记录
	 * @throws SQLException
	 */
	public List<Car> queryCarsRecordByUserId(long id) throws SQLException;
	/**
	 * 管理员通过输入汽车id 查询该用户所有汽车租赁记录
	 * @param carId 汽车id
	 * @return List<Car> 汽车租赁记录
	 * @throws SQLException
	 */
	public List<Car> queryCarsRecordByCarId(long carId) throws SQLException;
	/**
	 * 根据价格升序查询所有汽车
	 * @return
	 * @throws SQLException
	 */
	public List<Car> queryCarsByPriceASC() throws SQLException;
	/**
	 * 根据价格降序查询所有汽车
	 * @return
	 * @throws SQLException
	 */
	public List<Car> queryCarsByPriceDESC() throws SQLException;
	/**
	 * 通过汽车id 查询汽车
	 * @param id
	 * @return Car 对象
	 * @throws SQLException
	 */
	public Car queryCar(long id) throws SQLException;
	/**
	 * 通过汽车id 用于id 返回租车成功记录
	 * @param id 汽车id
	 * @param user 用户对象
	 * @return Car 租车成功对象
	 * @throws SQLException
	 */
	public Car queryCarStart(long id,User user) throws SQLException;
	/**
	 * 通过租车记录id 返回还车成功记录
	 * @param id
	 * @param user
	 * @param recordId
	 * @return Car 还车成功对象
	 * @throws SQLException
	 */
	public Car queryCarReturn(long id,User user,long recordId) throws SQLException;
	/**
	 * 通过用户信息,汽车id 找到租车记录id
	 * @param user
	 * @param carId
	 * @return queryRecordId 租车记录id
	 * @throws SQLException
	 */
	public long queryRecordId(User user,long carId) throws SQLException;
	/**
	 * 通过汽车id 更改汽车租赁状态 租车
	 * @param car 汽车对象
	 * @return int 返回结果
	 * @throws SQLException
	 */
	public int updateCarOn(Car car) throws SQLException;
	/**
	 * 通过汽车id 更改汽车租赁状态 还车
	 * @param id
	 * @return int 返回结果
	 * @throws SQLException
	 */
	public int updateCarOff(long id,Connection conn) throws SQLException;
	/**
	 * 通过汽车id 修改还车时间
	 * @param id
	 * @param date
	 * @return int 返回结果
	 * @throws SQLException
	 */
	public int updateCarReturnDate(long id,String date,Connection conn) throws SQLException;
	/**
	 * 通过汽车id,用户信息,查询到借车时间,汽车租金,修改总租金
	 * @param CarId
	 * @param user
	 * @return int 返回结果
	 * @throws SQLException
	 */
	public int updatePayment(long CarId,User user,Connection conn) throws SQLException;
	/**
	 * 通过汽车类型搜索汽车
	 * @param cateId
	 * @return List<Car> 汽车集合
	 * @throws SQLException
	 */
	public List<Car> queryCarsByCate(long cateId) throws SQLException;
	/**
	 * 通过汽车品牌搜索汽车
	 * @param brandId
	 * @return List<Car> 汽车集合
	 * @throws SQLException
	 */
	public List<Car> queryCarsByBrand(long brandId) throws SQLException;
	/**
	 * 管理员增加汽车
	 * @param car
	 * @return int 返回结果
	 * @throws SQLException
	 */
	public int addCar(Car car) throws SQLException;
	/**
	 * 管理员修改汽车租金价格
	 * @param car
	 * @param rent
	 * @return int 返回结果
	 * @throws SQLException
	 */
	public int updateRent(Car car,double rent) throws SQLException;
	/**
	 * 管理员修改汽车上下架状态
	 * @param car
	 * @param status
	 * @return int 返回结果
	 * @throws SQLException
	 */
	public int updateStatus(Car car,int status) throws SQLException;
	/**
	 * 管理员通过汽车id 删除汽车
	 * @param carId
	 * @return
	 * @throws SQLException
	 */
	public int deleteCar(long carId) throws SQLException;
}
