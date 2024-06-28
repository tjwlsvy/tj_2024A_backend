package day16.controller;

import day16.model.dao.MemberDao;           // day16에 있는 MemberDao 참조한다.
import day16.model.dto.MemberDto;           // day16에 있는 MemberDto 참조한다.

public class MemberController { // MemberController클래스를 만든가

    //  MemberController 생성하여 다른 패키지에서 호출할수 있도록 static변수에 해당 객체(mcontrol) 생성
    public static  MemberController mcontrol = new MemberController();



//mid , mpwd , mname , mphone
    // 1. 회원화면 함수 , 매개변수: memberDto( String mid , String mpwd , String mname , String mphone )
    public boolean signup(MemberDto memberDto){ // 어디든 접근이 가능한 public으로 만들어진 boolean라는 타입의 signup()라는 함수를 만든다.
        System.out.println("화원가입 정보를 입력하세요 : ");
        System.out.println("mcontrol.signup");
        boolean result = MemberDao.mdao.signup(memberDto);// memberDto을 MemberController.mcontrol.signup에게 전달후 결과를 받은 정보를  boolean타입을 갖고 있는 result에 대입한다.
        return result;
    }
    // 2-1 로그인 성공한 회원의 번호 저장하는 멤버변수
        // - 글쓰기 , 댓글쓰기 할때 현재 로그인된 회원을 식별하기 위해서
        // - 초기값:0 비로그인상태 , 1~ : 로그인된 회원번호 (로그인된상태)

    public int loginMno = 0;     //  로그인한 회원 번호를 임시저장하기 위해 public 으로 선언된 int 타입의 지역변수입니다.

    // 2-2 로그아웃 함수  // loginMno 지역변수에 0을 저장합니다
    public void logout(){ loginMno = 0;}     // 어디든 접근이 가능한 public으로 만들어진 void 반환타입의 logout()라는 함수를 만든다.

    // 2. 로그인 화면 함수
    public boolean login(MemberDto memberDto){  // 어디든 접근이 가능한 public으로 만들어진 void 반환타입의 login()라는 함수를 만든다.
        loginMno = MemberDao.mdao.login(memberDto); // memberDto을 MemberController.mcontrol.login에게 전달후 결과를 받은 정보를 int타입을 있는 login 대입한다.
        return loginMno == 0 ? false : true;        // 삼항연산자 :  조건 ? 참 : 거짓   ,   로그인된회원번호가 0 이면 false 반환 0이 아니면 true 반환
    }


    // 3. 아이디찾기 화면함수
    public String findId(MemberDto memberDto){  //  어디든 접근이 가능한 public으로 만들어진 String 반환타입의 findId()라는 함수를 만든다.
       return MemberDao.mdao.findId(memberDto); // 정의는 대부분 { }
            // MemberDao :  MemberDao클래스 호출
                // MemberDao.mdao : MemberDao클래스 안에 있는 mdao 멤버변수의 객체 호출 [  mdao :  new MemberDao(); ]
                    //MemberDao.mdao.findId() : MemberDao클래스 안에 있는 mdao 멤버변수의 객체 호출 해서 findId() 호출
                        //MemberDao.mdao.findId( memberDto ) : MemberDao클래스 안에 있는 mdao 멤버변수에 들어있는 객체를 호출 해서 findId() 에 매개변수로 memberDto 전달하여 함수 호출한다. findId()실행후 반환값 값을 리턴 한다.
    }

    // 4. 비밀번호찾기 화면함수
    public String findPwd(MemberDto memberDto){ //  어디든 접근이 가능한 public으로 만들어진 String 반환타입의 findPwd()라는 함수를 만든다.
        return MemberDao.mdao.findPwd(memberDto);
        //MemberDao.mdao.findPwd( memberDto ) : MemberDao클래스 안에 있는 mdao 멤버변수에 들어있는 객체를 호출 해서 findPwd() 에 매개변수로 memberDto 전달하여 함수 호출한다. findPwd()실행후 반환값 값을 리턴 한다.
    }

    // 5. 회원탈퇴 함수
    public boolean mDelete(String confirmPwd){  //  어디든 접근이 가능한 public으로 만들어진 String 반환타입의 mDelete()라는 함수를 만든다.
        return MemberDao.mdao.mDlelte(confirmPwd , loginMno);
        //MemberDao.mdao.mDlelte( memberDto ) : MemberDao클래스 안에 있는 mdao 멤버변수에 들어있는 객체를 호출 해서 mDlelte() 에 매개변수로 memberDto 전달하여 함수 호출한다. mDlelte()실행후 반환값 값을 리턴 한다.
    }

    // 2. 회원수정 함수
    public boolean mUpdate(MemberDto memberDto){ //  어디든 접근이 가능한 public으로 만들어진 String 반환타입의 mUpdate()라는 함수를 만든다.
        // memberDto 에 로그인된 회원번호
        memberDto.setMno(loginMno);     // memberDto클레스안에있는 loginMno를 setter에 저장한다.
        return MemberDao.mdao.mUpdate(memberDto); // 3개 변수인 수정할 회원명,연락처,로그인된 회원번호 (member)
//MemberDao.mdao.mUpdate( memberDto ) : MemberDao클래스 안에 있는 mdao 멤버변수에 들어있는 객체를 호출 해서 mUpdate() 에 매개변수로 memberDto 전달하여 함수 호출한다. mUpdate()실행후 반환값 값을 리턴 한다.
    } // mUpdate end

}//  c end
