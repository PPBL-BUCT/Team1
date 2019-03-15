package com.socket;
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
			public void onReceive(SocketTransceiver client, String s) {
				//client.send("收到"+client.getName()+"发的"+s);
				String[] msg = s.split("qzjk");//按照分隔符分开
				if(msg[0].equals("0")) {//分隔符前的字符相当于type
					//通知用户某人上线
					//把client对象存起来
					client.setName(msg[1]);
				for(int i =0;i<userlist.size();i++) {
					userlist.get(i).send("用户"+client.getName()+ "上线了");
				     }
				userlist.add(client);
				}
				else if(msg[0].equals("2")) {
					for(int i=0;i<userlist.size();i++) {
					     userlist.get(i).send(client.getName()+":"+s);
					}
				}
				
			}

			@Override
			public void onDisconnect(SocketTransceiver client) {
				printInfo(client, "Disconnect");
				for(int i=0;i<userlist.size();i++) {
				     userlist.get(i).send("用户"+client.getName()+"下线了");
				}
				userlist.remove(client);
					
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
