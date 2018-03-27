package ex03;

public class NewInstanceExample {
	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("ex03.SendAction");
			Action action = (Action)clazz.newInstance();
			action.execute();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
