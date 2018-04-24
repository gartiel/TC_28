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
			System.out.println("还车失败,正在跳转...");
			try {
				Thread.sleep(3000);
				m.start(user);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("======================================");
			System.out.println("还车成功,租车信息如下:");
			showReturnCar(car);
			try {
				System.out.println("跳转中...");
				Thread.sleep(3000);
				m.start(user);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	public void showReturnCar(Car car) {
		System.out.println("编号\t汽车名称\t每日租金\t总租金\t备注\t品牌\t类型\t借车时间\t\t\t还车时间\t");
		System.out.println(car.getId() + "\t" + car.getModel() + "\t" + car.getRent() + "\t" + car.getPayment() + "\t"
				+ car.gettComments() + "\t" + car.getBrandName() + "\t" + car.getCateName() + "\t" + car.getStartDate()
				+ "\t" + car.getReturnDate() + "\t");
	}

}
