package 과제.stage3;

public class Level3 {
  public static void main(String[] args) {
    int july1 = 3532100;
    int july2 = 9123700;
    int july3 = 5183400;
    int july4 = 11738700;

    int j1 = july1 / 1000000;
    int j2 = july2 / 1000000;
    int j3 = july3 / 1000000;
    int j4 = july4 / 1000000;

    int u1 = july1 / 10000;
    int u2 = july2 / 10000;
    int u3 = july3 / 10000;
    int u4 = july4 / 10000;

    String s1 = " ";
    String s2 = " ";
    String s3 = " ";
    String s4 = " ";

    System.out.println(" ------ 7월 매출액 ------ ");
    for (int i = 0; i < j1; i++) {
      s1 += "■";
    }
    System.out.printf("%s %d만원\n", s1, u1);
    for (int i = 0; i < j2; i++) {
      s2 += "■";
    }
    System.out.printf("%s %d만원\n", s2 , u2);
    for (int i = 0; i < j3; i++) {
      s3 += "■";
    }
    System.out.printf("%s %d만원\n", s3 , u3);
    for (int i = 0; i < j4; i++) {
      s4 += "■";
    }
    System.out.printf("%s %d만원", s4 , u4);


  }
}
//다음과 같이 july1,july2,july3,july4 변수는 7월의 1주차,2주차,3주차,4주차 의 매출액이 저장된 변수 입니다.
//        1. 주차별로 100만원당 도형 '■' 출력하시오.
//		2. 도형 뒤로는 그림과 같이 만원대 까지만 출력하시오.
//	[샘플]
//int july1 = 3532100;
//int july2 = 9123700;
//int july3 = 5183400;
//int july4 = 11738700;