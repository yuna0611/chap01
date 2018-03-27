package day07.exam01;

public class Time {
	private int hour; 
	private int minute;
	private int second;
	
	public Time(int hour, int minute, int second){
		setHour(hour);
		setMinute(minute);
		setSecond(second);
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		if(hour<0 || hour>23)
			return;
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		if(minute<0 || minute>59)
			return;
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		if(minute<0 || minute>59)
			return;
		this.second = second;
	}

	@Override
	public String toString() {
		return "Time [hour=" + hour + ", minute=" + minute + ", second=" + second + "]";
	}
	
}
