package 과제.stage3;

import java.util.Scanner;

public class Level4 {
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    int sum = 0;
    String s = "";

    while (true){
      System.out.print("input : "); int i = scan.nextInt();
      sum += i;
      for (int j = 0; j < sum; j++  ){
        System.out.print("■");

      }
      if (sum == 0 ){break;}

    }




  }
}
