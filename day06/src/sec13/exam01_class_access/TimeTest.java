package sec13.exam01_class_access;

import day07.exam01.Time;

public class TimeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Time t = new Time(12,35,40);
		System.out.println(t.toString());	
		t.setHour(t.getHour()+1);	//����ð����� 1�ð� �ķ� ����
		System.out.println(t.toString());
	}

}
