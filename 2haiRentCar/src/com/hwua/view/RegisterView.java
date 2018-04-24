package com.hwua.view;

import com.hwua.entity.User;
import com.hwua.service.IUserService;
import com.hwua.service.impl.UserServiceImpl;
import com.hwua.util.CheckPhone;
import com.hwua.util.IDCard;
import com.hwua.util.InputUtil;

public class RegisterView {
	public void start() {
		int sex = 0;
		int resul = 0;
		String idNumber;
		String tel = null;
		System.out.println("�û���:");
		String username = InputUtil.next();
		System.out.println("����:");
		String password = InputUtil.next();
		System.out.println("���ٴ���������:");
		String confirmPassword = InputUtil.next();
		if (!password.equals(confirmPassword)) {// ��һ��
			System.out.println("�������벻һ��,ע��ʧ��");
			start();
		}
		do {
			System.out.println("�������Ա�  0:��    1:Ů  ");
			sex = InputUtil.nextInt();
		} while (sex != 0 && sex != 1);
		do {
			// ��λ���ֵ�ַ�룬��λ���ֳ��������룬��λ����˳�����һλ����У���롣
			System.out.println("������18λ���֤����:");
			idNumber = InputUtil.next();
		} while (new IDCard().Verify(idNumber) == false);
		do {
			System.out.println("������绰����:");
			tel = InputUtil.next();
			resul = new CheckPhone().phoneNo(tel);
		} while (resul < 0);
		System.out.println("��ַ:");
		String addr = InputUtil.next();
		User user = new User(0, username, password, sex, idNumber, tel, addr, 0);
		IUserService userService = new UserServiceImpl();
		// ����ҵ���߼��������ҵ��,���ݽ���ߺ�������
		int result = userService.register(user);
		if (result > 0) {
			System.out.println("ע��ɹ�");
			new StartView().start();
		} else {
			System.out.println("���û��Ѵ���,ע��ʧ��");
			System.out.println("��ѡ��:1.����ע��2.������һ��");
			String choose = InputUtil.next();
			switch (choose) {
			case "1":
				new RegisterView().start();
				break;
			case "2":
				new StartView().start();
				break;
			}

		}

	}
}
