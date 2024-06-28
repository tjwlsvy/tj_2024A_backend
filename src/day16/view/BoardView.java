package day16.view;

import day16.controller.MemberController;     // day16에 있는 MemberController를 참조한다.
import day16.model.dto.MemberDto;           // day16에 있는 MemberDto를 참조한다

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
    System.out.println("변경할 이름 :"); String newMname = scan.next();  // String타입의 newMname을 scanner로 newMname 입력받기
    System.out.println("변경할 연락처 :"); String newMphone = scan.next(); // String타입의 newMphone scanner로 newMphone 입력받기

    MemberDto memberDto = new MemberDto();  // memberDto라는 새로운 객체생성
    memberDto.setMname(newMname); memberDto.setMphone(newMphone); // 각 입력받은 newMname,newMphone 있는 setter에 저장한다.
    boolean result = MemberController.mcontrol.mUpdate(memberDto); // memberDto을 MemberController.mcontrol.login에게 전달후 결과를 받은 정보를  boolean타입을 갖고 있는 result에 대입한다.
    if (result){System.out.println("수정성공");                     // 만약에 전달받은 result값이 true이면 수정성공
    }else { System.out.println("수정실패");                         // false이면 수정실패

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
  }
}
