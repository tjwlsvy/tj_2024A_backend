package day15.step2_JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Step3 {
    public static void main(String[] args) {

        Connection conn = null;
        // DB연동
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day05", "root", "1234");
        }catch (Exception e){  System.out.println(">> 연동실패 "+e); }

        Scanner scan = new Scanner(System.in); // 입력객체
        //ArrayList< String > nameList = new ArrayList<>();   // 여러개 String (문자열)를 저장하는 리스트 객체

        while (true){
            System.out.print("1. 등록 2.출력 3.수정 4.삭제 :");
            try {

                int ch = scan.nextInt();
                if(ch == 1){
                    // 1,  입력받고
                    System.out.println(">> [저장] 이름 : "); String name = scan.next();
                    // DB 저장
                    String sql = "insert into table1 values('"+name+"')";  System.out.println("sql");
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.executeUpdate();


                }
                else if (ch == 2){
                    System.out.println("--------- 이름 명단----------");
                    // 2. DB SQL 레코드 전체검색/조회 : select*from table1;
                    String sql = "select*from table1";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    while ( rs.next() ){    // 첫번째 레코드부터 마지막 레코드까지 순회
                        System.out.println(rs.getString("name"));
                    }

                }
                else if (ch == 3){
                    System.out.println("[수정U] 기존이름 :");     String oldName = scan.next();
                    System.out.println("[수정U] 새로운이름 : ");   String newName = scan.next();
                    // 2. DB SQL 레코드 수정 : update table1 set name = '신동엽2' where name = '신동엽'
                    String sql = "update table1 set name = '"+newName+"' where name = '"+oldName+"'";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.executeUpdate();

                }
                else if (ch == 4){
                    System.out.println(">>[삭제D]이름 : ");String name = scan.next();
                    // 2. DB SQL 레코드 삭제
                    String sql = "delete from table1 where name = '"+name+"'"; System.out.println("sql:"+sql);
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.executeUpdate();

                }
                else { System.out.println(">> 없는 기능 번호 입니다.");}

            }catch (InputMismatchException e){
                System.out.println(" >> 잘못된 입력입니다. ");
                scan = new Scanner(System.in); // 잘못입력받은 값을 가지고 있는 객체를 초기화
            }catch (SQLException e){ System.out.println(">> SQL 구문이 틀렸습니다"+e); }



        }// w end
    }   // m end
}
