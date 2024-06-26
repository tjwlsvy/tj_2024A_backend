package day15.step1_예외처리;

import java.util.Scanner;

public class Step1 {
    public static void main(String[] args) {

        // [1] 일반예외 : 발생 할수도 있고 안할수도 있고, 컴파일러 무조건 예외처리 검사

            try {


            // ===========예외가 발생할것 같은==========//
            Class.forName("java.lang.String");        // .forName(클래스명); : 해당 클래스명이 존재하는지 검사해주는 함수
            Class.forName("java.lang.String2"); // x
            //-java.lang.ClassNotFoundException;
            // =====================================//
            }catch (ClassNotFoundException e){
                // =========예외가 발생 했을때 ========//
                System.out.println(e);  // 로그를 남기고 추후에 개발자가 코드 수정

                //==================================//
            }
        // [2] 실행예외 : 발생 할수도 있고 안할수도 있고, (방지)
        try {
                // ============= 예외 발생할것 같은=======//
            String str1 = "ThisIsJava";
            System.out.println(str1.length()); // 문자열.length() : 문자열길이

            String str2 = null;
            System.out.println(str2.length()); // .(도트/접근)연산자 , 객체내 멤버변수,메소드 접근
            //java.lang.NullPointerException: Cannot invoke "String.length()" because "str2" is null
            // ======================================//
        }catch (NullPointerException e){
            System.out.println(e);
        }

        //
        String st3 = "100";
        String st4 = "1aa";
        int result1 = Integer.parseInt(st3);  // Integer 클래스 : int형 관련 클래스, .parseInt() 문자열 --> 정수형 타입변환
                                              // .parseInt() : static 함수

        System.out.println(result1);

        try {

            int result2 = Integer.parseInt(st4);
            System.out.println(result2);
            // NumberFormatException : For input string: "1aa"
        }catch (NumberFormatException e){
            System.out.println(e);}

        //
        try {


            int[] intArray = { 1 , 2 , 3 };
            System.out.println(intArray[2]);
            System.out.println(intArray[3]);
            // java.lang.ArrayIndexOutOfBoundsException : Index 3 out of bounds for length 3
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);}

        //
            Scanner scanner = new Scanner(System.in);
            int ch = scanner.nextInt(); // 만약에 문자 입력시 예외발생 : java.util.InputMismatchException


        // tru 다중 catch



            String st5 = "1aa";
            int result2 = Integer.parseInt(st5);
            //--> 여기서 예외가 발생하면 아래코드는 실행되지않고 catch로 이동
            System.out.println(result2);

            int[] intArray = {1, 2, 3};
            System.out.println(intArray[3]);







    }
}
