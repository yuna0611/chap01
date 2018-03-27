package sec13.exam01_class_access1;

public class AccessProtect {
	protected int a,b;
	
	public AccessProtect(int a, int b) {
		super();
		this.a=a;
		this.b=b;
	}
	
	protected void method() {
		System.out.println("AccessProtect");
		System.out.println(a);
		System.out.println(b);
	}
}
