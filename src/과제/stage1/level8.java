package 과제.stage1;

import java.util.Scanner;

public class level8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String header = "\n============방문록===============\n번호\t 작성자 \t 방문록\n";
        String boardlist = "";
        String footer = "================================\n";
        String output = "";


        System.out.println( header + boardlist + footer );

        System.out.print("[1]작성자 : ");
        boardlist += "1\t"+scanner.next()+"\t";
        System.out.print("[1]방문록 : ");
        scanner.nextLine();
        boardlist += scanner.nextLine()+"\n";
        System.out.println( header + boardlist + footer );

        System.out.print("[2]작성자 : ");
        boardlist += "1\t"+scanner.next()+"\t";
        System.out.print("[2]방문록 : ");
        scanner.nextLine();
        boardlist += scanner.nextLine()+"\n";
        System.out.println( header + boardlist + footer );

        System.out.print("[3]작성자 : ");
        boardlist += "1\t"+scanner.next()+"\t";
        System.out.print("[3]방문록 : ");
        scanner.nextLine();
        boardlist += scanner.nextLine()+"\n";
        System.out.println( header + boardlist + footer );

        System.out.print("[4]작성자 : ");
        boardlist += "1\t"+scanner.next()+"\t";
        System.out.print("[4]방문록 : ");
        scanner.nextLine();
        boardlist += scanner.nextLine()+"\n";
        System.out.println( header + boardlist + footer );

        System.out.print("[5]작성자 : ");
        boardlist += "1\t"+scanner.next()+"\t";
        System.out.print("[5]방문록 : ");
        scanner.nextLine();
        boardlist += scanner.nextLine()+"\n";
        System.out.println( header + boardlist + footer );
    }
}
