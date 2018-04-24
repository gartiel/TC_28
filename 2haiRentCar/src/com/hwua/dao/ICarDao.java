package com.hwua.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.hwua.entity.Car;
import com.hwua.entity.User;

public interface ICarDao {
	/**
	 * ͨ��������Ϣ,�û���Ϣ,����ʱ�� �����������޼�¼
	 * @param car
	 * @param user
	 * @param date
	 * @return
	 * @throws SQLException
	 */
	public int addRecord(Car car,User user,String date) throws SQLException;
	/**
	 * ��ѯ����������Ϣ
	 * @return List<Car> ��������
	 * @throws SQLException
	 */
	public List<Car> queryCars() throws SQLException;
	/**
	 * ͨ���û���Ϣ��ѯ�������޼�¼��Ϣ
	 * @return List<Car> �û��������޼�¼����
	 * @throws SQLException
	 */
	public List<Car> queryCarsRecord(User user) throws SQLException;
	/**
	 * ����Ա��ѯ�����������޼�¼
	 * @return
	 * @throws SQLException
	 */
	public List<Car> queryCarsAllRecord() throws SQLException;
	/**
	 * ����Աͨ�������û�id ��ѯ���û������������޼�¼
	 * @param id �û�id
	 * @return List<Car> �û����޼�¼
	 * @throws SQLException
	 */
	public List<Car> queryCarsRecordByUserId(long id) throws SQLException;
	/**
	 * ����Աͨ����������id ��ѯ���û������������޼�¼
	 * @param carId ����id
	 * @return List<Car> �������޼�¼
	 * @throws SQLException
	 */
	public List<Car> queryCarsRecordByCarId(long carId) throws SQLException;
	/**
	 * ���ݼ۸������ѯ��������
	 * @return
	 * @throws SQLException
	 */
	public List<Car> queryCarsByPriceASC() throws SQLException;
	/**
	 * ���ݼ۸����ѯ��������
	 * @return
	 * @throws SQLException
	 */
	public List<Car> queryCarsByPriceDESC() throws SQLException;
	/**
	 * ͨ������id ��ѯ����
	 * @param id
	 * @return Car ����
	 * @throws SQLException
	 */
	public Car queryCar(long id) throws SQLException;
	/**
	 * ͨ������id ����id �����⳵�ɹ���¼
	 * @param id ����id
	 * @param user �û�����
	 * @return Car �⳵�ɹ�����
	 * @throws SQLException
	 */
	public Car queryCarStart(long id,User user) throws SQLException;
	/**
	 * ͨ���⳵��¼id ���ػ����ɹ���¼
	 * @param id
	 * @param user
	 * @param recordId
	 * @return Car �����ɹ�����
	 * @throws SQLException
	 */
	public Car queryCarReturn(long id,User user,long recordId) throws SQLException;
	/**
	 * ͨ���û���Ϣ,����id �ҵ��⳵��¼id
	 * @param user
	 * @param carId
	 * @return queryRecordId �⳵��¼id
	 * @throws SQLException
	 */
	public long queryRecordId(User user,long carId) throws SQLException;
	/**
	 * ͨ������id ������������״̬ �⳵
	 * @param car ��������
	 * @return int ���ؽ��
	 * @throws SQLException
	 */
	public int updateCarOn(Car car) throws SQLException;
	/**
	 * ͨ������id ������������״̬ ����
	 * @param id
	 * @return int ���ؽ��
	 * @throws SQLException
	 */
	public int updateCarOff(long id,Connection conn) throws SQLException;
	/**
	 * ͨ������id �޸Ļ���ʱ��
	 * @param id
	 * @param date
	 * @return int ���ؽ��
	 * @throws SQLException
	 */
	public int updateCarReturnDate(long id,String date,Connection conn) throws SQLException;
	/**
	 * ͨ������id,�û���Ϣ,��ѯ���賵ʱ��,�������,�޸������
	 * @param CarId
	 * @param user
	 * @return int ���ؽ��
	 * @throws SQLException
	 */
	public int updatePayment(long CarId,User user,Connection conn) throws SQLException;
	/**
	 * ͨ������������������
	 * @param cateId
	 * @return List<Car> ��������
	 * @throws SQLException
	 */
	public List<Car> queryCarsByCate(long cateId) throws SQLException;
	/**
	 * ͨ������Ʒ����������
	 * @param brandId
	 * @return List<Car> ��������
	 * @throws SQLException
	 */
	public List<Car> queryCarsByBrand(long brandId) throws SQLException;
	/**
	 * ����Ա��������
	 * @param car
	 * @return int ���ؽ��
	 * @throws SQLException
	 */
	public int addCar(Car car) throws SQLException;
	/**
	 * ����Ա�޸��������۸�
	 * @param car
	 * @param rent
	 * @return int ���ؽ��
	 * @throws SQLException
	 */
	public int updateRent(Car car,double rent) throws SQLException;
	/**
	 * ����Ա�޸��������¼�״̬
	 * @param car
	 * @param status
	 * @return int ���ؽ��
	 * @throws SQLException
	 */
	public int updateStatus(Car car,int status) throws SQLException;
	/**
	 * ����Աͨ������id ɾ������
	 * @param carId
	 * @return
	 * @throws SQLException
	 */
	public int deleteCar(long carId) throws SQLException;
}
