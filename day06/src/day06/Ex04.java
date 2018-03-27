package day06;


class MyPoint{
		int x,y;
		MyPoint(int x, int y){
			this.x=x;
			this.y=y;
		}
		
		double getDistance(int x, int y) {
			return Math.sqrt((this.x-x)*(this.x-x)+(this.y-y)*(this.y-y));
		}
}


public class Ex04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyPoint p = new MyPoint(1,1);
		System.out.println(p.getDistance(2,2));
	}

}


