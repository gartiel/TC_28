package com.hwua.view;

import java.util.List;

import com.hwua.entity.Car;
import com.hwua.entity.User;
import com.hwua.service.ICarService;
import com.hwua.service.impl.CarServiceImpl;

public class RecordView {
	public void start(User user) {
		ICarService carService=new CarServiceImpl();
		List<Car> record = carService.showRecord(user);
		if(record!=null&&record.size()>0) {
			showCar(record);
		}else {
			System.out.println("未找到租车记录");
			new MainMenuView().showChoose(user);
		}
		
		
	}
	public void showCar(List<Car> list) {
		System.out.println("编号\t汽车编号\t汽车名称\t租金总额\t备注\t品牌\t类型\t借车时间\t\t\t还车时间\t");
		for (Car car : list) {
			System.out.println(car.getRecordId()+"\t"+car.getId()+"\t"+car.getModel()+"\t"+
			car.getPayment()+"\t"+car.gettComments()+"\t"+car.getBrandName()+"\t"+
					car.getCateName()+"\t"+car.getStartDate()+"\t"+car.getReturnDate()+"\t");
		}
	}
}
