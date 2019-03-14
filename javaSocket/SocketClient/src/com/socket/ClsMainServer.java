package com.jzj.socket;
import java.util.ArrayList;
import java.util.List;

 public class ClsMainServer {
    public static List<SocketTransceiver> userlist=new ArrayList<SocketTransceiver>();
	public static void main(String[] args) {
		int port = 1234;
		TcpServer server = new TcpServer(port) {//TcpServer 类的变量server=新建一个对象TcpServer 

			@Override
			public void onConnect(SocketTransceiver client) {
				printInfo(client, "Connect"); 
			}

			@Override
			public void onConnectFailed() {
				System.out.println("Client Connect Failed");
			}

			@Override
			public void onReceive(SocketTransceiver client, String s, int type) {
				if(type==0) {
					//通知用户某人上线
					//把client对象存起来
				for(int i =0;i<userlist.size();i++) {
					userlist.get(i).send("用户"+client+ "上线了");
				     }
				userlist.add(client);
				}else if(type==1) {
					for(int i=0;i<userlist.size();i++) {
					     userlist.get(i).send("用户"+client+"下线了");
					}
					userlist.remove(client);
				}else if(type==2) {
					printInfo(client, "Send Data: " + s);
					client.send(s);//正常发消息
				}
				
			}

			@Override
			public void onDisconnect(SocketTransceiver client) {
				printInfo(client, "Disconnect");
			}

			@Override
			public void onServerStop() {
				System.out.println("--------Server Stopped--------");
			}
		};
		System.out.println("--------Server Started--------");
		server.start();
	}

	static void printInfo(SocketTransceiver st, String msg) {
		System.out.println("Client " + st.getInetAddress().getHostAddress());
		System.out.println("  " + msg);
	}
}
