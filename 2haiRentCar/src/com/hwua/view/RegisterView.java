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
		System.out.println("用户名:");
		String username = InputUtil.next();
		System.out.println("密码:");
		String password = InputUtil.next();
		System.out.println("请再次输入密码:");
		String confirmPassword = InputUtil.next();
		if (!password.equals(confirmPassword)) {// 不一致
			System.out.println("两次密码不一致,注册失败");
			start();
		}
		do {
			System.out.println("请输入性别  0:男    1:女  ");
			sex = InputUtil.nextInt();
		} while (sex != 0 && sex != 1);
		do {
			// 六位数字地址码，八位数字出生日期码，三位数字顺序码和一位数字校验码。
			System.out.println("请输入18位身份证号码:");
			idNumber = InputUtil.next();
		} while (new IDCard().Verify(idNumber) == false);
		do {
			System.out.println("请输入电话号码:");
			tel = InputUtil.next();
			resul = new CheckPhone().phoneNo(tel);
		} while (resul < 0);
		System.out.println("地址:");
		String addr = InputUtil.next();
		User user = new User(0, username, password, sex, idNumber, tel, addr, 0);
		IUserService userService = new UserServiceImpl();
		// 调用业务逻辑层来完成业务,根据结果走后续流程
		int result = userService.register(user);
		if (result > 0) {
			System.out.println("注册成功");
			new StartView().start();
		} else {
			System.out.println("该用户已存在,注册失败");
			System.out.println("请选择:1.重新注册2.返回上一级");
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
