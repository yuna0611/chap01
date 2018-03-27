package mms.member.controller;

import java.util.Scanner;

import mms.member.action.Action;

public class MemberController {	//요청한 기능을 판단해서 그 기능을 실행하게 해줌
	public void processRequest(Action action, Scanner sc){
		try {
			action.execute(sc);
			//인터페이스의 레퍼런스 변수가 인터페이스를 구현한 클래스 객체를 참조하며
			//인터페이스에 정의된 메소드를 호출하면 실질적으로 각 클래스에서 구현된 메소드가 호출된다.
		} catch (Exception e) {
			e.printStackTrace();
			//e.printSctackTrace() : 예외 클래스에서 제공되는 메소드 이며 스택에 저장되어 있는 
			//메소드 호출 기록을 추적하는 메소드
			//주로 디버깅시 사용됨.
		}
	}
}
