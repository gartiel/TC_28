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
	public void adShowCars(List<Car> list) {
		System.out.println("���\t��������\t��ע\tƷ��\t����\t�۸�\t�Ƿ����\t�Ƿ��ϼ�\t");
		for (Car car : list) {
			String a="";
			if(car.getUserable()==0) {a="����";}
			else{a="������";}
			String b="";
			if(car.getStatus()==0) {b="�ϼ�";}
			else{b="�¼�";}
			System.out.println(car.getId()+"\t"+car.getModel()+
					"\t"+car.gettComments()+"\t"+car.getBrandName()+"("+car.getBrandId()+")"+"\t"
					+car.getCateName()+"("+car.getCategoryId()+")"+"\t"+car.getRent()
					+"/��\t"+a+"\t"+b+"\t");
			
		}
	}
	public void adShowRecord(List<Car> list) {
		System.out.println("���\t�������\t��������\t�û����\t�û���\tÿ�����\t����ܶ�\t��ע\tƷ��\t����\t�賵ʱ��\t\t\t����ʱ��\t");
		for (Car car : list) {
			
			System.out.println(car.getRecordId()+"\t"+car.getId()+"\t"+car.getModel()+"\t"
					+car.getUserId()+"\t"+car.getUserName()+"\t"+
					car.getRent()+"/��\t"+car.getPayment()+"\t"+car.gettComments()+"\t"+car.getBrandName()+"\t"
					+car.getCateName()+"\t"+car.getStartDate()+"\t"+car.getReturnDate()+"\t");
			
		}
	}
	public  void showChoose(User user) {
		System.out.println("����0�˳�");
		System.out.println("����1+������� �����⳵���� ��1+2");
		System.out.println("����2+1 ���۸������� 2+2 ���۸���������");
		System.out.println("����3+���ͱ�� ����������");
		System.out.println("����4+Ʒ�Ʊ�� ��Ʒ������");
		System.out.println("����5  �鿴ȫ������");
		System.out.println("����6 �鿴�ҵ��⳵��¼");
		System.out.println("����7+������� ����");
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
				System.out.println("��ת��...");
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
		System.out.println("����0�˳�");
		System.out.println("����1+�������  �鿴ָ������");
		System.out.println("����2  �鿴ȫ������");
		System.out.println("����3  ��������");
		System.out.println("����4+�������  �޸�������Ϣ");
		System.out.println("����5 �鿴������¼");
		System.out.println("����6+�������   ɾ������");
		String choose=InputUtil.next();
		String[] str = choose.split("\\+");
		switch(str[0]) {
        case "0":
        	new AdStartView().start();
			break;
		case "1":
			adQueryCar(str[1]);
			try {
				System.out.println("��ת��...");
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
	//1.ͨ��������Ų鿴ָ������
	public void adQueryCar(String str) {
		Car car=carService.queryCar(str);
		System.out.println("���\t��������\t��ע\tƷ��\t����\t�۸�\t�Ƿ����\t�Ƿ��ϼ�\t");
		String a="";
		if(car.getUserable()==0) {a="����";}
		else{a="������";}
		String b="";
		if(car.getStatus()==0) {b="�ϼ�";}
		else{b="�¼�";}
		System.out.println(car.getId()+"\t"+car.getModel()+
				"\t"+car.gettComments()+"\t"+car.getBrandName()+"("+car.getBrandId()+")"+"\t"
				+car.getCateName()+"("+car.getCategoryId()+")"+"\t"+car.getRent()
				+"/��\t"+a+"\t"+b+"\t");
		
	}
	//3.��������
	public void addCar() {
		System.out.println("===========================");
		System.out.println("��ֱ�����������Ϣ");
		System.out.println("-----------------------");
		System.out.println("Ʒ������:");
		System.out.println("Ʒ�Ʊ��  Ʒ����");
		System.out.println("1               ��־");
		System.out.println("2               ����");
		System.out.println("3               �µ�");
		System.out.println("4               ����");
		System.out.println("5               ����");
		System.out.println("��ѡ��Ʒ�Ʊ��:");
		long brandId=InputUtil.nextLong();
		System.out.println("-----------------------");
		System.out.println("��������:");
		System.out.println("���ͱ�� ������");
		System.out.println("1               ������");
		System.out.println("2               ������");
		System.out.println("3               SUV ");
		System.out.println("4               ��Ӣ��");
		System.out.println("��ѡ�����ͱ��:");
		long cateId=InputUtil.nextLong();
		System.out.println("-----------------------");
		System.out.println("�ͺ�:");
		String model=InputUtil.next();
		System.out.println("-----------------------");
		System.out.println("���ƺ�:");
		String carNumber=InputUtil.next();
		System.out.println("-----------------------");
		System.out.println("��Ҫ:");
		String comments=InputUtil.next();
		System.out.println("-----------------------");
		System.out.println("��ɫ:");
		String color=InputUtil.next();
		System.out.println("-----------------------");
		System.out.println("�����۸�");
		double price=InputUtil.nextDouble();
		System.out.println("-----------------------");
		System.out.println("ÿ�����:");
		double rent=InputUtil.nextDouble();
		System.out.println("-----------------------");
		System.out.println("�Ƿ�ɽ�(0:�ɽ� 1:���ɽ�)");
		int useable=InputUtil.nextInt();
		System.out.println("-----------------------");
		System.out.println("�Ƿ��ϼ�(0:�ϼ� 1:�¼�)");
		int status=InputUtil.nextInt();
		Car car=new Car(0, carNumber, brandId, model,
				color, cateId, comments, price, rent, status, useable);
		int result=carService.addCar(car);
		if(result>0) {
			System.out.println("���ӳɹ�!");
			try {
				System.out.println("��ת��...");
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			adStart();
		}else {
			System.out.println("����ʧ��!");
			adStart();
		}
	}
	//4.�޸�����
	public void updateCar(String str) {
		Car car=carService.queryCar(str);
		System.out.println("==============================================================");
		System.out.println("���\t��������\t��ע\tƷ��\t����\t\t�����ܼ�\t\t���޼۸�\t�Ƿ����\t�Ƿ��ϼ�\t");
		String a="";
		if(car.getUserable()==0) {a="����";}
		else{a="������";}
		String b="";
		if(car.getStatus()==0) {b="�ϼ�";}
		else{b="�¼�";}
		System.out.println(car.getId()+"\t"+car.getModel()+
				"\t"+car.gettComments()+"\t"+car.getBrandName()+"("+car.getBrandId()+")"+"\t"
				+car.getCateName()+"("+car.getCategoryId()+")"+
				"\t"+car.getPrice()+"\t"+car.getRent()
				+"/��\t"+a+"\t"+b+"\t");
		System.out.println("������Ҫ�޸ĵ����ݵı��");
		System.out.println("1.���޼۸�2.�ϼ��¼�");
		String choose=InputUtil.next();
		switch(choose) {
		case "1":
			System.out.println("�������µ����޼۸�");
			double newrent=InputUtil.nextDouble();
			int result=carService.updateRent(car, newrent);
			if(result>0) {
				System.out.println("�޸ĳɹ�!");
				Car car2=carService.queryCar(str);
				System.out.println("==============================================================");
				System.out.println("���\t��������\t��ע\tƷ��\t����\t\t�����ܼ�\t\t���޼۸�\t�Ƿ����\t�Ƿ��ϼ�\t");
				if(car2.getUserable()==0) {a="����";}
				else{a="������";}
				if(car2.getStatus()==0) {b="�ϼ�";}
				else{b="�¼�";}
				System.out.println(car2.getId()+"\t"+car2.getModel()+
						"\t"+car2.gettComments()+"\t"+car2.getBrandName()+"("+car2.getBrandId()+")"+"\t"
						+car2.getCateName()+"("+car2.getCategoryId()+")"+
						"\t"+car2.getPrice()+"\t"+car2.getRent()
						+"/��\t"+a+"\t"+b+"\t");
				try {
					System.out.println("��ת��...");
					Thread.sleep(3000);
					adShowChoose();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				System.out.println("�ѳ��������ݲ����޸�");
				try {
					System.out.println("��ת��...");
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				adShowChoose();
			}
			break;
		case "2":
			System.out.println("������0:�ϼ� 1:�¼�");
			int status=InputUtil.nextInt();
			int row=carService.updateStatus(car, status);
			if(row>0) {
				System.out.println("�޸ĳɹ�!");
				Car car2=carService.queryCar(str);
				System.out.println("==============================================================");
				System.out.println("���\t��������\t��ע\tƷ��\t����\t�����ܼ�\t���޼۸�\t�Ƿ����\t�Ƿ��ϼ�\t");
				if(car2.getUserable()==0) {a="����";}
				else{a="������";}
				if(car2.getStatus()==0) {b="�ϼ�";}
				else{b="�¼�";}
				System.out.println(car2.getId()+"\t"+car2.getModel()+
						"\t"+car2.gettComments()+"\t"+car2.getBrandName()+"("+car2.getBrandId()+")"+"\t"
						+car2.getCateName()+"("+car2.getCategoryId()+")"+
						"\t"+car2.getPrice()+"\t"+car2.getRent()
						+"/��\t"+a+"\t"+b+"\t");
				try {
					System.out.println("��ת��...");
					Thread.sleep(3000);
					adShowChoose();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				System.out.println("�޸�ʧ��");
				try {
					System.out.println("��ת��...");
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
	//5.��ѯ���޼�¼
	public void showRecord() {
		List<Car> list=carService.adShowRecord();
		adShowRecord(list);
		showRecordChoose();
	}
	public void deleteCar(String str) {
		int rows=carService.deleteCar(str);
		if(rows>0) {
			System.out.println("ɾ���ɹ�");
			try {
				System.out.println("��ת��...");
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			adStart();
		}else {
			System.out.println("ɾ��ʧ��");
			adStart();
		}
	}
	public void showRecordChoose() {
		System.out.println("����0 �˳�");
		System.out.println("����5 �鿴ȫ������");
		System.out.println("����6 �鿴ȫ�����޼�¼");
		System.out.println("����7+�û���� �鿴ָ���û����޼�¼");
		System.out.println("����8+������� �鿴ָ�����޼�¼");
		System.out.println("������ѡ��:");
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
				System.out.println("��ת��...");
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
				System.out.println("��ת��...");
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
