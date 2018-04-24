package com.hwua.view;

import com.hwua.entity.User;
import com.hwua.service.IUserService;
import com.hwua.service.impl.UserServiceImpl;
import com.hwua.util.InputUtil;

public class AdLoginView {
	public void start() {
		System.out.println("======��¼=====>>>>");
		System.out.println("�û���:");
		String username = InputUtil.next();
		System.out.println("����:");
		String password = InputUtil.next();
		// ��ѯ��Ϣ�Ƿ����
		User user = null;
		IUserService userService = new UserServiceImpl();
		user = userService.login(username, password);
		if (user != null) {
			if(user.getType()==1) {
			System.out.println("===================");
			System.out.println("��¼�ɹ�!��ӭ����Ա" + user.getUsername());
			// ........��һ������,���˵�����
			MainMenuView m = new MainMenuView();
			m.adStart();
			}else {
				System.out.println("�����ǹ���Ա,�����µ�¼!");
				start();
			}
		} else {
			System.out.println("===================");
			System.out.println("�û������������!�����µ�¼");
			start();
		}
	}
}
