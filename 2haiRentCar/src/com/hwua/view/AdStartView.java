package com.hwua.view;

import com.hwua.util.InputUtil;

public class AdStartView {
	public void start() {
		System.out.println("=============");
		System.out.println("��ӭ���ʶ����⳵");
		System.out.println("=============");
		System.out.println("1.��¼  2.�˳�");
		String choose = InputUtil.next();
		switch (choose) {
		case "1"://��¼
			AdLoginView adLoginView = new AdLoginView();
			adLoginView.start();
			break;
		case "2"://�˳�
			break;
		default:
			start();
			break;
		}
	}
	public static void main(String[] args) {
		new AdStartView().start();
		
	}
}
