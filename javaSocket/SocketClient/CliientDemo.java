package com.team1

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/*
 *  需求：使用TCP协议发送和接收数据
 *  
 *  客户端发出数据
 *  客户端接收数据
 */
public class CliientDemo {
	public static void main(String[] args) throws IOException {
		//创建客户端Socket对象
		Socket s = new Socket(InetAddress.getByName("LAPTOP-597VP1RR"),10010);
		//获取输出流对象
		OutputStream os = s.getOutputStream();
		//发出数据
		os.write("tcp,im comming again!!!".getBytes());
		
		//获取输入流对象
		InputStream is = s.getInputStream();
		byte[] bys = new byte[1024];
		int len;//用于存储读到的字节个数
		//接收数据
		len = is.read(bys);
		//输出数据
		System.out.println(new String(bys,0,len));
		//释放资源
		s.close();
		
	}
}
