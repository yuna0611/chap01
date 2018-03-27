package com_yuna_ex2;

import java.io.IOException;
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
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(!serverSocket.isClosed()) {
			try {
				serverSocket.close();
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
	}
}
