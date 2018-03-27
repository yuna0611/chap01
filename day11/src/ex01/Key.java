package ex01;

public class Key {
	public int number;
	
	public Key(int number) {
		this.number = number;
	}

	@Override
	public boolean equals(Object arg0) {
		if(arg0 instanceof Key){
			Key compareKey = (Key)arg0;
			if(this.number == compareKey.number)
				return true;
		}
		return false;
		
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return number;
	}
	
	
}
