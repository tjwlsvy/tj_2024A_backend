package day16.view;

import day16.controller.BoardController;
import day16.controller.MemberController;     // day16에 있는 MemberController를 참조한다.
import day16.model.dto.BoardDto;
import day16.model.dto.MemberDto;           // day16에 있는 MemberDto를 참조한다
import day16.model.dto.ReplyDto;

import java.util.ArrayList;
import java.util.Scanner;                 // 패키지내 Scanner 참조한다.

public class BoardView {                  // BoardView라는 클래스를 생성한다

  // 0.
  public static BoardView bView = new BoardView();  //  해당 클래스인 BoardView를 함수들을 다른 클래스에서 호출할수 있도록 static변수에 해당 객체(bView) 생성
  public Scanner scan = new Scanner(System.in);   // Scanner기능을 갖고잇는 scan객체 생성

  // 0. 로그인 성공시 초기화면
  public void index2() { // 어디든 접근이 가능한 public void라는 타입의 index2()라는 함수를 만든다.
    while (true) {      // 반복문인 while문 생성한다.
      System.out.println(">> 1.로그아웃 2.회원수정 3.회원탈퇴 4.게시판 :");
      int ch = scan.nextInt();    // 객체 ch라는 스캐너를 만들어준다.

      if (ch == 1) {    // 만약에 ch가 1이면 logout()함수호출한다
        logout();
        return;
      } else if (ch == 2) {    // 만약에 ch가 2이면 mUpdate()함수호출한다
        mUpdate();
      } else if (ch == 3) {    // 만약에 ch가 3이면 mDelete()함수호출한다
        if (mDelete()) ;
        return;
      } else if (ch == 4) {    // 만약에 ch가 4이면 bprint()함수호출한다
        bprint();
      } else {
      }


    }
  }

  // 1. 로그아웃 함수
  public void logout() {   // 어디든 접근이 가능한 public void라는 타입의 logout()라는 함수를 만든다.
    // 회원 컨트롤러에 로그아웃 메소드 호출
    MemberController.mcontrol.logout();
    System.out.println("로그아웃 성공(초기메뉴로)");

  }

  // 2. 회원수정 함수
  public void mUpdate() { // 어디든 접근이 가능한 public void라는 타입의 mUpdate()라는 함수를 만든다.
    System.out.println("회원 정보를 수정 하겠습니까?"); //1
    System.out.println("변경할 이름 :");
    String newMname = scan.next();  // String타입의 newMname을 scanner로 newMname 입력받기
    System.out.println("변경할 연락처 :");
    String newMphone = scan.next(); // String타입의 newMphone scanner로 newMphone 입력받기

    MemberDto memberDto = new MemberDto();  // memberDto라는 새로운 객체생성
    memberDto.setMname(newMname);
    memberDto.setMphone(newMphone); // 각 입력받은 newMname,newMphone 있는 setter에 저장한다.
    boolean result = MemberController.mcontrol.mUpdate(memberDto); // memberDto을 MemberController.mcontrol.login에게 전달후 결과를 받은 정보를  boolean타입을 갖고 있는 result에 대입한다.
    if (result) {
      System.out.println("수정성공");                     // 만약에 전달받은 result값이 true이면 수정성공
    } else {
      System.out.println("수정실패");                         // false이면 수정실패

    }
  }


  // 3. 회원탈퇴 함수
  public boolean mDelete() {   // 어디든 접근이 가능한 public boolean라는 타입의 mUpdate()라는 함수를 만든다.

    System.out.println("[정말 탈퇴할까요?]");
    System.out.println("확인 비밀번호 :");
    String confirmPwd = scan.next();          // String 타입의 confirmPwd객체를 scanner로 입력 받는다.
    boolean result = MemberController.mcontrol.mDelete(confirmPwd); // confirmPwd을 MemberController.mcontrol.mDelete 전달후 결과를 받은 정보를  boolean타입을 갖고 있는 result에 대입한다.
    if (result) {                                               // 만약에 reult가 true이면 탈퇴성공
      System.out.println("탈퇴 성공");
      return true;
    } else {
      System.out.println("탈퇴실패");                            // 아니면 false 탈퇴실패
      return false;

    }
  }

  // 4. 게시판(게시물전체출력) 함수
  public void bprint() {// 어디든 접근이 가능한 public void라는 타입의 bprint()라는 함수를 만든다.
    // 컨트롤러에게 전체 게시물 조회 요청
    ArrayList<BoardDto> result = BoardController.getInstance().bprint();
    System.out.println("번호\t조회수\t\t\t작성일\t\t작성자\t\t제목");
    // 리스트 객체명.forEach(반복변수 -> {실행문;})
      // 리스트내 전체 dto를 하나씩 반복변수에 대입 반복
    result.forEach(dto -> {
      System.out.printf("%2d\t%2d\t%10s\t%10s\t%s \n", dto.getBno(), dto.getBview(), dto.getBdate(), dto.getMid() , dto.getBtitle());
    });
    System.out.println("0.글쓰기 1~:개별글 조회 :"); int ch = scan.nextInt();

    if(ch==0){bWrite();}
    else if (ch >= 1){bView( ch );} // 게시글 번호 입력받기

  }

