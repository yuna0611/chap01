package ex01;

public class Exercise8_9{
	public static void main(String[] args) throws Exception{
		throw new UnsupportedFuctionException("지원하지 않는 기능입니다",100);
	}
}

class UnsupportedFuctionException extends RuntimeException{
	
	private final int ERR_CODE;
	UnsupportedFuctionException(String msg, int errCode){	//생성자
		super(msg);
		ERR_CODE = errCode;
	}
	
	UnsupportedFuctionException(String msg){	//생성자
		this(msg,100);
	}	
	
	public int getErrorCode(){
		return ERR_CODE;
	}
	public String getMessage() {
		return "["+getErrorCode()+"]"+super.getMessage();
	}
}

/*	* 클래스명 : UnsupportedFuctionException
	* 조상클래스명 : RuntimeException
	
	*멤버변수 : 
		 이름 : ERR_CODE
		 저장값 : 에러코드
		 타입 : int
		 기본값 : 100
		 제어자 : final private
		 
	*메서드 : 
		1. 메서드명 : getErrorCode
			기능 : 에러코드(ERR_CODE)를 반환
			반환타입 : int
			매개변수 : 없음
			제어자 : public
		2. 메서드명 : getMessage
		 	기능 : 메세지의 내용을 반환. (Exception 클래스의 getMessage()를 오버라이딩)
		 	반환타입 : String
		 	매개변수 : 없음
		 	제어자 : public
		 	*/
