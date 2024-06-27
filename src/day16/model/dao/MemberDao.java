package day16.model.dao;

import day16.model.dto.MemverDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDao {

    // 0.
    public static MemberDao mdao = new MemberDao();

    // 0. DB연동
        // - JDBC 인터페이스 3개
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

        // - 생성자에 연동코드
    MemberDao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/day06","root","1234" );
        }catch (Exception e){ System.out.println(">>연동실패"+e); }
    }


    // 1. 회원화면 함수
    public boolean signup(MemverDto memverDto){
        try {// 1. SQL 작성한다
            String sql = "insert into member(mid , mpwd , mname , mphone) values( ? ,? , ? , ? )";
            System.out.println("sql");
            // 2. SQL 기재한다.
            ps = conn.prepareStatement(sql);
            // 2. SQL 문법의 ?(와일드카드) 매개변수 기재한다
            ps.setString(1,memverDto.getMid());  // .set String(?순서 , 값 또는 변수명)
            ps.setString(2,memverDto.getMpwd());
            ps.setString(3, memverDto.getMname());
            ps.setString(4,memverDto.getMphone());
            // 3. SQL 실행한다. // 4. 실행결과
            int count = ps.executeUpdate(); //executeUpdate() 등록된 레코드수 반환 , 1개레코드 등록되면 성공
            if (count == 1){return true;}

        }catch (Exception e){ System.out.println(e);}
        return false;

    }

    // 2. 로그인 화면 함수
    public boolean login(MemverDto memverDto){
        try {

            // SQL 작성
            String sql = "select * from member where mid = ? and mpwd = ? ";
            // 2. 연동객체에 sql기재
            ps = conn.prepareStatement(sql);
            // 매개변수에 변수값 대입
            ps.setString(1, memverDto.getMid());
            ps.setString(2, memverDto.getMpwd());
            // 실행
            rs = ps.executeQuery(); // 쿼리 실행후 결과를 rs로 받는다

            // 다음 레코드 : 로그인성공시 레코드 1개 실패시 레코드 0개
            if (rs.next()) { return true; } // 다음 레코드가 1개라도 존재하면 로그인 성공
        }catch (Exception e){ System.out.println(e);}
        return false;    // 로그인 실패
    }

    // 3. 아이디찾기 화면함수
    public String findId(MemverDto memverDto){
        try {
            String sql = "select *from member where mname = ? and mphone = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1 , memverDto.getMname());
            ps.setString(2, memverDto.getMphone());
            rs = ps.executeQuery();
            if (rs.next()){String findId = rs.getString("mid");//rs.getString("필드명" : 현재 레코드의 필드명에 해당하는 필드값 반환
                        return findId;
            }
        }catch (Exception e){System.out.println(e);}
        return null;
    }

    // 4. 비밀번호찾기 화면함수
    public String findPwd(MemverDto memverDto){
        System.out.println("memverDto = " + memverDto);
        try {
            String sql = "select * from member where mid = ? and mphone = ?" ;
            ps = conn.prepareStatement(sql);
            ps.setString(1 , memverDto.getMid());
            ps.setString(2 , memverDto.getMphone());
            rs = ps.executeQuery();
            if (rs.next()){
                String findpwd = rs.getString("mpwd");
                return findpwd;
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }



}
