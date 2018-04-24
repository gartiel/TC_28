package com.hwua.view;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.hwua.entity.Car;
import com.hwua.entity.User;
import com.hwua.service.ICarService;
import com.hwua.service.impl.CarServiceImpl;
import com.hwua.util.InputUtil;

public class RentCarView {
	MainMenuView m=new MainMenuView();
	public void start(String str,User user) {
		ICarService carService=new CarServiceImpl();
		Car car = carService.rentCar(str, user);
		if(car==null) {
			System.out.println("�⳵ʧ��,������ת...");
			try {
				Thread.sleep(3000);
				m.start(user);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("======================================");
			System.out.println("�⳵�ɹ�,�⳵��Ϣ����:");
			showRentCar(car);
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
	public void showRentCar(Car car) {
		System.out.println("���\t��������\tÿ�����\t��ע\tƷ��\t����\t�賵ʱ��\t");
		System.out.println(car.getId()+"\t"+car.getModel()+"\t"+car.getRent()+
				"\t"+car.gettComments()+"\t"+car.getBrandName()+"\t"+
				car.getCateName()+"\t"+car.getStartDate()+"\t");
	}
}
