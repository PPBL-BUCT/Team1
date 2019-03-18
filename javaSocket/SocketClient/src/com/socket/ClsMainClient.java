package com.socket;

import java.util.Scanner;

public class ClsMainClient {

	public static void main(String[] args) {
		String a ="";
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
				System.out.println(transceiver.getNameString()+"Client1 Connect");
			}

			@Override
			public void onConnectFailed() {
				System.out.println("Client1 Connect Failed");
			}
		};
		
		//c1.connect("127.0.0.1", 1234);
		//创建键盘录入对象
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入名字：");
		//字符串接收消息
		a =sc.nextLine();
		//将此线程的名称更改为等于参数 a
		c1.setName(a);
		//建立线程链接
		c1.connect("192.168.43.15", 1234);
		c1.getTransceiver().setNameString(a);
		//睡眠时间调用
		delay();
		//循环登陆，发送消息给服务器证明用户登陆成功
		while (true) {
			if (c1.isConnected()) {
				c1.getTransceiver().send("0qzjk"+a);
				break;
			}
		}
		System.out.println("连上了");
		//循环读取消息，发送消息
		while (true) {
			a=sc.nextLine();
			c1.getTransceiver().send("2qzjk"+a);
		}
	}
	//模拟登陆延迟，捕获线程在等待，睡眠或以其他方式占用时抛出，线程在活动之前或活动期间中断的报错
	static void delay() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
