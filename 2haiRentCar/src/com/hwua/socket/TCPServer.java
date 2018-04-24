package com.hwua.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		try {
			// 1.创建一个ServerSocket对象,指定端口号
			ServerSocket serverSocket = new ServerSocket(6666);
			while (true) {
				// 2.等待客户端的连接,accept()
				// socket:用来与此次连接的客户端交互
				// 返回成功就表示连接成功
				Socket socket = serverSocket.accept();

				BufferedReader brSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				// 3.连接后的操作 如果是耗时2秒,应该开辟新的线程来处理
				// 输出客户端的ip
				String ip = socket.getInetAddress().getHostAddress();
				System.out.println(ip + "连接成功");
				/*String line=brSocket.readLine();
				System.out.println("FROM"+ip+":"+line);
				brSocket.close();*/
				// 读写...
				// 释放自己包装的流,Socket,注意socket获取的流不需要手动释放
				ServerHandleThread handleThread=new ServerHandleThread(socket);
				handleThread.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
