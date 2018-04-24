package com.hwua.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.hwua.dao.ICarDao;
import com.hwua.dao.impl.CarDaoImpl;
import com.hwua.entity.Car;
import com.hwua.entity.User;
import com.hwua.service.ICarService;
import com.hwua.util.ConnectionFactory;

public class CarServiceImpl implements ICarService {
	ICarDao carDao ;
	SimpleDateFormat sdf ;
	public CarServiceImpl() {
		carDao=new CarDaoImpl();
		sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}
	public List<Car> queryCar() {
		List<Car> list = null;
		try {
			list = carDao.queryCars();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	//1.ͨ������id�ҵ�����,�������������״̬
	//2.�ı���������״̬0-->1
	//3.�������޼�¼
	public Car rentCar(String str, User user) {
		Car car2 = null;
		long id = Long.valueOf(str);
		try {
			Car car1 = carDao.queryCar(id);
			if (car1 != null && car1.getUserable() == 0) {
				String date1 = sdf.format(new Date());
				 int a=carDao.updateCarOn(car1);
				 int b=carDao.addRecord(car1, user, date1);
				car2 = carDao.queryCarStart(id, user);

			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return car2;
	}
	// 1.�޸���������״̬
	// 2.���»���ʱ��
	// 3.���������
	public Car returnCar(String str, User user) {
		Car car2 = null;
		long id = Long.valueOf(str);
		Connection conn = ConnectionFactory.getConnection();
		try {
			// ͨ���û���Ϣ,������ŷ����⳵��¼id
			long recordId = carDao.queryRecordId(user, id);
			if (recordId > 0) {
					conn.setAutoCommit(false);
					carDao.updateCarOff(id, conn);
					String date2 = sdf.format(new Date());
					carDao.updateCarReturnDate(id, date2, conn);
					carDao.updatePayment(id, user, conn);
					conn.commit();
					car2 = carDao.queryCarReturn(id, user, recordId);
			} else {
				return null;
			}
		} catch (SQLException e) {	
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return null;
		
		}finally {
			ConnectionFactory.close(conn);
		}
		return car2;
	}

	// ͨ����Ų�ѯָ������
	public Car queryCar(String str) {
		Car car = null;
		long id = Long.valueOf(str);
		try {
			car = carDao.queryCar(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return car;
	}

	// ��������
	public int addCar(Car car) {
		try {
			int rows = carDao.addCar(car);
			if (rows > 0) {
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	// �޸����޼۸�
	public int updateRent(Car car, double rent) {
		// ��ȡ��������״̬
		int useable = car.getUserable();
		// ��Ϊ����,������޸����޼۸�
		if (useable == 0) {
			try {
				int rows = carDao.updateRent(car, rent);
				return 1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return -1;
	}

	public int updateStatus(Car car, int status) {
		// ��ȡ�����ϼ�״̬
		int status1 = car.getStatus();
		// ��ȡ��������״̬
		int useable = car.getUserable();
		// ֻ�е�����Ϊ����״̬,���޸����¼�
		if (status1 != status) {
			if (useable == 0) {
				try {
					int rows = carDao.updateStatus(car, status);
					return 1;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return -1;
	}

	public List<Car> rankCar(String str) {
		List<Car> cars = null;
		switch (str) {
		case "1":
			try {
				cars = carDao.queryCarsByPriceDESC();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case "2":
			try {
				cars = carDao.queryCarsByPriceASC();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
		return cars;
	}

	public List<Car> searchCarByCate(String str) {
		long cateId = Long.valueOf(str);
		List<Car> cars = null;
		try {
			cars = carDao.queryCarsByCate(cateId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cars;
	}

	public List<Car> searchCarByBrand(String str) {
		long brandId = Long.valueOf(str);
		List<Car> cars = null;
		try {
			cars = carDao.queryCarsByBrand(brandId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cars;
	}

	public List<Car> showRecord(User user) {
		List<Car> cars = null;
		try {
			cars = carDao.queryCarsRecord(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cars;

	}

	public List<Car> adShowRecord() {
		List<Car> cars = null;
		try {
			cars = carDao.queryCarsAllRecord();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cars;

	}

	public List<Car> adShowRecordByUserId(String str) {
		List<Car> cars = null;
		long userId = Long.valueOf(str);
		try {
			cars = carDao.queryCarsRecordByUserId(userId);
			if (cars != null && cars.size() > 0) {
				return cars;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cars;

	}

	public List<Car> adShowRecordByCarId(String str) {
		List<Car> cars = null;
		long carId = Long.valueOf(str);
		try {
			cars = carDao.queryCarsRecordByCarId(carId);
			if (cars != null && cars.size() > 0) {
				return cars;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cars;

	}
	public int deleteCar(String str) {
		long carId=Long.valueOf(str);
		try {
			int rows = carDao.deleteCar(carId);
			if (rows > 0) {
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
}
