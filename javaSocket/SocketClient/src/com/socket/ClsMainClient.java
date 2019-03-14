package com.socket;

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
		while (true) {
			//TODO 刘涛
			//在这里写
			//1 请用户输入名字
			//2 得到名字之后给服务器发消息，类型是0，意思是你上线了
			//3下线先给服务器发消息，类型1
			//捕捉特定输入，下线指令
			//收到啥，就打印啥
			//关于流程上不懂得，先在群里找李大成写的那个任务分解，再在群里问，最后再问我
		}
	}

	
}
