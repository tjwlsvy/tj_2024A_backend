package day14.step3;

public interface Buy {
    // 추상 메소드
    void buy();

    default void order(){
        System.out.println("구매주문");
    }
}
