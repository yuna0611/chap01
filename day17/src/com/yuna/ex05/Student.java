package com.yuna.ex05;

public class Student implements Comparable<Student>{
	String name;
	int ban;
	int no;
	int kor, eng, math;
	public Student(String name, int ban, int no, int kor, int eng, int math) {
		super();
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	int getTotal() {
		return kor+eng+math;
	}
	
	float getAverage() {
		return (int)((getTotal()/3f)*10+0.5)/10.f;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", ban=" + ban + ", no=" + no + ", kor=" + kor + ", eng=" + eng + ", math="
				+ math + ", getTotal()="+getTotal()+", getAverage()="+getAverage()+"]";
	}

	@Override
	public int compareTo(Student o1) {
		return name.compareTo(o1.name);
	}
	
}
