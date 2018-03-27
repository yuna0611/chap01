package ex01;

public class Exercise8_9{
	public static void main(String[] args) throws Exception{
		throw new UnsupportedFuctionException("�������� �ʴ� ����Դϴ�",100);
	}
}

class UnsupportedFuctionException extends RuntimeException{
	
	private final int ERR_CODE;
	UnsupportedFuctionException(String msg, int errCode){	//������
		super(msg);
		ERR_CODE = errCode;
	}
	
	UnsupportedFuctionException(String msg){	//������
		this(msg,100);
	}	
	
	public int getErrorCode(){
		return ERR_CODE;
	}
	public String getMessage() {
		return "["+getErrorCode()+"]"+super.getMessage();
	}
}

/*	* Ŭ������ : UnsupportedFuctionException
	* ����Ŭ������ : RuntimeException
	
	*������� : 
		 �̸� : ERR_CODE
		 ���尪 : �����ڵ�
		 Ÿ�� : int
		 �⺻�� : 100
		 ������ : final private
		 
	*�޼��� : 
		1. �޼���� : getErrorCode
			��� : �����ڵ�(ERR_CODE)�� ��ȯ
			��ȯŸ�� : int
			�Ű����� : ����
			������ : public
		2. �޼���� : getMessage
		 	��� : �޼����� ������ ��ȯ. (Exception Ŭ������ getMessage()�� �������̵�)
		 	��ȯŸ�� : String
		 	�Ű����� : ����
		 	������ : public
		 	*/
