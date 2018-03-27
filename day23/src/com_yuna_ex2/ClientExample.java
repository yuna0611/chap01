package com_yuna_ex2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientExample {
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket= new Socket();
			System.out.println("[연결 요청]");
			socket.connect(new InetSocketAddress("211.183.8.34",5001));
			System.out.println("[연결 성공]");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if(!socket.isClosed()) {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
	}
}
