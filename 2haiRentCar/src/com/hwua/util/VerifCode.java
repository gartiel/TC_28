package com.hwua.util;

import java.util.Random;

public class VerifCode {
	// ศฅต๔มห"l","1","o","0"
	public String getCode(int size) {
        String yzm = "";
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijkmnpqrstuvwxyz"
                + "23456789";
        Random  r = new Random();
        for(int i = 0; i < size; i ++){
            yzm += chars.charAt(r.nextInt(chars.length()));
        }
        return yzm;
    }
}
