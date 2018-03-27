package day06;

public class Ex07Test extends Ex07{
	@Override
	double areaCircle(double r) {
		System.out.println("Computer 객체의 areaCircle() 실행");
		return Math.PI*r*r;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int r =10;
		
		Ex07 calculator = new Ex07();
		System.out.println("원면적 : "+calculator.areaCircle(r));
		System.out.println();
		
		Ex07Test computer = new Ex07Test();
		System.out.println("원면적 : "+computer.areaCircle(r));
	}

}
