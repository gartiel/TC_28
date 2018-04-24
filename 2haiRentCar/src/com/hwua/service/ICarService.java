package com.hwua.service;

import java.util.List;

import com.hwua.entity.Car;
import com.hwua.entity.User;

public interface ICarService {
	/**
	 * ��ѯ��������
	 * @return
	 */
	public List<Car> queryCar();
	/**
	 * ͨ���������,�û���Ϣ��ѯ����,�ı�����״̬,�����⳵��¼
	 * @param str
	 * @return Car �����⳵�ɹ���¼
	 */
	public Car rentCar(String str,User user);
	/**
	 * ͨ���������,�û���Ϣ��ѯ����,���ӻ���ʱ��,�޸�����״̬,�޸������
	 * @param str
	 * @return Car ���ػ�����¼
	 */
	public Car returnCar(String str,User user);
	/**
	 * ͨ��������Ų�ѯָ������
	 * @param str
	 * @return ����ָ������
	 */
	public Car queryCar(String str);
	/**
	 * ����Աͨ������������������������������
	 * @param car
	 * @return int �������ӽ��
	 */
	public int addCar(Car car);
	/**
	 * ������״̬Ϊ����״̬
	 * ����Աͨ������������Ϣ,����޸��������
	 * @param car
	 * @param rent
	 * @return int �����޸Ľ��
	 */
	public int updateRent(Car car,double rent);
	/**
	 * ������״̬Ϊ����״̬
	 * ����Աͨ������������Ϣ,�޸������ϼ�״̬
	 * @param car
	 * @param status
	 * @return
	 */
	public int updateStatus(Car car,int status);
	/**
	 * ͨ��ָ������������������������
	 * @param str
	 * @return List<Car>
	 */
	public List<Car> rankCar(String str);
	/**
	 * ͨ������������������
	 * @param cateId
	 * @return List<Car>
	 */
	public List<Car> searchCarByCate(String str);
	/**
	 * ͨ������Ʒ����������
	 * @param cateId
	 * @return List<Car>
	 */
	public List<Car> searchCarByBrand(String str);
	/**
	 * �û�ͨ���û���Ϣ��ѯ�������޼�¼
	 * @param user �û���Ϣ
	 * @return List<Car> �������޼�¼
	 */
	public List<Car> showRecord(User user);
	/**
	 * ����Ա��ѯ�������޼�¼
	 * @param str
	 * @return List<Car> �������޼�¼
	 */
	public List<Car> adShowRecord();
	/**
	 * ����Աͨ�������û�id ��ѯ���û��������޼�¼
	 * @param str
	 * @return List<Car> �û����޼�¼
	 */
	public List<Car> adShowRecordByUserId(String str);
	/**
	 * ����Աͨ����������id ��ѯ�������������޼�¼
	 * @param str
	 * @return List<Car> �������޼�¼
	 */
	public List<Car> adShowRecordByCarId(String str);
	/**
	 * ���ݹ���Ա����ѡ��ɾ������
	 * @param str
	 * @return
	 */
	public int deleteCar(String str);
}
