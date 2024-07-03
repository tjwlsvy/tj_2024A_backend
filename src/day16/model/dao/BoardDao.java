package day16.model.dao;

import day16.model.dto.BoardDto;
import day16.model.dto.MemberDto;
import day16.model.dto.ReplyDto;

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
          // String sql = "select * from board;";    // 1. sql 작성
          // board 의 mno와 member mno가 같으면 출력
          String sql = "select * from board b inner join member m on  b.mno = m.mno order by bno desc ";
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
            boardDto.setMid(rs.getString("mid"));

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
  public boolean bDelete( int bno , int mno  ){
    try{ //0.예외처리
      String sql ="delete from board where bno = ? and mno = ? "; // 1. SQL 작성
      ps = conn.prepareStatement(sql); // 2. sql 기재
      ps.setInt( 1 , bno );// 3. 기재된 sql의 ? 매개변수 값 대입
      ps.setInt( 2 , mno );
      int count = ps.executeUpdate(); // 4. sql 실행 후 결과 받기
      if( count == 1 ) return true; // 5. 결과에 따른 반환처리
    }catch (Exception e ){ System.out.println(e);}
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
  // 9. 댓글 출력 함수
  public ArrayList<ReplyDto> rPrint(int bno){
    ArrayList<ReplyDto> list = new ArrayList<>(); // 여러개 ReplyDto 담을 리스트
    try {
      // String sql = "select * from reply where bno = ?;"; // sql 작성
      String sql = " select * from reply r inner join member m on r.mno = m.mno where r.bno = ? ";
      ps = conn.prepareStatement(sql);  // sql 기재
      ps.setInt(1 , bno);             // 기재된 sql의 ? 매개변수 값 대입
      rs = ps.executeQuery();         // sql 실행 후 결과 반환
      while (rs.next()){              // rs.next() : 결과에서 다음 레코드 이동
        // - rs.get 타입("필드명") . rs.get타입("필드번호") : 두가지 방법 가능
        ReplyDto replyDto = new ReplyDto(rs.getString(1), rs.getString(2) ,
                                          rs.getInt(3), rs.getInt(4), rs.getInt(5)  );
        replyDto.setMid(rs.getString(6));
        // 생성된 dto 리스트 담기
        list.add(replyDto);
      }
    }catch (Exception e){
      System.out.println(e);}
    return list;  // 리스트 반환

  }


  // 10. 댓글 쓰기 함수
  public boolean rWrite(ReplyDto replyDto){
    try {
      String sql = "INSERT INTO reply( rcontent , mno , bno ) VALUES( ? , ? , ? )";
      ps = conn.prepareStatement(sql);
      ps.setString(1,replyDto.getRcontent());
      ps.setInt(2,replyDto.getMno());
      ps.setInt(3,replyDto.getBno());
      int count = ps.executeUpdate();

      if (count == 1){return true;}


    }catch (Exception e){System.out.println(e);
    }return false;

  }

  // 11. 조회수 증가 처리
  public boolean viewIncrease(int bno){
    try {
      String sql = " update board set bview = bview + 1 where bno = ?";
      ps = conn.prepareStatement(sql);
      ps.setInt(1 , bno);
      int count = ps.executeUpdate();
      if (count == 1)return true;

    }catch (Exception e){ System.out.println(e);
    }return false;

  }
  // 12. 제목검색 함수
  public ArrayList<BoardDto> search(String title){
    ArrayList<BoardDto> list = new ArrayList<>();   // 리스트 만들기
    try{
      // String sql = "select *from board where btitle like '%제%'";           [가능]
      // String sql = "select *from board where btitle like '%?%'";            [불가능 ?파라미터 인식 불가]
      // String sql = "select *from board where btitle like ?";                [ ? -> ps.setString(1, "%"+title+"%");]연결방식이면 가능
      // String sql = "select *from board where btitle like '%"+title+"%' ";   [ 연결 연산자 ] 가능
      // String sql = "select *from board where bview like %?%";               [ 불가능 ]
      // String sql = "select *from board where bview like %3%";                [불가능]
      String sql = "select *from board where btitle like CONCAT( '%' , ? , '%')"; // [실행 가능]
      // SQL 제공하는 CONCAT('문자열','문자열','문자열') 문자열 연결 함수

      ps = conn.prepareStatement(sql);
      ps.setString(1,title);
      // ps.setString(1, "%"+title+"%");
      // ps.setInt(1,3);

      rs = ps.executeQuery();
//      System.out.println(rs.next()); print에 next 하면 1바퀴 순회 사용 x
      while (rs.next()){
        BoardDto boardDto = new BoardDto(rs.getString("btitle"),rs.getString("bcontent"),
                rs.getString("bdate"),rs.getInt("bview"),rs.getInt("mno"),rs.getInt("bno"));

        list.add(boardDto);
      }
    }catch (Exception e){  System.out.println(e);
    }
    return list;
  }   //  search 메소드 end



}




