package com_yuna_ex3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("211.183.8.34",5001 ));
			while(true) {
				System.out.println("[���� ��ٸ�]");
				Socket socket = serverSocket.accept();
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("[���� ������] "+isa.getHostName());
				
				byte[] bytes =null;
				String message = null;
				
				InputStream is = socket.getInputStream();
				bytes = new byte[100];
				int readByteCount = is.read(bytes);
				message = new String(bytes, 0, readByteCount,"UTF-8");
				System.out.println("[������ �ޱ� ����] : "+message);
				
				
				OutputStream os = socket.getOutputStream();
				message = "����ƴ� �ФФФФФФФФФФФ���";
				bytes=message.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("[������ ������ ����]");
				
				is.close();
				os.close();
				socket.close();
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(!serverSocket.isClosed()) {
			try {
				serverSocket.close();
			} catch (IOException e1) {
				// TODO: handle exception
			}
		}
	}
}
