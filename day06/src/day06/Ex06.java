package day06;

import java.awt.Frame;
import java.awt.Graphics;


public class Ex06 extends Frame{
	public static void main(String[] args) {
		Ex06 win = new Ex06("�����׸���");
	}
	
	public void paint(Graphics g) {
		Point[] p = {new Point(100,100)
				,new Point(140,50)
				,new Point(200,100)};
		Triangle t = new Triangle(p);
		Circle c = new Circle(new Point(150,150),50);
		
		g.drawOval(c.center.x, c.center.y, c.r, c.r);
		
		g.drawLine(t.p[0].x, t.p[0].y, t.p[1].x, t.p[1].y);
		g.drawLine(t.p[1].x, t.p[1].y, t.p[2].x, t.p[2].y);
		g.drawLine(t.p[2].x, t.p[2].y, t.p[0].x, t.p[0].y);
	}

	Ex06(String title){
		super(title);
		setSize(300,300);
		setVisible(true);
	}
}



class Point{
	int x;
	int y;

	Point(){
		this(0,0);
	}
	
	Point(int x,int y){
		this.x=x;
		this.y=y;
	}
}

class Circle extends Point{
	Point center; //���� ������ǥ
	int r;	//������
	
	Circle(){
		this(new Point(0,0), 100);
	}

	public Circle(Point center, int r) {
		this.center=center;
		this.r=r;
	}
}

class Triangle{
	Point[] p = new Point[3];

	Triangle(Point[] p) {
		this.p=p;
	}
	public Triangle(Point p1, Point p2, Point p3) {
		p[0]=p1;
		p[1]=p2;
		p[2]=p3;
	}
	
}
