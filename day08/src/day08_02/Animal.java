package day08_02;

public abstract class Animal {
	public String kind;	//필드
	
	public void breathe() {	//생성자
		System.out.println("숨을 쉽니다");
	}
	
	public abstract void sound();	//추상메소드
	
}
