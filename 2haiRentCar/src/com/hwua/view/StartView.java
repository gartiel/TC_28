package com.hwua.view;

import com.hwua.util.InputUtil;

public class StartView {
	public void start() {
		System.out.println("=============");
		System.out.println("��ӭ���ʶ����⳵");
		System.out.println("=============");
		System.out.println("1.��¼  2.ע��  ����.�˳�");
		String choose = InputUtil.next();
		switch (choose) {
		case "1"://��¼
			LoginView loginView = new LoginView();
			loginView.start();
			break;
		case "2"://ע��
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
