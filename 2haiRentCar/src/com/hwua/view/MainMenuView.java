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



public class MainMenuView {
	ICarService carService;
	public MainMenuView() {
		carService=new CarServiceImpl();
	}
	public void start(User user) {
		
		ICarService carService=new CarServiceImpl();
		List<Car> list = carService.queryCar();
		showCars(list);
		showChoose(user);
		
		}
	public void adStart() {
			
			ICarService carService=new CarServiceImpl();
			List<Car> list = carService.queryCar();
			adShowCars(list);
			adShowChoose();
			
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
	public void adShowCars(List<Car> list) {
		System.out.println("编号\t汽车名称\t备注\t品牌\t类型\t价格\t是否可租\t是否上架\t");
		for (Car car : list) {
			String a="";
			if(car.getUserable()==0) {a="可租";}
			else{a="不可租";}
			String b="";
			if(car.getStatus()==0) {b="上架";}
			else{b="下架";}
			System.out.println(car.getId()+"\t"+car.getModel()+
					"\t"+car.gettComments()+"\t"+car.getBrandName()+"("+car.getBrandId()+")"+"\t"
					+car.getCateName()+"("+car.getCategoryId()+")"+"\t"+car.getRent()
					+"/天\t"+a+"\t"+b+"\t");
			
		}
	}
	public void adShowRecord(List<Car> list) {
		System.out.println("编号\t汽车编号\t汽车名称\t用户编号\t用户名\t每日租金\t租金总额\t备注\t品牌\t类型\t借车时间\t\t\t还车时间\t");
		for (Car car : list) {
			
			System.out.println(car.getRecordId()+"\t"+car.getId()+"\t"+car.getModel()+"\t"
					+car.getUserId()+"\t"+car.getUserName()+"\t"+
					car.getRent()+"/天\t"+car.getPayment()+"\t"+car.gettComments()+"\t"+car.getBrandName()+"\t"
					+car.getCateName()+"\t"+car.getStartDate()+"\t"+car.getReturnDate()+"\t");
			
		}
	}
	public  void showChoose(User user) {
		System.out.println("输入0退出");
		System.out.println("输入1+汽车编号 进入租车订单 如1+2");
		System.out.println("输入2+1 按价格降序排序 2+2 按价格升序排序");
		System.out.println("输入3+类型编号 按类型搜索");
		System.out.println("输入4+品牌编号 按品牌搜索");
		System.out.println("输入5  查看全部汽车");
		System.out.println("输入6 查看我的租车记录");
		System.out.println("输入7+汽车编号 还车");
		String choose=InputUtil.next();
		String[] str = choose.split("\\+");
		switch(str[0]) {
		case "0":
			break;
        case "1":
			new RentCarView().start(str[1],user);
			break;
		case "2":
			new RankCarView().start(str[1],user);
			break;
		case "3":
			new SearchCarView().searchByCate(str[1],user);
			break;
		case "4":
			new SearchCarView().searchByBrand(str[1],user);
			break;
		case "5":
			start(user);
			break;
		case "6":
			new RecordView().start(user);
			try {
				System.out.println("跳转中...");
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			showChoose(user);
			break;
		case "7":
			new ReturnCarView().start(str[1],user);
			break;
		default:
			showChoose(user);
			break;
	
		}
	}
	public  void adShowChoose() {
		System.out.println("输入0退出");
		System.out.println("输入1+汽车编号  查看指定汽车");
		System.out.println("输入2  查看全部汽车");
		System.out.println("输入3  增加汽车");
		System.out.println("输入4+汽车编号  修改汽车信息");
		System.out.println("输入5 查看汽车记录");
		System.out.println("输入6+汽车编号   删除汽车");
		String choose=InputUtil.next();
		String[] str = choose.split("\\+");
		switch(str[0]) {
        case "0":
        	new AdStartView().start();
			break;
		case "1":
			adQueryCar(str[1]);
			try {
				System.out.println("跳转中...");
				Thread.sleep(3000);
				adShowChoose();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "2":
			adStart();
			break;
		case "3":
			addCar();
			break;
		case "4":
			updateCar(str[1]);
			break;
		case "5":
			showRecord();
			break;
		case "6":
			deleteCar(str[1]);
			break;
		default:
			adShowChoose();
			break;
		
		}
	}
	//1.通过汽车编号查看指定汽车
	public void adQueryCar(String str) {
		Car car=carService.queryCar(str);
		System.out.println("编号\t汽车名称\t备注\t品牌\t类型\t价格\t是否可租\t是否上架\t");
		String a="";
		if(car.getUserable()==0) {a="可租";}
		else{a="不可租";}
		String b="";
		if(car.getStatus()==0) {b="上架";}
		else{b="下架";}
		System.out.println(car.getId()+"\t"+car.getModel()+
				"\t"+car.gettComments()+"\t"+car.getBrandName()+"("+car.getBrandId()+")"+"\t"
				+car.getCateName()+"("+car.getCategoryId()+")"+"\t"+car.getRent()
				+"/天\t"+a+"\t"+b+"\t");
		
	}
	//3.增加汽车
	public void addCar() {
		System.out.println("===========================");
		System.out.println("请分别输入以下信息");
		System.out.println("-----------------------");
		System.out.println("品牌如下:");
		System.out.println("品牌编号  品牌名");
		System.out.println("1               标志");
		System.out.println("2               大众");
		System.out.println("3               奥迪");
		System.out.println("4               奔驰");
		System.out.println("5               宝马");
		System.out.println("请选择品牌编号:");
		long brandId=InputUtil.nextLong();
		System.out.println("-----------------------");
		System.out.println("类型如下:");
		System.out.println("类型编号 类型名");
		System.out.println("1               紧凑型");
		System.out.println("2               舒适型");
		System.out.println("3               SUV ");
		System.out.println("4               精英型");
		System.out.println("请选择类型编号:");
		long cateId=InputUtil.nextLong();
		System.out.println("-----------------------");
		System.out.println("型号:");
		String model=InputUtil.next();
		System.out.println("-----------------------");
		System.out.println("车牌号:");
		String carNumber=InputUtil.next();
		System.out.println("-----------------------");
		System.out.println("概要:");
		String comments=InputUtil.next();
		System.out.println("-----------------------");
		System.out.println("颜色:");
		String color=InputUtil.next();
		System.out.println("-----------------------");
		System.out.println("汽车价格");
		double price=InputUtil.nextDouble();
		System.out.println("-----------------------");
		System.out.println("每日租金:");
		double rent=InputUtil.nextDouble();
		System.out.println("-----------------------");
		System.out.println("是否可借(0:可借 1:不可借)");
		int useable=InputUtil.nextInt();
		System.out.println("-----------------------");
		System.out.println("是否上架(0:上架 1:下架)");
		int status=InputUtil.nextInt();
		Car car=new Car(0, carNumber, brandId, model,
				color, cateId, comments, price, rent, status, useable);
		int result=carService.addCar(car);
		if(result>0) {
			System.out.println("增加成功!");
			try {
				System.out.println("跳转中...");
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			adStart();
		}else {
			System.out.println("增加失败!");
			adStart();
		}
	}
	//4.修改汽车
	public void updateCar(String str) {
		Car car=carService.queryCar(str);
		System.out.println("==============================================================");
		System.out.println("编号\t汽车名称\t备注\t品牌\t类型\t\t汽车总价\t\t租赁价格\t是否可租\t是否上架\t");
		String a="";
		if(car.getUserable()==0) {a="可租";}
		else{a="不可租";}
		String b="";
		if(car.getStatus()==0) {b="上架";}
		else{b="下架";}
		System.out.println(car.getId()+"\t"+car.getModel()+
				"\t"+car.gettComments()+"\t"+car.getBrandName()+"("+car.getBrandId()+")"+"\t"
				+car.getCateName()+"("+car.getCategoryId()+")"+
				"\t"+car.getPrice()+"\t"+car.getRent()
				+"/天\t"+a+"\t"+b+"\t");
		System.out.println("请输入要修改的内容的编号");
		System.out.println("1.租赁价格2.上架下架");
		String choose=InputUtil.next();
		switch(choose) {
		case "1":
			System.out.println("请输入新的租赁价格");
			double newrent=InputUtil.nextDouble();
			int result=carService.updateRent(car, newrent);
			if(result>0) {
				System.out.println("修改成功!");
				Car car2=carService.queryCar(str);
				System.out.println("==============================================================");
				System.out.println("编号\t汽车名称\t备注\t品牌\t类型\t\t汽车总价\t\t租赁价格\t是否可租\t是否上架\t");
				if(car2.getUserable()==0) {a="可租";}
				else{a="不可租";}
				if(car2.getStatus()==0) {b="上架";}
				else{b="下架";}
				System.out.println(car2.getId()+"\t"+car2.getModel()+
						"\t"+car2.gettComments()+"\t"+car2.getBrandName()+"("+car2.getBrandId()+")"+"\t"
						+car2.getCateName()+"("+car2.getCategoryId()+")"+
						"\t"+car2.getPrice()+"\t"+car2.getRent()
						+"/天\t"+a+"\t"+b+"\t");
				try {
					System.out.println("跳转中...");
					Thread.sleep(3000);
					adShowChoose();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				System.out.println("已出租汽车暂不可修改");
				try {
					System.out.println("跳转中...");
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				adShowChoose();
			}
			break;
		case "2":
			System.out.println("请输入0:上架 1:下架");
			int status=InputUtil.nextInt();
			int row=carService.updateStatus(car, status);
			if(row>0) {
				System.out.println("修改成功!");
				Car car2=carService.queryCar(str);
				System.out.println("==============================================================");
				System.out.println("编号\t汽车名称\t备注\t品牌\t类型\t汽车总价\t租赁价格\t是否可租\t是否上架\t");
				if(car2.getUserable()==0) {a="可租";}
				else{a="不可租";}
				if(car2.getStatus()==0) {b="上架";}
				else{b="下架";}
				System.out.println(car2.getId()+"\t"+car2.getModel()+
						"\t"+car2.gettComments()+"\t"+car2.getBrandName()+"("+car2.getBrandId()+")"+"\t"
						+car2.getCateName()+"("+car2.getCategoryId()+")"+
						"\t"+car2.getPrice()+"\t"+car2.getRent()
						+"/天\t"+a+"\t"+b+"\t");
				try {
					System.out.println("跳转中...");
					Thread.sleep(3000);
					adShowChoose();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				System.out.println("修改失败");
				try {
					System.out.println("跳转中...");
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				adShowChoose();
			}
			break;
		}
	}
	//5.查询租赁记录
	public void showRecord() {
		List<Car> list=carService.adShowRecord();
		adShowRecord(list);
		showRecordChoose();
	}
	public void deleteCar(String str) {
		int rows=carService.deleteCar(str);
		if(rows>0) {
			System.out.println("删除成功");
			try {
				System.out.println("跳转中...");
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			adStart();
		}else {
			System.out.println("删除失败");
			adStart();
		}
	}
	public void showRecordChoose() {
		System.out.println("输入0 退出");
		System.out.println("输入5 查看全部汽车");
		System.out.println("输入6 查看全部租赁记录");
		System.out.println("输入7+用户编号 查看指定用户租赁记录");
		System.out.println("输入8+汽车编号 查看指定租赁记录");
		System.out.println("请输入选择:");
		String choose=InputUtil.next();
		String[] str = choose.split("\\+");
		switch (str[0]) {
		case "0":
			adStart();
			break;
		case "5":
			adStart();
			break;
		case "6":
			showRecord();
			break;
		case "7":
			List<Car> list1=carService.adShowRecordByUserId(str[1]);
			adShowRecord(list1);
			try {
				System.out.println("跳转中...");
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			showRecordChoose();
			break;
		case "8":
			List<Car> list2=carService.adShowRecordByCarId(str[1]);
			adShowRecord(list2);
			try {
				System.out.println("跳转中...");
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			showRecordChoose();
			break;
			
		}
	}
	
}
