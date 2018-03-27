package sec13.exam01_class_access;

import sec13.exam01_class_access1.AccessProtect;

public class AccessEx extends AccessProtect{
	private int x,y;
	public AccessEx(int a, int b, int x, int y) {
		super(a, b);
		
		this.a=a;
		this.b=b;
		this.x = x;
		this.y = y;
	}
	
	protected void method()
	{
		super.method();
		
		System.out.println("AccessEx");
		System.out.println(x);
		System.out.println(y);
	}
}
