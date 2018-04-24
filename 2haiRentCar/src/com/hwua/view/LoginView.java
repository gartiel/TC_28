package com.hwua.view;

import java.sql.SQLException;
import java.util.Random;

import com.hwua.entity.User;
import com.hwua.service.IUserService;
import com.hwua.service.impl.UserServiceImpl;
import com.hwua.util.InputUtil;
import com.hwua.util.VerifCode;

public class LoginView {
	public void start() {
		User user = null;
		String yzm=null;
		String inputYZM=null;
		System.out.println("======��¼=====>>>>");
		System.out.println("�û���:");
		String username = InputUtil.next();
		System.out.println("����:");
		String password = InputUtil.next();
		System.out.println("��������֤��:");
		do {
			yzm = new VerifCode().getCode(4);
			System.out.println(yzm);
			inputYZM = InputUtil.next();
		} while (!(yzm.equalsIgnoreCase(inputYZM)));
		
		IUserService userService = new UserServiceImpl();
		user = userService.login(username, password);
		if (user != null) {
			if (user.getType() == 0) {
				System.out.println("ϵͳ��½��...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("===================");
				System.out.println("��¼�ɹ�!��ӭ" + user.getUsername());
				// ........��һ������,���˵�����
				MainMenuView m = new MainMenuView();
				m.start(user);
			}else {
				System.out.println("���ǹ���Ա!����������:");
				start();
			}
		} else {
			System.out.println("===================");
			System.out.println("�û������������!�����µ�¼");
			start();
		}
	}
}
