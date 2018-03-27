package com_yuna_ex1;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Student{
	private SimpleStringProperty name;
	private SimpleIntegerProperty kor;
	private SimpleIntegerProperty math;
	private SimpleIntegerProperty eng;
	
	
	public Student(String name, int kor, int math, int eng) {
		super();
		this.name = new SimpleStringProperty(name);
		this.kor = new SimpleIntegerProperty(kor);
		this.math = new SimpleIntegerProperty(math);
		this.eng = new SimpleIntegerProperty(eng);
	}


	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public int getKor() {
		return kor.get();
	}

	public void setKor(int kor) {
		this.kor.set(kor);
	}

	public int getMath() {
		return math.get();
	}

	public void setMath(int math) {
		this.math.set(math);
	}

	public int getEng() {
		return eng.get();
	}

	public void setEng(int eng) {
		this.eng.set(eng);
	}
}
