package com.hwua.view;

import com.hwua.util.InputUtil;

public class StartView {
	public void start() {
		System.out.println("=============");
		System.out.println("»¶Ó­·ÃÎÊ¶þàË×â³µ");
		System.out.println("=============");
		System.out.println("1.µÇÂ¼  2.×¢²á  ÆäËü.ÍË³ö");
		String choose = InputUtil.next();
		switch (choose) {
		case "1"://µÇÂ¼
			LoginView loginView = new LoginView();
			loginView.start();
			break;
		case "2"://×¢²á
			RegisterView registerView = new RegisterView();
			registerView.start();
			break;
		default:
			break;
		}
	}
	public static void main(String[] args) {
		new StartView().start();
		
	}
}
