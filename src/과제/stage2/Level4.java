package 과제.stage2;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Level4 {
    public static void main(String[] args) {
        int random = new Random().nextInt(3);
        Scanner scan = new Scanner(System.in);

        System.out.println("가위 바위 보 중에 입력 하세요");
        String player=scan.next();
        String com="";

        if(random==0){com="가위";}
        else if (random==1) { com="바위"; }
        else{ com="보"; }
        System.out.println("comran)" +com);

        if (player.equals(com)){
            System.out.println("비겼습니다.");}
        else if (player.equals("보")&& com.equals("바위") ||
                player.equals("바위")&& com.equals("가위") ||
                player.equals("가위")&& com.equals("보")){
            System.out.println("player승리");}
        else if (player.equals("보")&& com.equals("가위")||
                player.equals("바위")&& com.equals("보") ||
                player.equals("가위")&& com.equals("바위")){
            System.out.println("com 승리");
        }else {
            System.out.println("비겼습니다.");}



    }
}



//
//[문제] 가위바위보 게임을 진행합니다.
//	[조건]
//        1. 문제풀이 위치 외 코드는 수정 불가 합니다.
//		2. 가위 바위 보 입력은 문자로 입력받습니다. [ player 변수 사용 ]
//        3. 그림과 같이 컴퓨터가 낸 수를 출력합니다. [ com 변수 사용 ]
//난수 생성 코드 참고 : int random = new Random().nextInt(3);
//		4. 승리자를 출력합니다.
//

