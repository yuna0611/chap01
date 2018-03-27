package ex01;

public class Button {
	OnClickListener listener;
	
	void setOnCliCkListener (OnClickListener listener) {
		this.listener = listener;
	}
	
	void touch() {
		listener.onClick();
	}
	
	interface OnClickListener{
		void onClick();
	}
}
