package com.hwua.view;

import com.hwua.util.InputUtil;

public class AdStartView {
	public void start() {
		System.out.println("=============");
		System.out.println("»¶Ó­·ÃÎÊ¶þàË×â³µ");
		System.out.println("=============");
		System.out.println("1.µÇÂ¼  2.ÍË³ö");
		String choose = InputUtil.next();
		switch (choose) {
		case "1"://µÇÂ¼
			AdLoginView adLoginView = new AdLoginView();
			adLoginView.start();
			break;
		case "2"://ÍË³ö
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
