package exam_01;

import java.io.BufferedReader;
import java.util.Scanner;

public class Scout extends Soldier{
//�Ӽ�
	
	//���ְ� ��ü���� �޼����� �����ϱ� ���� ���۷��� �߰�
	private Commander myBoss;
	
	//���Ѽ� ��ü�� ���۷����� �����ϱ� ���� �޼ҵ� �߰�
	public void setCommander(Commander man) {
		myBoss=man;
	}
	
	//���
	public Scout() {
	}
	
	//���ְ����� ����	//���� �ܺο� ������ �ʿ� �����
	
	private void report(int num) {
		myBoss.listenScout(num);
		healthPower-=2;
	}
	
	//������ ����
	//I/O ó��
	public void watch() {
		/*java.io.BufferedReader stdin;
		stdin = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		String line;*/
		
		Scanner sc = new Scanner(System.in);
		
		int enemy;
		
		try {
			System.out.print("������ ���� : ");
			while(true){
				enemy = sc.nextInt();
//				while( ( line = stdin.readLine()) != null){
				
				System.out.println("===================");
				System.out.println(enemy);
				if(enemy==0) {
//					if(line.equals("quit")) {
					System.out.println("���α׷� ����");
					System.exit(0);
				}else {
					//enemy=Integer.parseInt("40");
					report(enemy);
				}
				System.out.print("������ ���� : ");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("���α׷� ������ ����");
			System.exit(-1);
		}
		
		
		
	}
	
	public void eat() {
		this.healthPower+=1;
		System.out.println("ô�ĺ� �� ����");
	}
}
