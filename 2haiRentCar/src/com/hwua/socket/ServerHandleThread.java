package com.hwua.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.hwua.entity.User;
import com.hwua.service.IUserService;
import com.hwua.service.impl.UserServiceImpl;
import com.hwua.view.MainMenuView;

public class ServerHandleThread extends Thread {
	private Socket socket;
	private BufferedReader brSocket;
	private String ip;
	private PrintWriter pwSocket;

	public ServerHandleThread(Socket socket) {
		this.socket = socket;
		try {
			brSocket = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			pwSocket = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ip = socket.getInetAddress().getHostAddress();
	}

	@Override
	public void run() {
		String username = null;
		String password = null;
		String line=null;
		try {
			while (true) {
				
				username = brSocket.readLine();
				password = brSocket.readLine();
				System.out.println("FROM" + ip + ":" + username+":"+password);
				if (username.equals("bye")) {
					break;

				}
				User user=null;
				IUserService userService = new UserServiceImpl();
				user = userService.login(username, password);
				if(user!=null) {
					if(user.getType()==0) {
					
					line="µÇÂ¼³É¹¦!";
					pwSocket.println(line);
					}
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pwSocket != null) {
				pwSocket.close();
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
