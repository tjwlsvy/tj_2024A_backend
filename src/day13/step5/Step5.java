package day13.step5;

class Car{
    Tire tire;  // 멤버변수
    public void run(){this.tire.roll();}    // 메소드 : tire에 roll메소드 호출
}
class Tire{     // 클래스 타이어에
    public void roll(){
        System.out.println("일반 타이어가 회전합니다.");
    }
}

class HankookTire extends  Tire{
    @Override
    public void roll() {
        System.out.println("한국타이어가 회전합니다.");
    }
}

class Kumhotire extends Tire{
    @Override
    public void roll() {
        System.out.println("금호 타이어가 회전합니다.");
    }
}





public class Step5 {
    public static void main(String[] args) {

        Car myCar = new Car();              // Car 객체를 생성합니다.
        // myCar.run();
        Car yourCar = new Car();            // 다른 Car 객체를 생성합니다.
        yourCar.tire = new Tire();          // yourCar의 타이어를 기본 Tire로 설정
        yourCar.run();                      // 메서드를 호출하여 "일반 타이어가 회전합니다."를 출력

        myCar.tire = new Tire();            //  myCar의 타이어를 HankookTire로 설정하고,
        myCar.run();                        // 메서드를 호출하여 "일반 타이어 회전합니다."를 출력

        myCar.tire = new HankookTire();
        myCar.run();

        myCar.tire = new Kumhotire();
        myCar.run();
        yourCar.run();

        System.out.println(myCar.tire instanceof Kumhotire);
        if (myCar.tire instanceof Tire){
            myCar.tire = new HankookTire();
        }
        myCar.run();






    }
}
