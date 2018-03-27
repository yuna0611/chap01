package day06;
class Student{
	String name;
	int ban, no, kor, eng, math;
	
	public Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name=name;
		this.ban=ban;
		this.no=no;
		this.kor=kor;
		this.eng=eng;
		this.math=math;
	}
		
	String info() {
		return name+","+ban+","+no+","+kor+","+eng+","+math+","+getTotal()+","+getAverage();
	}
	int getTotal() {
		return kor+eng+math;
	}
	
	float getAverage() {
		return Math.round((    getTotal()/3.0)       *10F)/10F;
	}
}


public class Ex02 {

	public static void main(String[] args) {
		/*Student s = new Student();
		s.name="ȫ�浿";
		s.ban=1;
		s.no=1;
		s.kor=100;
		s.eng=60;
		s.math=76;*/
		//System.out.println("�̸� : "+s.name+ ", ���� �� : "+s.getTotal()+", ���� ��� : "+s.getAverage());
		Student s = new Student("ȫ�浿", 1, 1, 100, 60, 76);
		System.out.println(s.info());
	}
}
