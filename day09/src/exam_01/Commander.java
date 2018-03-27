package exam_01;

import java.util.*;

public class Commander extends Soldier{
	private int bulletNum;	//�Ѿ��� ��
	/*
	private Private attacker;	
	public void setArracker(Private man) {//���Ѽ� ��ü�� ���۷����� �����ϱ� ���� �޼ҵ� �߰�
		attacker=man;
	}*/
	private Vector attackerList;//���Ѽ� ��ü���� �޼����� �����ϱ� ���� ���۷��� �߰�
	private Vector sniperList;//sniper ����� ���� vector ����
	private Cook unitCook;
	private Sniper sniper;
	
	//sniper ��� �޼ҵ� ����(r9egistersniper)
	public void registerSniper(Soldier s) {
		sniperList.add(s);
	}
	
	public Commander() {
		attackerList=new Vector();
		sniperList=new Vector();
		this.bulletNum=300;
	}
	//���
	public Commander(Private man) {
		this();
		attackerList.add(man);
		sniperList.add(man);
	}
	public void addAttacker(Private man) {
		attackerList.add(man);
		sniperList.add(man);
	}
	
	public void setCook(Cook cook) {
		unitCook=cook;
	}
	
	//ô�ĺ� ���� ���
	//ô�ĺ� ���� ���� �Ŀ���  5���� �������� ��,
	//�� �����϶��� ������
	public void listenScout(int enemyNum) {
		System.out.println("������� ������ ���ڴ� : "+enemyNum);
		if(enemyNum>10) {
			for (int idx = 0; idx < attackerList.size(); idx++) {
				Private attacker = (Private)attackerList.get(idx);
				attacker.defence();
			}
		}
		else if(enemyNum>5) {
			for (int idx = 0; idx < attackerList.size(); idx++) {
				Private attacker = (Private)attackerList.get(idx);
				attacker.attack(10);
			}
		}else if(enemyNum==1) {
			//���� 1���� �� sniper �߰�
			for (int idx = 0; idx < sniperList.size(); idx++) {
				Sniper sniper = (Sniper)sniperList.get(idx);
				sniper.Shoot();
			}
		}
		else{
			for (int idx = 0; idx < attackerList.size(); idx++) {
				Private attacker = (Private)attackerList.get(idx);
				attacker.attack();
			}
		}
	}
	
	//���Ѽ� ���� ���
	//�Ѿ��� �������ٰ� �����ϸ� ä����
	public void listenPrivate(Private man) {
	//	System.out.println("---------------");
		if(bulletNum>=30) {
			man.reload(30);
			bulletNum-=30;
		}else {
			man.reload(bulletNum);
			bulletNum=0;
		}
		if(man.getHP()<70) {
			unitCook.cooking();
		}
	}
	
	public void sniperHim() {
		//���� ���� �޼ҵ� �߰�(sniperHim)
		
	}


	
}
