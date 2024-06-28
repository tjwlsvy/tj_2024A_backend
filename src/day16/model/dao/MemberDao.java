package day16.model.dao;

import day16.model.dto.MemberDto;   // day16에 있는 MemberDto를 참조한다.

import java.sql.Connection;         // java패키지내 sql 패키지내 Connection 인터페이스 호출
import java.sql.DriverManager;      // java패키지내 sql 패키지내 DriverManager 인터페이스 호출
import java.sql.PreparedStatement;  // java패키지내 sql 패키지내 PreparedStatement 인터페이스 호출
import java.sql.ResultSet;          // java패키지내 sql 패키지내 ResultSet 인터페이스 호출

public class MemberDao {    // MemberDao 클래스 생성

    // 해당 클래스인 MemberDao 함수들을 다른 클래스에서 호출할수 있도록 static변수에 해당 객체(mdao) 생성
    public static MemberDao mdao = new MemberDao();

    // 0. DB연동
        // - JDBC 인터페이스 3개
    Connection conn;        // DBSERVER 연동 결과 구현체를 가지는 인터페이스
    PreparedStatement ps;   // 연동된 SQL 을 조작/실행 하는 인터페이스
    ResultSet rs;           // SQL 실행 결과을 조작하는 인터페이스 ( SELECT만 사용됨 )

        // - 생성자에 연동코드
    MemberDao(){
        try {// 예외발생할 가능성이 있다.라는 함수실행
            Class.forName("com.mysql.cj.jdbc.Driver");  // com.mysql.cj.jdbc.Driver
            conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/day06","root","1234" );    // DBSERVER 에"jdbc:mysql://localhost:3306/day06(패키지)","root","1234" 주소값과 id,pw 넣어 연동한다
        }catch (Exception e){ System.out.println(">>연동실패"+e); }//catch 블록 안에 있는 코드를 실행 시킨다. 만일 오류가 발생하지 않으면 catch 문은 실행하지 않는다
    }


    // 1. 회원화면 함수
    public boolean signup(MemberDto memberDto){ // 어디든 접근이 가능한 public boolean라는 타입의 signup()라는 함수를 만든다.
        try {   // 예외발생할 가능성이 있다.라는 함수실행
            // 1. SQL 작성한다
            String sql = "insert into member(mid , mpwd , mname , mphone) values( ? ,? , ? , ? )";  //문자열 sql 변수에 "insert into member(mid , mpwd , mname , mphone) values( ? ,? , ? , ? ) 대입한다.
            System.out.println("sql");
            // 2. SQL 기재한다.
            ps = conn.prepareStatement(sql);        // conn 객체를 이용하여 PreparedStatement 객체를 생성합니다
            // 2. SQL 문법의 ?(와일드카드) 매개변수 기재한다
            ps.setString(1,memberDto.getMid());  // .set String(?순서 , 값 또는 변수명)
            ps.setString(2,memberDto.getMpwd());     // .set String(?순서 , 값 또는 변수명)
            ps.setString(3, memberDto.getMname());   // .set String(?순서 , 값 또는 변수명)
            ps.setString(4,memberDto.getMphone());   // .set String(?순서 , 값 또는 변수명)
            // 3. SQL 실행한다. // 4. 실행결과
            int count = ps.executeUpdate(); // executeUpdate결과 값을 count에 대입한다
            if (count == 1){return true;}   //executeUpdate() 등록된 레코드수 반환 , 1개레코드 등록되면 성공

        }catch (Exception e){ System.out.println(e);}// 예외가 발생되면 예외값을 알려준다.
        return false;  // 메소드 종료

    }

    // 2. 로그인 함수 : 로그인 성홍한 회원번호 반환
    public int login(MemberDto memberDto){  // 어디든 접근이 가능한 public int라는 타입의 login()라는 함수를 만든다.
        try {// 예외발생할 가능성이 있다.라는 함수실행
            // SQL 작성
            String sql = "select * from member where mid = ? and mpwd = ? ";    //문자열 sql 변수에  "select *from member where  mid = ? and mpwd = ? " 대입한다.
            // 2. 연동객체에 sql기재
            ps = conn.prepareStatement(sql);    // conn 객체를 이용하여 PreparedStatement 객체를 생성합니다
            // 매개변수에 변수값 대입
            ps.setString(1, memberDto.getMid());     // .set String(?순서 , 값 또는 변수명)
            ps.setString(2, memberDto.getMpwd());    // .set String(?순서 , 값 또는 변수명)
            // 실행
            rs = ps.executeQuery(); //  ps에 대입한 SQL 기재한 값을 ResultSet 으로 반환해서 rs에 저장.

            // 다음 레코드 : 로그인성공시 레코드 1개 실패시 레코드 0개
            if (rs.next())  // rs의 다음 실행문이 false가 될때까지
            // 다음 레코드가 1개라도 존재하면 회원번호 반환
            { return rs.getInt("mno"); }

        }catch (Exception e){ System.out.println(e);}// 예외가 발생되면 예외값을 알려준다.
        return 0;    // 로그인 실패
    }

