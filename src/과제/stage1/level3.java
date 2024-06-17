package 과제.stage1;

import java.util.Scanner;

public class level3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("boolean값을 입력하세요");
        boolean b = scanner.nextBoolean();


        System.out.print("byte 입력하세요");
        byte by1 = scanner.nextByte();

        System.out.print("short 입력하세요");
        short s1 = scanner.nextShort();

        System.out.print("int 입력하세요");
        int i1 = scanner.nextInt();

        System.out.print("long 입력하세요");
        long l1 = scanner.nextLong();

        System.out.print("float 입력하세요");
        float f1 = scanner.nextFloat();

        System.out.print("double 입력하세요");
        double d1 = scanner.nextDouble();

        System.out.print("char 입력하세요");
        char c1 = scanner.next().charAt(0);

        System.out.print("boolean값:\n"+b+"\n");
        System.out.print("byte:\n"+by1+"\n");
        System.out.print("short:\n"+s1+"\n");
        System.out.print("int:\n"+i1+"\n");
        System.out.print("long:\n"+l1+"\n");
        System.out.print("float:\n"+f1+"\n");
        System.out.print("double:\n"+d1+"\n");
        System.out.print("char:\n"+c1+"\n");



    }
}
