package day02;  // 현재 클래스 파일이 위치한 패키지명/폴더명

public class Step1 {    // class s  자바는 모든 코드를 클래스 안에 작성한다.

    // 실행할 코드는 모두 main 함수(스레드포함)안에 작성한다.
    // 지역변수 정의, 함수호출
    public static void main(String[] args) {    // main s

        //  상수 : 변하지 않는 수 vs 변수 : 변하는 수
        // final : 예약어/키워드
        final int MAX_NUM = 100;
        System.out.println("MAX_NUM = " + MAX_NUM);

        final int MIN_NUM;
        MIN_NUM = 0;
        System.out.println("MIN_NUM = " + MIN_NUM);

        //MAX_NUM =1000;  // 오류발생 : 상수이므로 수정이 불가능하다,



    }

}   // class e
