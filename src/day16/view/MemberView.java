package day16.view;

import day15.step3_MVC.Controller;
import day16.controller.MemberController;
import day16.model.dto.MemverDto;

import java.util.Scanner;

public class MemberView {

    // - 해당 클래스의 함수들을 다른 클래스에서 호출할수 있도록 static변수에 해당 객체 생성
    public static MemberView mView = new MemberView();

    // 멤버변수 : 입력개체
    Scanner scan = new Scanner(System.in);

    // 0. 초기화면 함수
    public void index(){
        while (true){
            try {
                System.out.println("1.회원가입 2.로그인 3. 아이디찾기 4.비밀번호찾기");
                int ch = scan.nextInt();
                if(ch ==1){signup();}
                else if (ch==2){login();}
                else if (ch==3){findId();}
                else if (ch==4){findPwd();}
                else { System.out.println(">>없는 기능번호 입니다.");}
            }catch (Exception e){
                System.out.println(">잘못된 입력이 있습니다. 초기메뉴로");
                scan = new Scanner(System.in);
            }   // c end
        }   // w end
    }   // m end
    // 1. 회원화면 함수
    public void signup(){
        // 1. 입력
        System.out.println(">> [저장] 아이디 : ");  String mid = scan.next();
        System.out.println(">> [저장] 비밀번호 : "); String mpwd = scan.next();
        System.out.println(">> [저장] 이름 : ");    String mname = scan.next();
        System.out.println(">> [저장] 전화번호 : ");  String mphone = scan.next();
        // 2. 유효성검사

        // 3. 객체화
        MemverDto memberDto = new MemverDto(mid , mpwd , mname , mphone);
        boolean result = MemberController.mcontrol.signup(memberDto );
        if (result){System.out.println("회원가입 성공");
        }else {System.out.println("회원가입 실패");
    }
    }

    // 2. 로그인 화면 함수
    public void login(){
        System.out.println(">> 아이디 : "); String mid = scan.next();
        System.out.println(">> 비밀번호  :"); String mpwd = scan.next();
        MemverDto memverDto = new MemverDto();
        memverDto.setMid(mid); memverDto.setMpwd(mpwd);
        boolean result = MemberController.mcontrol.login(memverDto);
        if (result){System.out.println("로그인 성공");}
        else {System.out.println("로그인 실패");
        }

    }

    // 3. 아이디찾기 화면함수
    public void findId(){
        System.out.println(">> 이름 : "); String mname = scan.next();
        System.out.println(">> 전화번호  :"); String mphone = scan.next();

        MemverDto memverDto = new MemverDto();
        memverDto.setMname(mname); memverDto.setMphone(mphone);

        String result = MemberController.mcontrol.findId(memverDto);
        if (result != null){System.out.println("아이디찾기 성공" + result);
        }else {System.out.println("아이디찾기 실패");}
    }

    // 4. 비밀번호찾기 화면함수
    public void findPwd() {
        System.out.println(">> 아이디 : ");
        String mid = scan.next();
        System.out.println(">> 전화번호  :");
        String mphone = scan.next();
        MemverDto memverDto = new MemverDto();
        memverDto.setMid(mid);
        memverDto.setMphone(mphone);
        String result = MemberController.mcontrol.findPwd(memverDto);
        if (result != null) {
            System.out.println("회원비밀번호 :" + result);
        } else {System.out.println("찾기실패"); }

    }
}// c end
