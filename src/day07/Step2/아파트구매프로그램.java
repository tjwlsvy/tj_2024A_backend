package day07.Step2;

public class 아파트구매프로그램 {
    public static void main(String[] args) {

        아파트설계도 유재석집 = new 아파트설계도("초코파이");
        // 아파트설계도 : 객체가 컴퓨터에 존재하는 위치 주소
            // 101동 106호
        System.out.println(유재석집.음식꺼내기("1234"));

        아파트설계도 강호동집 = new 아파트설계도("쓰레기");
            // 101동 107호
        System.out.println(강호동집.음식꺼내기("1234"));

    }
}
