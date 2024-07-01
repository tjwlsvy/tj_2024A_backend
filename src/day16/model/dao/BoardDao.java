package day16.model.dao;

import day16.model.dto.BoardDto;
import day16.model.dto.MemberDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDao {
  // -- tldrmfxhs
  // private static 변수에 해당 클래스의 객체 생성해서 대입
  private static BoardDao bDao = new BoardDao();
  // 해당 클래스의 생성자를 private 한다. 다른 클래스로부터 new 사용하지 못하게 차단하기
  private BoardDao(){
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");  // com.mysql.cj.jdbc.Driver
      conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/day06","root","1234" );
    }catch (Exception e){
      System.out.println(e);
    }
  }
  // 해당 객체(싱글톤)를 외부로부터 접근할 수 있도록
  public static BoardDao getInstance(){return bDao;}
  // JDBC 인터페이스
  Connection conn;
  PreparedStatement ps;
  ResultSet rs;


  // 4. 게시판(게시물전체출력) 함수 : 매개변수 x 리턴값 x 여러개 게시물 -> 리턴값 : 여러개 게시물 -> 여러개 레코드 -> 여러개 dto
  public ArrayList<BoardDto> bprint() {// 어디든 접근이 가능한 public void라는 타입의 bprint()라는 함수를 만든다.
    // - 여러개 Dto 담을 리스트 선언
    ArrayList<BoardDto> list = new ArrayList<>();


      try {// 0. 예외처리
            String sql = "select * from board;";    // 1. sql 작성
          ps = conn.prepareStatement(sql);        // 2. sql 기재
          rs = ps.executeQuery();                 // 3. 기재된 sql 실행
          while (rs.next()){      // 4. 결과 레코드 전체를 하나씩 순화하기
            // rs.next() : 다음 레코드 이동 , 존재하면 true , 없으면 false
            // 레코드 1개당 --> Dto 1개
              //  rs.getString("필드명) : 현재 레코드의 해당 필드명 값 호출
            String btitle = rs.getString("btitle");
            String bcontent = rs.getString("bcontent");
            String bdate = rs.getString("bdate");
            int bview = rs.getInt("bview");
            int mno = rs.getInt("mno");
            int bno = rs.getInt("bno");
            // Dto 만들기
            BoardDto boardDto = new BoardDto(btitle,bcontent,bdate,bview,mno,bno);

            list.add(boardDto); // 리스트에 dto 담기


          }
      }catch (Exception e){System.out.println(e);}
      return list;  // -- 여러개 담긴 Dto의 리스트를 반환

  }

  // 5. 게시물 쓰기 함수
  public boolean bWrite(BoardDto boardDto){
  try {// 0. 예외처리
    // 1. sql 작성
    String sql = "INSERT INTO board( btitle , bcontent , mno ) VALUES( ? , ? , ? );";

    // 2. sql 기재
    ps = conn.prepareStatement(sql);
    // 3. 기재된 sql 의 매개변수 값 대입
    ps.setString(1 , boardDto.getBtitle());
    ps.setString(2 , boardDto.getBcontent());
    ps.setInt(3, boardDto.getMno());
    // 4. sql 결과 받기
    int count = ps.executeUpdate();
    // 5. 결과에 따른 처리 // insert 결과 레코드가 1이면
    if (count == 1){
      return true;
    }

  }catch (Exception e){ System.out.println(e);}
  return false;
  }

  // 6. 게시물 개별조회 함수
  public BoardDto bView(int bno){
    try { // 0. 예외처리
      // 1. sql 작성
      String sql = "select * from board where bno = ?;";
      // 2. sql 기재
      ps = conn.prepareStatement(sql);
      // 3. 기재된 sql ? 매개변수 대입
      ps.setInt(1 , bno);
      // 4. sql 실행 후 결과 반환
      rs = ps.executeQuery();
      // 5. 결과에 따른 처리
      if (rs.next()){
        // - 현재 레코드들의 필드값 각 호출해서 생성자에 매개변수로 대입
        BoardDto boardDto = new BoardDto(rs.getString("btitle"),rs.getString("bcontent"),
                rs.getString("bdate"),rs.getInt("bview"),rs.getInt("mno"),rs.getInt("bno"));
        return boardDto;  // - 생성된 boardDto 반환 1번만 순회하기 때문에 if문 안에서 return;
      }


    }catch (Exception e){System.out.println(e); }
    return null;

  }

  // 7. 게시물 삭제 함수
  public boolean bDelete(int bno , int mno){
    try {
        // sql 작성
        String sql = "delete from board where bno = ? and mno = ? ";
        // sql 기재
        ps =conn.prepareStatement(sql);
        // 기재된 sql 매개변수 대입
        ps.setInt(1 , bno);
        ps.setInt(2 , mno);
        // sql 실행 후 결과반환
        int count = ps.executeUpdate();

        if (count == 1)return true; //  sql 실행 후 결과 받기

    }catch (Exception e){System.out.println(e); }
    return false;
  }

  // 8. 게시물 수정 함수
  public boolean bUpdate(BoardDto boardDto){
    try {
      String sql = "update board set btitle = ? , bcontent = ? where bno = ? and mno = ?;";
      ps = conn.prepareStatement(sql);
      ps.setString(1, boardDto.getBtitle());
      ps.setString(2, boardDto.getBcontent());
      ps.setInt(3 , boardDto.getBno());
      ps.setInt(4 ,boardDto.getMno() );

      int count = ps.executeUpdate();

      if (count == 1)return true;



    }catch (Exception e){System.out.println(e);}
    return false;
  }




}
