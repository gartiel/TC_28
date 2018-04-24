package com.hwua.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		try {
			// 1.����һ��ServerSocket����,ָ���˿ں�
			ServerSocket serverSocket = new ServerSocket(6666);
			while (true) {
				// 2.�ȴ��ͻ��˵�����,accept()
				// socket:������˴����ӵĿͻ��˽���
				// ���سɹ��ͱ�ʾ���ӳɹ�
				Socket socket = serverSocket.accept();

				BufferedReader brSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				// 3.���Ӻ�Ĳ��� ����Ǻ�ʱ2��,Ӧ�ÿ����µ��߳�������
				// ����ͻ��˵�ip
				String ip = socket.getInetAddress().getHostAddress();
				System.out.println(ip + "���ӳɹ�");
				/*String line=brSocket.readLine();
				System.out.println("FROM"+ip+":"+line);
				brSocket.close();*/
				// ��д...
				// �ͷ��Լ���װ����,Socket,ע��socket��ȡ��������Ҫ�ֶ��ͷ�
				ServerHandleThread handleThread=new ServerHandleThread(socket);
				handleThread.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
