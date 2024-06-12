package day02;

public class Step2 {
    public static void main(String[] args) {

        // 형변환 : 자료형 변경
        // 1. 묵시적/자동 형 변환 :
            // 1. 메모리 크기가 작은것부터 큰 순으로
            // 2. 데아터 손실이 없다
            // byte -> shot -> int ->long -> float -> double

        byte byteValue = 10;    // byte(1바이트) 상자에 'byteValue' 이라는 이름으로 변수에 10 대입/저장
        int intValue = byteValue;   // byte(1바이트) -> int(4바이트) : 묵시적 형 변환
        System.out.println("intValue = " + intValue);

        char charValue = '가'; // char(2바이트) 상자에 'charValue' 이라는 이름으로 변수에 '가' 대입/저장
        intValue = charValue;   // char(2바이트) --> int(4바이트) : 묵시적 형 변환
        System.out.println("intValue = " + intValue);

        intValue = 50;  // int(4바이트)
        long longValue = intValue;  // int(4바이트 --> long(8바이트) : 묵시적 형 변화
        System.out.println("longValue = " + longValue);

        longValue = 100;
        float floatValue = longValue; // long(8바이트) --> float(4바이트) : 묵시적 형 변환 (부동소수점의 표현 단위 더 크기때문에)
        System.out.println("floatValue = " + floatValue);

        floatValue =100.5f;
        double doubleValue = floatValue; // float(4바이트) --> double(8바이트) : 묵시적 형 변환
        System.out.println("doubleValue = " + doubleValue);

        // - 연산중에 묵시적 형변환
        // 1. byte , shot => int
        // 2. int , int => int
        // 3. long int => long
        // 4. float , float => float
        // 5. double , float => double

        byte b1 = 30; byte b2 = 20;
        int result1 = b1+b2; // byte + byte => int , result1 자료형은 int 이다

        byte b3 = 30; long l1 = 100;
        long result2 = b3 + l1 ; // byte + long +> long

        char c1 = 'A'; char c2 = 'B';
        int result3 = c1+c2;    //char + char => int

        int i1 = 10; double d1 = 4.0; // int + double => double
        double result4 = i1+d1;

        // 2. 명시적/강제 형 변환
            // 1. 메모리 크기가 큰것부터 작은순으로 변환
            // 2. 데이터 손실이 있을수도 있다.
            // (변환할자료형)변수명
            // byte <- shot <- int <- long <- float <- double

        int intValue2 =10;
        // byte byteValue2 = intValue2;    // 오류 : 4바이트를 1바이트에 저장할수 없음.
        byte byteValue2 = (byte) intValue2;
        System.out.println("byteValue2 = " + byteValue2);

        long longValue2 = 300;
        int intValue3 = (int) longValue2; // 강제형변환 : 데이터 크기에 따라 데이터 손실이 있을수 있음.
        System.out.println("intValue3 = " + intValue3);

        int intValue4 = 65;
        char charValue2 = (char) intValue4;
        System.out.println("charValue2 = " + charValue2);

        double doubleValue2 =3.14;
        int intValue5 = (int) doubleValue2;     // 강제형변환
        System.out.println("intValue5 = " + intValue5);

        char ch1 = 'A';
        int intValue6 = ch1;    // 자동형변환
        System.out.println("intValue6 = " + intValue6);

        int ch2 = 67;
        char charValue6 = (char) ch1;  // 강제형변환
        System.out.println("charValue6 = " + charValue6);

        int value1 = 10; double value2 = 2.0;
        int result = (int) (value1 + value2);
            // int = double (오류)
            // int = (int)double
        System.out.println("result = " + result);

        char char1 = '글';
        System.out.println("char1 = " + char1);


    }
}
