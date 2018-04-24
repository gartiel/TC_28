package com.hwua.view;

import java.util.List;

import com.hwua.entity.Car;
import com.hwua.entity.User;
import com.hwua.service.ICarService;
import com.hwua.service.impl.CarServiceImpl;

public class SearchCarView {
	MainMenuView m=new MainMenuView();
	public void searchByCate(String str,User user) {
		ICarService carService=new CarServiceImpl();
		List<Car> cars = carService.searchCarByCate(str);
		if(cars!=null&&cars.size()>0) {
			System.out.println("======================================");
			System.out.println("�����������:");
			showCars(cars);
			m.showChoose(user);
			
		}else {
			System.out.println("δ�����������ͳ���,��ת��...");
			try {
				Thread.sleep(3000);
				m.start(user);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public void searchByBrand(String str,User user) {
		ICarService carService=new CarServiceImpl();
		List<Car> cars = carService.searchCarByBrand(str);
		if(cars!=null&&cars.size()>0) {
			System.out.println("======================================");
			System.out.println("�����������:");
			showCars(cars);
			m.showChoose(user);
			
		}else {
			System.out.println("δ��������Ʒ�Ƴ���,��ת��...");
			try {
				Thread.sleep(3000);
				m.start(user);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public void showCars(List<Car> list) {
		System.out.println("���\t��������\t��ע\tƷ��\t����\t�۸�\t�Ƿ����\t");
		for (Car car : list) {
			String a="";
			if(car.getUserable()==0) {a="��";}
			else{a="��";}
			System.out.println(car.getId()+"\t"+car.getModel()+
					"\t"+car.gettComments()+"\t"+car.getBrandName()+"("+car.getBrandId()+")"+"\t"
					+car.getCateName()+"("+car.getCategoryId()+")"+"\t"+car.getRent()
					+"/��\t"+a+"\t");
			
		}
	}

}
