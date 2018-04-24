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
		//选择,比如各种方式查询,或者下单
		m.showChoose(user);
		}else {
			System.out.println("输入失败,请重新输入");
			m.showChoose(user);
		}
	}
	public void showCars(List<Car> list) {
		System.out.println("编号\t汽车名称\t备注\t品牌\t类型\t价格\t是否可租\t");
		for (Car car : list) {
			String a="";
			if(car.getUserable()==0) {a="是";}
			else{a="否";}
			System.out.println(car.getId()+"\t"+car.getModel()+
					"\t"+car.gettComments()+"\t"+car.getBrandName()+"("+car.getBrandId()+")"+"\t"
					+car.getCateName()+"("+car.getCategoryId()+")"+"\t"+car.getRent()
					+"/天\t"+a+"\t");
			
		}
	}
	
}
