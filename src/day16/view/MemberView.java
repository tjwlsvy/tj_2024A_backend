package day16.view;


import day16.controller.MemberController;   // day16에 있는 MemberController를 참조한다
import day16.model.dto.MemberDto;           // day16에 있는 MemberDto 참조한다


import java.util.Scanner;   // 다른 패키지에 있는 Scanner 를 view 패키지에서도 사용.

public class MemberView {       // MemberView 클래스 생성

    // - 해당 클래스의 함수들을 다른 클래스에서 호출할수 있도록 static변수에 해당 객체 생성
        // - static 선언시점 : 프로그램 시작시 , 사라짐/초기화 시점 : 프로그램 종료시
        // - 메소드를 실행하기 위해서 객체 필요 , static 메소드가 아닌 이상,
        // - 멤버변수는 객체 마다 할당 , 메소드는 객체마다 실행을 하지만 코드는 공유
        // - 전역객체 -> 모든 곳에서 호출 가능한 객체1개
        // - 싱글톤(생성자에 private) : 프로그램내 전역으로 하나의 객체를 생성 , 주로 전역에서 공유할때
    public static MemberView mView = new MemberView();
    // private MemberView(){}  // 생성자에 private 한다. : 다른 클래스에서 new 를 못한다,

    // 멤버변수 : scan 입력개체 생성
    Scanner scan = new Scanner(System.in);

    // 0. 초기화면 함수
    public void index(){    // 어디든 접근이 가능한 public void라는 타입의 index()라는 함수를 만든다.
        while (true){   // while라는 반복문을 사용한다.
            try {   // 예외발생할 가능성이 있다.
                System.out.println("1.회원가입 2.로그인 3. 아이디찾기 4.비밀번호찾기");
                int ch = scan.nextInt();    // ch 라는 scan 객체를 만듦
                if(ch ==1){signup();}       // ch가 1일때 signup으로
                else if (ch==2){login();}   // ch가 2일때 login으로
                else if (ch==3){findId();}  // ch가 3일때 findId으로
                else if (ch==4){findPwd();} // ch가 4일때 findPwd으로
                else { System.out.println(">>없는 기능번호 입니다.");}
            }catch (Exception e){//catch 블록 안에 있는 코드를 실행 시킨다. 만일 오류가 발생하지 않으면 catch 문은 실행하지 않는다
                System.out.println(">잘못된 입력이 있습니다. 초기메뉴로");
                scan = new Scanner(System.in);  // 잘못된 입력이 있습니다. 초기메뉴로 메시지 출력 후, 사용자에게 다시 입력을 받기 위해 새로운 Scanner 객체를 생성합니다.
            }   // c end
        }   // w end
    }   // m end
    // 1. 회원화면 함수
    public void signup(){ // 어디든 접근이 가능한 public void라는 타입의 signup()라는 함수를 만든다.
        // 1. 입력
        System.out.println(">> [저장] 아이디 : ");  String mid = scan.next();    // String타입의 mid를 scanner로 id 입력받기
        System.out.println(">> [저장] 비밀번호 : "); String mpwd = scan.next();   // String타입의 mid를 scanner로 pw 입력받기
        System.out.println(">> [저장] 이름 : ");    String mname = scan.next();     // String타입의 mid를 scanner로 name 입력받기
        System.out.println(">> [저장] 전화번호 : ");  String mphone = scan.next();    // String타입의 mid를 scanner로 phone 입력받기
        // 2. 유효성검사

        // 3. 객체화
        MemberDto memberDto = new MemberDto(mid , mpwd , mname , mphone);   // 새로운 mid MemberDto 객체를 생성하여, mpwd , mname , mphone를 대입
        boolean result = MemberController.mcontrol.signup(memberDto ); // 불리언 타입의 result라는 객체를 만들고 MemberController.mcontrol.signup에 있는 정보를 받는다.
        if (result){System.out.println("회원가입 성공");  // true면 성공
        }else {System.out.println("회원가입 실패");   // 아니면 false 실패.
        }
    }

    // 2. 로그인 화면 함수
    public void login(){// 어디든 접근이 가능한 public void라는 타입의 login()라는 함수를 만든다.
        System.out.println(">> 아이디 : "); String mid = scan.next();      // String타입의 mid를 scanner로 id 입력받기
        System.out.println(">> 비밀번호  :"); String mpwd = scan.next();   // String타입의 mpwd를 scanner로 id 입력받기
        MemberDto memberDto = new MemberDto();                            // memberDto라는 새로운 생성자를 만든가
        memberDto.setMid(mid); memberDto.setMpwd(mpwd);                   // 각 입력받은 mid , mpwd를 memberDto.setter에 저장한다.
        boolean result = MemberController.mcontrol.login(memberDto);      // memberDto에 있는 MemberController.mcontrol.login으로 받은 정보를  boolean타입을 갖고 있는 result에 대입한다.
        if (result){    // 만약에 result가 true면 로그인성공                  // memberDto을 MemberController.mcontrol.login에게 전달후 결과를 받은 정보를  boolean타입을 갖고 있는 result에 대입한다.
            System.out.println("로그인 성공");
            BoardView.bView.index2();
            // 로그인 성공시 로그인된 메뉴로 이동
        }
        else {System.out.println("로그인 실패"); // 아니면 로그인 실패
        }

    }

    // 3. 아이디찾기 화면함수
    public void findId(){   // 어디든 접근이 가능한 public void라는 타입의 findId()라는 함수를 만든다.
        System.out.println(">> 이름 : "); String mname = scan.next(); // String타입의 mname를 scanner로 mname 입력받기
        System.out.println(">> 전화번호  :"); String mphone = scan.next();  // String타입의 mphone scanner로 mphone 입력받기

        MemberDto memberDto = new MemberDto();                      //  MemberDto 라는 새로운 클래스 객체를 생성한다.
        memberDto.setMname(mname); memberDto.setMphone(mphone);     // 각 입력받은 mname, mphone memberDto.setter에 저장한다.

        String result = MemberController.mcontrol.findId(memberDto);          // memberDto에 있는  MemberController.mcontrol.findId으로 받은 정보를  String 타입에 result에 대입한다
        if (result != null){System.out.println("아이디찾기 성공" + result);    // 만약 result가 null이 아닐경우 아이디찾기 성공
        }else {System.out.println("아이디찾기 실패");}                         // 아니면 실패.
    }

    // 4. 비밀번호찾기 화면함수
    public void findPwd() { // 어디든 접근이 가능한 public void라는 타입의 findPwd()라는 함수를 만든다.
        System.out.println(">> 아이디 : ");
        String mid = scan.next();                                   //String타입의 mid를 scanner로 mid 입력받기
        System.out.println(">> 전화번호  :");
        String mphone = scan.next();                                //String타입의 mphone scanner로 mphone 입력받기
        MemberDto memberDto = new MemberDto();                      // memberDto라는 새로운 클랙스 객체를 생성한다.
        memberDto.setMid(mid); memberDto.setMphone(mphone);         // 각 입력받은 mid , mphone 을 memberDto.setter에 저장한다.
        String result = MemberController.mcontrol.findPwd(memberDto);    // memberDto에 있는  MemberController.mcontrol.findPwd 받은 정보를  String 타입에 result에 대입한다
        if (result != null) {                                       // // 만약 result가 null이 아닐경우 회원 비밀번호를 알려준다.
            System.out.println("회원비밀번호 :" + result);
        } else {System.out.println("찾기실패"); }                   // 그렇지 않을경우 찾기실패

    }
}// c end
