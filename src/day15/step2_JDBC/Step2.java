package day15.step2_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Step2 {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/day05","root","1234" );

            String sql = " insert into table1 value ('유재석') ";

            // (SQL)Statement 준비하다  ,prepareStatement(); : sql을 문자열로 매개변수로 전달.해당 sql을 조작할수 있는 구현체 반환
            PreparedStatement ps =  conn.prepareStatement(sql);

            // execute 실행하다
            ps. executeUpdate();

            sql = " insert into table1 value ('강호동')";
            ps =  conn.prepareStatement(sql);
            ps. executeUpdate();

        }catch (Exception e){System.out.println("JDBC 연동실패"+e);}



    }
}
