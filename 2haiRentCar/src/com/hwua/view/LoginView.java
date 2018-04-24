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
		System.out.println("======登录=====>>>>");
		System.out.println("用户名:");
		String username = InputUtil.next();
		System.out.println("密码:");
		String password = InputUtil.next();
		System.out.println("请输入验证码:");
		do {
			yzm = new VerifCode().getCode(4);
			System.out.println(yzm);
			inputYZM = InputUtil.next();
		} while (!(yzm.equalsIgnoreCase(inputYZM)));
		
		IUserService userService = new UserServiceImpl();
		user = userService.login(username, password);
		if (user != null) {
			if (user.getType() == 0) {
				System.out.println("系统登陆中...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("===================");
				System.out.println("登录成功!欢迎" + user.getUsername());
				// ........下一个界面,主菜单界面
				MainMenuView m = new MainMenuView();
				m.start(user);
			}else {
				System.out.println("您是管理员!请重新输入:");
				start();
			}
		} else {
			System.out.println("===================");
			System.out.println("用户名或密码错误!请重新登录");
			start();
		}
	}
}
