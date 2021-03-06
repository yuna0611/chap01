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
				System.out.println("[尻衣 奄陥顕]");
				Socket socket = serverSocket.accept();
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("[尻衣 呪喰敗] "+isa.getHostName());
				
				byte[] bytes =null;
				String message = null;
				
				InputStream is = socket.getInputStream();
				bytes = new byte[100];
				int readByteCount = is.read(bytes);
				message = new String(bytes, 0, readByteCount,"UTF-8");
				System.out.println("[汽戚斗 閤奄 失因] : "+message);
				
				
				OutputStream os = socket.getOutputStream();
				message = "尻衣菊雁 ばばばばばばばばばばばば美";
				bytes=message.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("[汽戚斗 左鎧奄 失因]");
				
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
