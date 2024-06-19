package day10.Step1;

import java.util.ArrayList;

import java.util.Scanner;

public class step4 {
    public static void main(String[] args) {

        // 입력객체
        Scanner scan = new Scanner(System.in);

        // 1. 배열구성
        int count = 0;
        ArrayList<Product>productList = new ArrayList<>();

        // 2. 무한루프
        while (true) {

            System.out.println("리스트상태확인 : " + productList);

            System.out.println("[1.등록 , 2.출력 3.수정 4.삭제 5.종료 선택]");

            int ch = scan.nextInt();//무한입력, 입력받은 데이터로 기능을 구분짓기 위해
            if (ch == 1) {
                System.out.println(">>코드 :");
                String code = scan.next();
                System.out.println(">>제품명 :");
                String name = scan.next();
                System.out.println(">>제품가격:");
                int price = scan.nextInt();
                // 2. 가공(유효성검사 혹은 객체화)
                Product p = new Product(code, name, price);

                // 3. 배열에 저장
                productList.add(p);
            } else if (ch == 2) {
            } else if (ch == 3) {
            } else if (ch == 4) {
                // 1. 입력받기
                System.out.println(">>삭제할 제품코드 : ");
                String deleteCode = scan.next();
                // 2. 삭제할 제품 코드를 찾는다
                for (int i = 0; i < productList.size(); i++) {
                    if (productList.get(i).getCode().equals(deleteCode)) {
                        productList.remove(i);
                        break;
                    }
                }


            } else if (ch == 5) {
            }



        }

    }
}


/*
4. 제품CRUD_객체와가변길이배열버전
    - [메모리 설계] 외 모든 조건이 동일합니다.
    [ 메모리 설계 ]
        - 최대 제품 개수는 [!!!]제한없음
        - 제품의 속성은 제품코드 , 제품명 , 제품가격 3개
        - 배열은 1개 선언 가능 합니다.
        - 제품 클래스를 선언하고 객체를 활용 하시오.
        - 제품 등록시 제품객체는 생성되므로 while문 밖에 미리 배열내 객체를 임의로 생성하지 마시오.
        - 반복문을 최대한 활용하여 코드을 줄이시오.
        [추가]
        - 제품 클래스의 모든 멤버변수는 private 사용 합니다.
        - 제품 객체 생성시 매개변수가 3개인 생성자를 활용 합니다.

    [ 메모리 설계 ]
    1. 객체의 추상적인 구성(특성 , 행위)하기
    2. 구성한 개념을 클래스로 구현하기
    3. 해당클래스 타입의 객체를 여러개 저장하기 위해 배열 선정
        - 배열선언방법 : 타입[] 배열변수명 = new 타입[길이]
    [화면구현설계]
    1. 콘솔에 출력할 내용들을 구성

*/