  // 5. 게시물 쓰기 함수
  public void bWrite(){ // 앞에 다른 next 가 있을때 필요없는 nextLine 필요
    // 입력받기
    scan.nextLine();
    System.out.println("제목 작성 :");  String btitle = scan.nextLine();
    System.out.println("게시글 작성 :"); String bcontent = scan.nextLine();
    // 2. 입력받은 값들을 객체의 각각 매개변수에 값 대입
    BoardDto boardDto = new BoardDto();
    boardDto.setBtitle(btitle); boardDto.setBcontent(bcontent);
    // 3. 입력받은 객체를 컨트롤에게 전달후 결과 응답받기
    boolean result = BoardController.getInstance().bWrite(boardDto);
    if (result){
      System.out.println(">> 글 작성 성공");
    }else {
      System.out.println(">> 글 작성 실패");
    }

  }
  // 6. 게시물 개별조회 함수
  public void bView(int bno){
    // - 매개변수로 선택받은 게시물을 번호를 컨트롤에게 전달 후 해당 게시물 정보 받기
    BoardDto result = BoardController.getInstance().bView(bno);

    if (result == null){
      System.out.println(">> 존재하지 않는 게시물 입니다.");
      return;
    }
    System.out.println("제목 :"+ result.getBtitle());
    System.out.print("작성자 :"+result.getMno());
    System.out.println("\t조회수 :"+result.getBview());
    System.out.println("작성일 :"+result.getBdate());
    System.out.println("내용 : "+result.getBcontent());

    // ----------- 댓글 출력 ----------------- //
    rPrint(bno);
    // ------------------------------------- //

    System.out.println(">>0.뒤로가기 1.삭제 2.수정 3.댓글쓰기 :");
    int ch = scan.nextInt();

    if (ch == 1){ bDelete(bno);}
    else if (ch == 2){bUpdate(bno);}
    else if (ch == 3){rWrite(bno);}
    else if (ch==0){return;}
  }

  // 7. 게시물 삭제 함수
  public void bDelete( int bno ) {
    boolean result = BoardController.getInstance().bDelete(bno);
    if (result) {  System.out.println(">> 삭제 성공");}
    else {  System.out.println(">>삭제 실패");}
  }

  // 8. 게시물 수정 함수
  public void bUpdate(int bno){
    System.out.println("게시물을 수정 하겠습니까?");
    System.out.println("수정할 제목 : ");  String btitle = scan.next();
    System.out.println("수정할 내용 : ");  String bcontent = scan.next();

    BoardDto boardDto = new BoardDto();
    boardDto.setBno(bno);
    boardDto.setBtitle(btitle);
    boardDto.setBcontent(bcontent); // 각 입력받은 newMname,newMphone 있는 setter에 저장한다.
    boolean result = BoardController.getInstance().bUpdate(boardDto); // memberDto을 MemberController.mcontrol.login에게 전달후 결과를 받은 정보를  boolean타입을 갖고 있는 result에 대입한다.
    if (result) {
      System.out.println("수정성공");                     // 만약에 전달받은 result값이 true이면 수정성공
    } else {
      System.out.println("수정실패");                         // false이면 수정실패

    }
  }

  // 9. 댓글 출력 함수
  public void rPrint(int bno){
    ArrayList<ReplyDto> result = BoardController.getInstance().rPrint(bno);
    System.out.println(result);
    System.out.println("--------댓글------------------");
    System.out.println("\t\t작성일\t\t작성자\t댓글내용");

    // 리스트객체명.froEach(반복변수 -> {실행문})
      // 리스트내 요소들을 하나씩 반복변수에 대입 반복 처리
    result.forEach(reply ->{
      System.out.printf("%s %s %s \n", reply.getRdate() , reply.getMid(), reply.getRcontent());
    } );
  }


  // 10. 댓글 쓰기 함수
  public void rWrite(int bno){
    scan.nextLine();
    System.out.print("댓글 내용 : ");   String rcontent = scan.nextLine();
    ReplyDto replyDto = new ReplyDto();
    replyDto.setBno( bno ); replyDto.setRcontent( rcontent );
    boolean result = BoardController.getInstance().rWrite( replyDto );
    if( result ){  System.out.println(">> 댓글 작성 성공 "); }
    else{ System.out.println(">> 댓글 작성 실패  "); }


  }

//  // - 만약 상황상 로그인후 댓글쓰기가 아니였다면 로그인 상태 확인후 댓글쓰기 가능
//  if( !MemberController.mcontol.loginState()){
//    System.out.println(">> 로그인 후 가능합니다.");
//    return;
//  }

}
