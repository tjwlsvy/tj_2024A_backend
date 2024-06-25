package day14.step3;

public class Customer implements Buy,Sell{
    @Override
    public void buy() {
        System.out.println("판매하기");
    }

    @Override
    public void sell() {
        System.out.println("구매하기");
    }

    @Override
    public void order() {
        Buy.super.order();
        System.out.println("고객판매주문");
    }
}
