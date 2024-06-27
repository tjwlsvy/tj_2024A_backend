package day16.controller;

import day16.model.dao.MemberDao;
import day16.model.dto.MemverDto;

public class MemberController {

    // 0 .
    public static  MemberController mcontrol = new MemberController();



//mid , mpwd , mname , mphone
    // 1. 회원화면 함수 , 매개변수: memberDto( String mid , String mpwd , String mname , String mphone )
    public boolean signup(MemverDto memverDto){
        System.out.println("화원가입 정보를 입력하세요 : ");
        System.out.println("mcontrol.signup");
        boolean result = MemberDao.mdao.signup(memverDto);
        return result;
    }

    // 2. 로그인 화면 함수
    public boolean login(MemverDto memverDto){
        return MemberDao.mdao.login(memverDto);
    }

    // 3. 아이디찾기 화면함수
    public String findId(MemverDto memverDto){
       return MemberDao.mdao.findId(memverDto);
    }

    // 4. 비밀번호찾기 화면함수
    public String findPwd(MemverDto memverDto){
        return MemberDao.mdao.findPwd(memverDto);
    }




}
