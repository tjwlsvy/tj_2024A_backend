package day10.Step3;

import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {

        /*Student studentLee = new Student(1001, "Lee");
        studentLee.addSubject("국어",100);
        studentLee.addSubject("수학",50);

        Student studentKim = new Student(1002 , "Kim");
        studentKim.addSubject("국어",70);
        studentKim.addSubject("수학",85);
        studentKim.addSubject("영어",100);

        studentLee.showStudentInfo();
        System.out.println("============================================");
        studentKim.showStudentInfo();
        */

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println(" 1.학생등록 2.점수등록 3.점수확인 선택");
            int ch = scanner.nextInt();
            if (ch == 1){}
            if (ch == 2){}
            if (ch == 3){}
            if (ch == 4){}

        }



    }
}
// 학생목록 리스트를 만들어 주세요.
// [학생등록] 1. 학번과 이름을 입력받아 학생객체 생성후 학생목록 리스트에 저장하기
// [점수등록] 학번을 입력받아 동일한 학번이 있을경우 과목명과 점수를 입력받아 해당 학생의 점수리스트 점수 저장하기
// [점수확인] 학번을 입력받아 동일한 학번이 있을경우 해당 학번의 학생의 모든 점수리스트를 출력해주세요.
