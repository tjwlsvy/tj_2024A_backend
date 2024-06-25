package day14.step4;

public class MyClassTest {
    public static void main(String[] args) {

        MyClass mClass = new MyClass();         // MyClass 생성자를 만듬
        X xClass = mClass;                      // mClass를 xclass 대입
        xClass.x();                             // xclass 출력하면 x가 나옴

        Y yClass = mClass;                      // yclass에 mclass 대입
        yClass.y();                             // yclass 출력하면 y가 나옴

        MyInterface iClass = mClass;            //
        iClass.myMethod();                      //
        iClass.x();
        iClass.y();
    }
}
