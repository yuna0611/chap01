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
		System.out.println("1. asc  (오름차순)");
		System.out.println("2. desc (내림차순)");
		System.out.println("3. list (보기)");
		System.out.println("4. history (히스토리)");
		System.out.println("5. q/Q  (종료)");
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
					int i = 0; // 입력받은 명령어를 저장하고,
					save(input);

					// LinkedList의 내용을 보여준다.
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
				System.out.println("오류입니다.");
			}
		} // while(true)
	}// main()

	private static void desc(ArrayList<Integer> list) {
		//desc 메소드
		Collections.sort(list);
		Collections.reverse(list);
		print(list);
	}

	private static void asc(ArrayList<Integer> list) {
		//asc 메소드
		Collections.sort(list);
		print(list);
	}

	private static void print(ArrayList<Integer> list) {
		for(int a:list)
			System.out.print(a+" ");
		System.out.println();
	}
	public static void save(String input) {
		// queue에 저장한다.
		if (!"".equals(input))
			q.offer(input);

		// queue의 최대크기를 넘으면 제일 처음 입력된 것을 삭제한다.
		if (q.size() > MAX_SIZE) // size()는 Collection 인터페이스에 정의
			q.remove();
	}
	
	
}// end of class