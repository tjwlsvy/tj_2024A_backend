package 과제.stage2;

import java.util.Random;
import java.util.Scanner;

public class Level2 {
    public static int dbinsert() { return new Random().nextInt(3)+1;  }

    public static void main(String[] args) {
//      [문제] DAO 메소드를 통해 데이터베이스에 회원가입 처리 결과를 result 변수에 반환 했습니다. 결과에 따라 출력을 그림과 같이 하시오.
//	    [조건]
//        1. 문제풀이 위치 외 코드는 수정 불가 합니다.
//        2.
//        반환값[result] 가 1 이면 회원가입 성공 출력
//        2 이면 사용중인 아이디 출력
//        3 이면 입력된 안된 정보가 있습니다 출력
//        그외 데이터베이스 오류 출력
//
        System.out.println(" >> Level2_2 answer >> ");
        Scanner scanner = new Scanner(System.in);


        int result = dbinsert();
//        System.out.println(result);


        if(result == 1){ System.out.println("회원가입 성공");}
        else if (result == 2){ System.out.println("사용중인 아이디");}
        else if (result == 3){ System.out.println("입력된 안된 정보가 있습니다");}
        else{ System.out.println("데이터베이스 오류"); }

        /* ----------- */

    }
}
