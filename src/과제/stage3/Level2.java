package 과제.stage3;

import java.util.Scanner;

public class Level2 {
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    for (int i = 1; ;i++){
      System.out.println(i+"회 입력 :");
      String s = scan.next();
      if (s.equals("종료")){break;}
    }


  }
}
