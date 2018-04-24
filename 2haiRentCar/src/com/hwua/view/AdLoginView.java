package com.hwua.view;

import com.hwua.entity.User;
import com.hwua.service.IUserService;
import com.hwua.service.impl.UserServiceImpl;
import com.hwua.util.InputUtil;

public class AdLoginView {
	public void start() {
		System.out.println("======登录=====>>>>");
		System.out.println("用户名:");
		String username = InputUtil.next();
		System.out.println("密码:");
		String password = InputUtil.next();
		// 查询信息是否存在
		User user = null;
		IUserService userService = new UserServiceImpl();
		user = userService.login(username, password);
		if (user != null) {
			if(user.getType()==1) {
			System.out.println("===================");
			System.out.println("登录成功!欢迎管理员" + user.getUsername());
			// ........下一个界面,主菜单界面
			MainMenuView m = new MainMenuView();
			m.adStart();
			}else {
				System.out.println("您不是管理员,请重新登录!");
				start();
			}
		} else {
			System.out.println("===================");
			System.out.println("用户名或密码错误!请重新登录");
			start();
		}
	}
}
