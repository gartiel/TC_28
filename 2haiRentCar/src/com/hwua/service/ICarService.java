package com.hwua.service;

import java.util.List;

import com.hwua.entity.Car;
import com.hwua.entity.User;

public interface ICarService {
	/**
	 * 查询所有汽车
	 * @return
	 */
	public List<Car> queryCar();
	/**
	 * 通过汽车编号,用户信息查询汽车,改变租赁状态,增加租车记录
	 * @param str
	 * @return Car 返回租车成功记录
	 */
	public Car rentCar(String str,User user);
	/**
	 * 通过汽车编号,用户信息查询汽车,增加还车时间,修改租赁状态,修改总租金
	 * @param str
	 * @return Car 返回还车记录
	 */
	public Car returnCar(String str,User user);
	/**
	 * 通过汽车编号查询指定汽车
	 * @param str
	 * @return 返回指定汽车
	 */
	public Car queryCar(String str);
	/**
	 * 管理员通过传入汽车对象向汽车表增加汽车
	 * @param car
	 * @return int 返回增加结果
	 */
	public int addCar(Car car);
	/**
	 * 当汽车状态为可租状态
	 * 管理员通过传入汽车信息,租金修改汽车租金
	 * @param car
	 * @param rent
	 * @return int 返回修改结果
	 */
	public int updateRent(Car car,double rent);
	/**
	 * 当汽车状态为可租状态
	 * 管理员通过传入汽车信息,修改汽车上架状态
	 * @param car
	 * @param status
	 * @return
	 */
	public int updateStatus(Car car,int status);
	/**
	 * 通过指定条件对所有汽车进行排序
	 * @param str
	 * @return List<Car>
	 */
	public List<Car> rankCar(String str);
	/**
	 * 通过汽车类型搜索汽车
	 * @param cateId
	 * @return List<Car>
	 */
	public List<Car> searchCarByCate(String str);
	/**
	 * 通过汽车品牌搜索汽车
	 * @param cateId
	 * @return List<Car>
	 */
	public List<Car> searchCarByBrand(String str);
	/**
	 * 用户通过用户信息查询所有租赁记录
	 * @param user 用户信息
	 * @return List<Car> 汽车租赁记录
	 */
	public List<Car> showRecord(User user);
	/**
	 * 管理员查询所有租赁记录
	 * @param str
	 * @return List<Car> 汽车租赁记录
	 */
	public List<Car> adShowRecord();
	/**
	 * 管理员通过输入用户id 查询该用户所有租赁记录
	 * @param str
	 * @return List<Car> 用户租赁记录
	 */
	public List<Car> adShowRecordByUserId(String str);
	/**
	 * 管理员通过输入汽车id 查询该汽车所有租赁记录
	 * @param str
	 * @return List<Car> 汽车租赁记录
	 */
	public List<Car> adShowRecordByCarId(String str);
	/**
	 * 根据管理员输入选项删除汽车
	 * @param str
	 * @return
	 */
	public int deleteCar(String str);
}
