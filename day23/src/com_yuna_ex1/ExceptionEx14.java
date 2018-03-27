package com_yuna_ex1;


import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;

public class ExceptionEx14 {

   public static void main(String[] args) {
 PrintStream ps = null;
 FileOutputStream fos = null;
 try { 
    fos = new FileOutputStream("src/com_yuna_ex1/error.log", true); 
    ps = new PrintStream(fos); // err의 출력을 화면이 아닌, error.log 파일로 변경한다
    System.setErr(ps);
    
    System.out.println(1);
    System.out.println(2);
    System.out.println(3);
    System.out.println(0/0); //예외발생 !!!
    System.out.println(4); //실행 안됨
   
} catch (Exception ae) {
System.err.println("--------------------------");
System.err.println("예외 발생시간 :" +new Date()); //현재시간 출력
ae.printStackTrace(System.err);
System.err.println("예외 메세지:" +ae.getMessage());
System.err.println("--------------------------");
}
 System.out.println(6);
   }

}