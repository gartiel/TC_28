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
			System.out.println("搜索结果如下:");
			showCars(cars);
			m.showChoose(user);
			
		}else {
			System.out.println("未搜索到该类型车辆,跳转中...");
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
			System.out.println("搜索结果如下:");
			showCars(cars);
			m.showChoose(user);
			
		}else {
			System.out.println("未搜索到该品牌车辆,跳转中...");
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
