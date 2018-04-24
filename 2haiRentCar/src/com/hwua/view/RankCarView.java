package com.hwua.view;

import java.sql.SQLException;
import java.util.List;

import com.hwua.dao.ICarDao;
import com.hwua.dao.impl.CarDaoImpl;
import com.hwua.entity.Car;
import com.hwua.entity.User;
import com.hwua.service.ICarService;
import com.hwua.service.impl.CarServiceImpl;
import com.hwua.util.InputUtil;

public class RankCarView {
	MainMenuView m=new MainMenuView();
	public void start(String str1,User user) {
		ICarService carService=new CarServiceImpl();
		List<Car> list=carService.rankCar(str1);
		if(list!=null&&list.size()>0) {
		showCars(list);
		//ѡ��,������ַ�ʽ��ѯ,�����µ�
		m.showChoose(user);
		}else {
			System.out.println("����ʧ��,����������");
			m.showChoose(user);
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
