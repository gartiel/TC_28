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
			// 1.����һ��Socket����,ָ����������ip�Ͷ˿ں�,�����ɹ����ʾ���ӳɹ�
			// �Լ�����:127.0.0.1,localhost, Ҳ
			socket = new Socket("127.0.0.1", 6666);
			// ����·�е�����ֽ�������װ, true--ÿ��д���Զ�flush
			pw = new PrintWriter(socket.getOutputStream(), true);
			brSocket = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			// ѭ����д
			while (true) {
				System.out.println("�������û���:");
				String username = input.next();
				System.out.println("����������:");
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
			
			// ��Դ�ͷ�
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
