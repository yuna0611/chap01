package exam_01;

import java.io.BufferedReader;
import java.util.Scanner;

public class Scout extends Soldier{
//속성
	
	//지휘관 객체에게 메세지를 전달하기 위한 레퍼런스 추가
	private Commander myBoss;
	
	//소총수 객체의 레퍼런스를 셋팅하기 위한 메소드 추가
	public void setCommander(Commander man) {
		myBoss=man;
	}
	
	//기능
	public Scout() {
	}
	
	//지휘관에게 보고	//굳이 외부에 오픈할 필요 노노해
	
	private void report(int num) {
		myBoss.listenScout(num);
		healthPower-=2;
	}
	
	//적군을 감시
	//I/O 처리
	public void watch() {
		/*java.io.BufferedReader stdin;
		stdin = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		String line;*/
		
		Scanner sc = new Scanner(System.in);
		
		int enemy;
		
		try {
			System.out.print("적군의 수는 : ");
			while(true){
				enemy = sc.nextInt();
//				while( ( line = stdin.readLine()) != null){
				
				System.out.println("===================");
				System.out.println(enemy);
				if(enemy==0) {
//					if(line.equals("quit")) {
					System.out.println("프로그램 종료");
					System.exit(0);
				}else {
					//enemy=Integer.parseInt("40");
					report(enemy);
				}
				System.out.print("적군의 수는 : ");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("프로그램 비정상 종료");
			System.exit(-1);
		}
		
		
		
	}
	
	public void eat() {
		this.healthPower+=1;
		System.out.println("척후병 밥 먹음");
	}
}
