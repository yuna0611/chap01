package exam_01;

import java.util.*;

public class Commander extends Soldier{
	private int bulletNum;	//총알의 수
	/*
	private Private attacker;	
	public void setArracker(Private man) {//소총수 객체의 레퍼런스를 셋팅하기 위한 메소드 추가
		attacker=man;
	}*/
	private Vector attackerList;//소총수 객체에게 메세지를 전달하기 위한 레퍼런스 추가
	private Vector sniperList;//sniper 등록을 위한 vector 생성
	private Cook unitCook;
	private Sniper sniper;
	
	//sniper 등록 메소드 정의(r9egistersniper)
	public void registerSniper(Soldier s) {
		sniperList.add(s);
	}
	
	public Commander() {
		attackerList=new Vector();
		sniperList=new Vector();
		this.bulletNum=300;
	}
	//기능
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
	
	//척후병 보고 듣기
	//척후병 보고를 들은 후에는  5명이 넘을때는 방어를,
	//그 이하일때는 공격을
	public void listenScout(int enemyNum) {
		System.out.println("보고받은 적군의 숫자는 : "+enemyNum);
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
			//적군 1명일 때 sniper 추가
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
	
	//소총수 보고 듣기
	//총알이 떨어졌다고 보고하면 채워줌
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
		//적군 공격 메소드 추가(sniperHim)
		
	}


	
}
