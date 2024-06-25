package 과제.stage1;

import java.util.Scanner;

public class level7 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(" 회원명 String : ");
        String s1 = scanner.next();

        System.out.println(" 상태 boolean : ");
        boolean b1 = scanner.nextBoolean();

        System.out.println(" 회원번호 byte : ");
        byte by2 = scanner.nextByte();

        System.out.println(" 성별 char : ");
        char c1 = scanner.next().charAt(0);

        System.out.println(" 나이 short: ");
        short sh1 = scanner.nextShort();

        System.out.println(" 포인트 int : ");
        int i1 = scanner.nextInt();

        System.out.println(" 예금액 long : ");
        long l1 = scanner.nextLong();

        System.out.println(" 키 float: ");
        float f1 = scanner.nextFloat();

        System.out.println(" 몸무게 double : ");
        double d1 = scanner.nextDouble();

        System.out.println("==========회원 개인정보 ===================");
        System.out.println("|              회원명      : " + s1 + " | ");
        System.out.println("|              상태        : " + b1 + " | ");
        System.out.println("|              회원번호     : " + by2 + " |");
        System.out.println("|              성별        : " + sh1 + " | ");
        System.out.println("|              나이        : " + i1 + " | ");
        System.out.println("|              포인트      : " + b1 + " | ");
        System.out.println("|              예금액      : " + l1 + " | ");
        System.out.println("|              키          : " + f1 + " | ");
        System.out.println("|             몸무게       : "+ d1+ " | " );





    }


}
