package com.team1

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/*
 *  ����ʹ��TCPЭ�鷢�ͺͽ�������
 *  
 *  �ͻ��˷�������
 *  �ͻ��˽�������
 */
public class CliientDemo {
	public static void main(String[] args) throws IOException {
		//�����ͻ���Socket����
		Socket s = new Socket(InetAddress.getByName("LAPTOP-597VP1RR"),10010);
		//��ȡ���������
		OutputStream os = s.getOutputStream();
		//��������
		os.write("tcp,im comming again!!!".getBytes());
		
		//��ȡ����������
		InputStream is = s.getInputStream();
		byte[] bys = new byte[1024];
		int len;//���ڴ洢�������ֽڸ���
		//��������
		len = is.read(bys);
		//�������
		System.out.println(new String(bys,0,len));
		//�ͷ���Դ
		s.close();
		
	}
}
