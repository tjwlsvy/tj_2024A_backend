package 과제.stage2;

public class Level3 {
    public static void main(String[] args) {

//        1. 문제풀이 위치 외 코드는 수정 불가 합니다.
//        2.
//        합계 : 3개의 점수를 모두 더한 값
//        평균 : 합계 / 과목수 		[소수 첫째자리 까지 출력 ]
//        3배수 : 합계 값이 3의 배수이면 true 아니면 false
//        7배수 : 합계 값이 7의 배수이면 true 아니면 false
//        홀짝 : 합계 값이 홀수이면 홀수출력 아니면 짝수 출력
//        결과 : 합계가 65점이상이면 합계 아니면 탈락 출력
//        3. *(중요) 풀이코드에서 printf는 한번만 사용합니다.



        int 국어 = 89;
        int 수학 = 90;
        int 영어 = 77;

        int total = 국어 + 수학 + 영어;
        double mean = (double) total / 3;
        boolean b1 = total % 3 == 0 ? true : false;
        boolean b2 = total % 8 == 0 ? true : false;
        String s1 = total % 2 == 0 ? "짝수" : "홀수";
        String s2 = total >= 65 ? "합격" : "불합격";


        System.out.printf("========================================== \n"+
                "국어  영어  수학  합계  평균  3배수  8배수  합계값  결과 \n"+
                "%d    %d   %d    %d  %.0f   %b  %b   %s    %s  ",국어,수학,영어,total,mean,b1,b2,s1,s2);


    }
}
