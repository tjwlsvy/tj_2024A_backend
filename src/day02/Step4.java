package day02;

import java.util.Arrays;

public class Step4 {
    public static void main(String[] args) {

        // [콘솔 출력]
        System.out.print("JAVA");
            // System : 시스템 관련 기능 제공하는 클래스
                // out : 출력 관련 객체 제공
                    // print(리터럴 또는 변수명 또는 연산식) : 출력 함수
                    // println(): 출력함수 + 줄바꿈포함
                        //인텔리제이 기준 : sout + 엔터
                    // printf() : 출력함수 + 형식문자 지원
                        // souf + 엔터
                        // 형식문자 : printf() 함수에서 사용되는 형식문자
                        /*
                            %s : 문자열
                            %d : 정수
                            %f : 실수
                            %c : 문자
                            [자릿수 맞추기]
                            %자릿수d : 자릿수만큼 자릿수를 차지 , 만일 비어있으면 공백처리 ,오른쪽 정렬
                            %-자릿수d : 자릿수만큼 자릿수 차지 , 만일 비어있으면 공백처라 , 왼쪽 정렬
                            %0자릿수d : 자릿수만큼 자릿수 차지 , 만일 비어있으면 '0'처리 , 오른쪽 정리
                            [소수점]
                            %자릿수.소수점자릿수f : 자릿수(소수점 포함)만큼 자릿수를 차지 , 소수점자릿수까지 출력 

                            - 제어문자 : 기능이 포함된 문자
                            \ : 엔터위에 원화기호
                            \n : 줄바꿈
                            \t : 들여쓰기
                            \r : 개행(커서를 앞으로)
                            -- 엔터 : \n \r 조합
                            \\ : '\' 백슬래시 출력 , \": " 출력 , \' : '출력

                        */


        System.out.println("JAVA2");
        System.out.println("JAVA3");

        System.out.printf("%s" , "JAVA4");
        System.out.printf("%d" , 123);
        System.out.printf("%f" , 3.14);

        System.out.print("\n 줄바꿈 \t 들여쓰기 \" 큰따움표출력 \\ 백슬래시출력 \' 작은따움표출력 \n");

        int price = 1500;
        String name = "콜라";
        System.out.println("상품의 가격 : "+price+"원 입니다.");
        System.out.printf("상품의 가격 : %d원 입니다. \n" , price);

        System.out.printf("%s의 가격 : %d원 입니다. \n" , name , price);
        System.out.printf("%s의 가격 : %6d원 입니다. \n" , name , price);
        System.out.printf("%s의 가격 : %-6d원 입니다. \n" , name , price);
        System.out.printf("%s의 가격 : %06d원 입니다. \n" , name , price);

        System.out.printf("%s의 가격 : %3.1f원 입니다. \n" , name , 3.14);
        
        // 인텔리제이 출력메소드 자동완성
        // 1. sout
        System.out.println();
        // 2. souf
        System.out.printf("");
        // 3. soutm : 현재 함수명을 문자로 출력
        System.out.println("Step4.main");
        // 4. soutp : 현재 함수의 매개변수 값을 출력
        System.out.println("args = " + Arrays.toString(args));
        // 5. soutv : 커서에서 가장 가까운 변ㅅ수/상수 출력
        System.out.println("name = " + name);

        System.out.println("|\\_/| ");
        System.out.println("|q p|   /}");
        System.out.println("( 0 )\"\"\"\\");
        System.out.println("|\"^\"`    |");





        // [콘솔 입력]

    }
}
