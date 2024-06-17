package day06.Step8;

public class step8 {
    public static void main(String[] args) {

        // 1, 함수호츌
        계산기 c = new 계산기();  // 객체 생성

        // 2. 객체내 함수 호출 호출시 3, 5
        c.sumMethod1( 3 , 5 );

        // 2. 객체내 함수호출
        int  result2 = c.sumMethod2();
        System.out.println("result2="+result2);

        // 2. 함수 호출
        c.sumMethod3();

        // 2. 함수호출
        c.sumMethod4( 3 , 5 );

    }
}
