package 과제.stage1;

import java.util.Scanner;

public class level8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String header = "\n==========방문록==========\n번호 \t 작성자 \t 방문록\n";
        String boardList = "";
        String footer = "============================";
        String output = "";
        String writer , list;



        // 1. 작성자 방문록 입력받기
        System.out.println("[1] 작성자 : ");
        writer = scanner.next();

        System.out.println("[1] 방문록 : ");
        list = scanner.next();

        boardList += "1       "+ writer+"       "+ list+ "\n";

        output = header + boardList + footer;
        System.out.println(output);

        // 2. 작성자 방문록 입력받기
        System.out.println("[2] 작성자 : ");
        writer = scanner.next();

        System.out.println("[2] 방문록 : ");
        list = scanner.next();

        boardList += "2       "+ writer+"       "+ list+ "\n";

        output = header + boardList + footer;
        System.out.println(output);

        // 3. 작성자 방문록 입력받기
        System.out.println("[3] 작성자 : ");
        writer = scanner.next();

        System.out.println("[3] 방문록 : ");
        list = scanner.next();

        boardList += "3       "+ writer+"       "+ list+ "\n";

        output = header + boardList + footer;
        System.out.println(output);

        // 4. 작성자 방문록 입력받기
        System.out.println("[4] 작성자 : ");
        writer = scanner.next();

        System.out.println("[4] 방문록 : ");
        list = scanner.next();

        boardList +="4       "+ writer+"       "+ list+ "\n";

        output = header + boardList + footer;
        System.out.println(output);

        // 5. 작성자 방문록 입력받기
        System.out.println("[5] 작성자 : ");
        writer = scanner.next();

        System.out.println("[5] 작성자 : ");
        list = scanner.next();

        boardList +="5       "+ writer+"       "+ list+ "\n";

        output =header + boardList + footer;
        System.out.println(output);




    }
}
