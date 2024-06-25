package day14.step3;

public class CustomerTest {
    public static void main(String[] args) {

        // 객체 생성
        Customer customer = new Customer();

        // Customer 타입이 Buy타입 변환(자동 타입변환)
        Buy buyer = customer;
        buyer.buy();
        buyer.order();

        // Customer타입 이 sell타입 변환(자동 타입변환)
        Sell seller = customer;
        seller.sell();
        seller.order();

        if (seller instanceof Customer){    // seller 타입이 customer 타입에 포함됨
            Customer customer2 = (Customer) seller;
            customer2.buy();
            customer2.sell();
        }
        customer.order();

    }

}
 // 추상메서드 : 동일한 목적하에 서로다른 기능수행을 함.




