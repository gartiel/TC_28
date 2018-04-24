package com.hwua.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckPhone {
	
	 public int phoneNo(String phone){
	     String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
	     if(phone.length() != 11){
	         System.out.println("�ֻ���λ��ӦΪ11λ����!");
	         return -1;
	     }else{
	         Pattern p = Pattern.compile(regex);
	         Matcher m = p.matcher(phone);	         
	         if(!(m.matches())){
	             System.out.println("�ֻ��Ÿ�ʽ����!!");
	             return -1;
	         }else {
	        	 
	        	 return 1;
	         }
	     }
	 }
}
