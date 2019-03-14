package com.socket;

import java.util.Scanner;

public class ClsMainClient {

	public static void main(String[] args) {
		TcpClient c1 = new TcpClient() {

			@Override
			public void onReceive(SocketTransceiver st, String s) {
				System.out.println(s);
			}

			@Override
			public void onDisconnect(SocketTransceiver st) {
				System.out.println("Client1 Disconnect");
			}

			@Override
			public void onConnect(SocketTransceiver transceiver) {
				System.out.println("Client1 Connect");
			}

			@Override
			public void onConnectFailed() {
				System.out.println("Client1 Connect Failed");
			}
		};
		
		//c1.connect("127.0.0.1", 1234);
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入名字：");
		String a=sc.nextLine();
		c1.setName(a);
		c1.connect("127.0.0.1", 1234);
		delay();
		while (true) {
			if (c1.isConnected()) {
				c1.getTransceiver().send("0qzjk"+a);
				break;
			}
		}
		System.out.println("连上了");
		while (true) {
			a=sc.nextLine();
			c1.getTransceiver().send("2qzjk"+a);
		}
	}
	static void delay() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
