package com.hwua.view;

import com.hwua.entity.Car;
import com.hwua.entity.User;
import com.hwua.service.ICarService;
import com.hwua.service.impl.CarServiceImpl;

public class ReturnCarView {
	MainMenuView m = new MainMenuView();
	public void start(String str, User user) {
		ICarService carService = new CarServiceImpl();
		Car car = carService.returnCar(str, user);
		if (car == null) {
			System.out.println("����ʧ��,������ת...");
			try {
				Thread.sleep(3000);
				m.start(user);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("======================================");
			System.out.println("�����ɹ�,�⳵��Ϣ����:");
			showReturnCar(car);
			try {
				System.out.println("��ת��...");
				Thread.sleep(3000);
				m.start(user);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	public void showReturnCar(Car car) {
		System.out.println("���\t��������\tÿ�����\t�����\t��ע\tƷ��\t����\t�賵ʱ��\t\t\t����ʱ��\t");
		System.out.println(car.getId() + "\t" + car.getModel() + "\t" + car.getRent() + "\t" + car.getPayment() + "\t"
				+ car.gettComments() + "\t" + car.getBrandName() + "\t" + car.getCateName() + "\t" + car.getStartDate()
				+ "\t" + car.getReturnDate() + "\t");
	}

}
