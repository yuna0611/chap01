package ex2;

public class Excercise9_3 {
	public static void main(String[] args) {
		String fullPath = "c:\\jdk1.5\\work\\PathSeparateTest.java";
		String path = "";
		String fileName ="";
		
		
		int index = fullPath.indexOf('P');
		path=fullPath.substring(0,index-1);
		fileName = fullPath.substring(index);
		
		
		/*		
		 int pos = fullPath.lastIndexOf("\\");
		 if(pos!=-1){
		 	path = fullPath.substring(0,pos);
		 	fileName = fullPath.substring(pos+1);
		 }*/
	
		 System.out.println("fullPath : "+fullPath);
		System.out.println("Path : "+path);
		System.out.println("fileName : "+fileName);
	}
}

/*
[실행결과]
fullPath : c:\jdk1.5\work\PathSeparateTest.java
Path : c:\jdk1.5\work
fileName : 
*/