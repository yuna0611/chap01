package ex01;

class A {
	A()
	{
		System.out.println("A 按眉啊 积己");
	}
	
	//牢胶畔胶 糕滚 努贰胶
	class B{
		B(){
			System.out.println("B 按眉 积己");
		}
		int field1;
		//static int field2;
		void method1() {
			
		}
		//static void method2(){}
	}

	static class C{
		C(){
			System.out.println("C按眉 积己");
		}
		int field1;
		static int field2;
		void method1() {}
		static void method2() {}
	}
	
	void method() {
		class D{
			D(){
				System.out.println("D 按眉 积己");
			}
			int field1;
			//static int field2;
			void method1() {}
			//static void method2(){}
		}
		D d=new D();
		d.field1=3;
		d.method1();
	}
}
