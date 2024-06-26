package day15.step2_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class Step1 {

    public static void main(String[] args) {

        // 1.
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 여기서 오류 발생시 : 현재 프로젝트내 라이브러리가 제대로 등록 안될때
            System.out.println("<<JDBC 드라이버 호출 성공>>");

            // 2.
            Connection conn; // 인터페이스 타입의 변수 선언
            conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/day05","root","1234" );
            System.out.println("<< DB연동 성공 >>");

        }catch (Exception e){
            System.out.println("JDBC 연동실패"+e);}


    }


}

/*
    JDBC : JAVA DATABASE CONNECT : 자바 데이터베이스 연동
     - JDBC 관련 클래스 / 인터페이스 라이브러리 설치
                        각 DBMS 회사별
                            구현 클래스 제공
                                - MYSQL : mysql-connector-j-8.4.0.jar
                                - ORACLE : ojdbc6.jar
                                - 등등 각 회사별 구현 클래스가 있는 라이브러리 파일 필요
     자바                        * jar : 여러개 클래스와 라이브러리들을 묶음 패키지
     JDBC 인터페이스 제공
    1.

    2.
     - Connection 인터페이스 : DB와 연동 성공한 객체 정보를 가지고 조작/기능/메소드 제공하는 인터페이스
        - 추상메소드




*/

