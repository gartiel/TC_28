package com.hwua.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
	public static void main(String[] args) {
		Socket socket = null;
		PrintWriter pw = null;
		BufferedReader brSocket = null;
		Scanner input = new Scanner(System.in);
		try {
			// 1.创建一个Socket对象,指定服务器端ip和端口号,创建成功则表示连接成功
			// 自己主机:127.0.0.1,localhost, 也
			socket = new Socket("127.0.0.1", 6666);
			// 对网路中的输出字节流做包装, true--每次写完自动flush
			pw = new PrintWriter(socket.getOutputStream(), true);
			brSocket = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			// 循环读写
			while (true) {
				System.out.println("请输入用户名:");
				String username = input.next();
				System.out.println("请输入密码:");
				String password = input.next();
				pw.println(username);
				pw.println(password);
				if (username.equals("bye")) {
					break;

				}
				String b = brSocket.readLine();
				System.out.println("from server:" + b);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			// 资源释放
			if (pw != null) {
				pw.close();
			}
			if (brSocket != null) {
				try {
					brSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
