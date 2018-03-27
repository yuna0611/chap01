package com.yuna.ex02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class QueueEx {
	static Queue q = new LinkedList();
	static final int MAX_SIZE = 5;

	public static void main(String[] args) {
		System.out.println("===========================================");
		System.out.println("1. asc  (��������)");
		System.out.println("2. desc (��������)");
		System.out.println("3. list (����)");
		System.out.println("4. history (�����丮)");
		System.out.println("5. q/Q  (����)");
		System.out.println("===========================================");

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			  list.add((int)(Math.random()*10)+1);
		}
		
		while (true) {
			System.out.print(">>");
			try {
				Scanner s = new Scanner(System.in);
				String input = s.nextLine().trim();

				if ("".equals(input))
					continue;

				if(input.equalsIgnoreCase("asc")) {
					asc(list);
					save(input);
				}
				else if(input.equalsIgnoreCase("desc")) {
					desc(list);
					save(input);
				}
				else if (input.equalsIgnoreCase("q"))
					System.exit(0);
				else if (input.equalsIgnoreCase("list")) {
					for(int a:list)
						System.out.print(a+" ");
					System.out.println();
					save(input);
					
				} else if (input.equalsIgnoreCase("history")) {
					int i = 0; // �Է¹��� ��ɾ �����ϰ�,
					save(input);

					// LinkedList�� ������ �����ش�.
					LinkedList tmp = (LinkedList) q;
					ListIterator it = tmp.listIterator();

					while (it.hasNext()) {
						System.out.println(++i + "." + it.next());
					}

				} else {
					save(input);
					System.out.println(input);
				} // if(input.equlasIgnoreCase("q")){
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("�����Դϴ�.");
			}
		} // while(true)
	}// main()

	private static void desc(ArrayList<Integer> list) {
		//desc �޼ҵ�
		Collections.sort(list);
		Collections.reverse(list);
		print(list);
	}

	private static void asc(ArrayList<Integer> list) {
		//asc �޼ҵ�
		Collections.sort(list);
		print(list);
	}

	private static void print(ArrayList<Integer> list) {
		for(int a:list)
			System.out.print(a+" ");
		System.out.println();
	}
	public static void save(String input) {
		// queue�� �����Ѵ�.
		if (!"".equals(input))
			q.offer(input);

		// queue�� �ִ�ũ�⸦ ������ ���� ó�� �Էµ� ���� �����Ѵ�.
		if (q.size() > MAX_SIZE) // size()�� Collection �������̽��� ����
			q.remove();
	}
	
	
}// end of class