    // 3. 아이디찾기 화면함수
    public String findId(MemberDto memberDto){// 어디든 접근이 가능한 public String 타입의 findId()라는 함수를 만든다.
        try {// 예외발생할 가능성이 있다.라는 함수실행
            String sql = "select *from member where mname = ? and mphone = ?";
            ps = conn.prepareStatement(sql);        // conn 객체를 이용하여 PreparedStatement 객체를 생성합니다
            ps.setString(1 ,memberDto.getMname());  // 1번째에 반환된 memberDto.getMname를 대입/저장한다
            ps.setString(2, memberDto.getMphone()); // 2번째에 반환된 memberDto.getMphone 대입/저장한다
            rs = ps.executeQuery();//  ps에 대입한 SQL 기재한 값을 ResultSet 으로 반환해서 rs에 저장한다.
            if (rs.next())   //  ps에 대입한 SQL 기재한 값을 ResultSet 으로 반환해서 rs에 저장.
            {String findId = rs.getString("mid");//rs.getString("mid" : 현재 레코드의 필드명에 해당하는 필드값 반환한다.
                        return findId;
            }
        }catch (Exception e){System.out.println(e);}// 예외가 발생되면 예외값을 알려준다.
        return null;    // 메소드 종료
    }

    // 4. 비밀번호찾기 화면함수
    public String findPwd(MemberDto memberDto){// 어디든 접근이 가능한 public String 타입의 findPwd()라는 함수를 만든다.
        System.out.println("memberDto = " + memberDto);
        try {// 예외발생할 가능성이 있다.라는 함수실행
            String sql = "select * from member where mid = ? and mphone = ?" ;  // 문자열 sql 변수에  "select *from member where mId = ? and mPhone = ?" 대입한다.
            ps = conn.prepareStatement(sql);            // conn 객체를 이용하여 PreparedStatement 객체를 생성합니다
            ps.setString(1 , memberDto.getMid());       // 1번째에 반환된 memberDto.getMid 대입/저장한다
            ps.setString(2 , memberDto.getMphone());    // 2번째에 반환된 memberDto.getMphone 대입/저장한다
            rs = ps.executeQuery();                     //  ps에 대입한 SQL 기재한 값을 ResultSet 으로 반환해서 rs에 저장한다.
            if (rs.next()){                              //  ps에 대입한 SQL 기재한 값을 ResultSet 으로 반환해서 rs에 저장.
                String findpwd = rs.getString("mpwd");  // rs.getString("mpwd") : 현재 레코드의 필드명에 해당하는 필드값 반환한다.
                return findpwd; // 메소드 종료
            }

        }catch (Exception e){// 예외가 발생되면 예외값을 알려준다.
            System.out.println(e);
        }
        return null; // 메소드 종료
    }
    // 5. 회원탈퇴 함수
    public boolean mDlelte(String confirmPwd , int loginMno){   // 어디든 접근이 가능한 public boolean 타입의 mDlelte()라는 함수를 만든다.
       try {// 예외발생할 가능성이 있다.라는 함수실행
           String sql = "delete from member where mno = ? and mpwd = ?";  // 문자열 sql 변수에  "select *from member where mId = ? and mPhone = ?" 대입한다.
           ps = conn.prepareStatement(sql);         // conn 객체를 이용하여 PreparedStatement 객체를 생성합니다
           ps.setInt(1 , loginMno);                 // 1번째에 반환된 memberDto.loginMno 대입/저장한다
           ps.setString(2 , confirmPwd);            // 2번째에 반환된 memberDto.confirmPwd 대입/저장한다
           int count = ps.executeUpdate();          // executeUpdate 값을 count에 대입한다
           if(count == 1){return true;}             //  count가 1이면 삭제성공
       }catch (Exception e){// 예외가 발생되면 예외값을 알려준다.
           System.out.println(e);
    }return false; // 메소드 종료


    }
    // 6. 회원수정 함수
    public boolean mUpdate(MemberDto memberDto){    // 어디든 접근이 가능한 public boolean 타입의 mUpdate()라는 함수를 만든다.
        try {// 예외발생할 가능성이 있다.라는 함수실행
            String sql ="update member set mname = ? , mphone = ? where mno = ?;";
            ps = conn.prepareStatement(sql);            // conn 객체를 이용하여 PreparedStatement 객체를 생성합니다
            ps.setString(1, memberDto.getMname());      // 1번째에 반환된 memberDto.getMname 대입/저장한다
            ps.setString(2, memberDto.getMphone());     // 2번째에 반환된 memberDto.getMphone 대입/저장한다
            ps.setInt(3, memberDto.getMno());           // 3번째에 반환된 memberDto.getMno 대입/저장한다
            int count = ps.executeUpdate();             // executeUpdate에 등록된 레코드를 count에 대입
            if (count == 1){return true; }              // 만약에 count가 1이면 true
        }catch (Exception e){System.out.println(e);// 예외가 발생되면 예외값을 알려준다.
        }return false; // 메소드 종료

    }

}
