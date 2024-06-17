package day06.Step7.Step3;

public class Account {

    // 멤버변수/필드선언
    private int balance;
    private String number;

    // 생성자
        // 1. 디폴트생성자
    public Account(){}
        // 2. 매개변수 2개를 갖는 생성자
    Account(int balance , String number){
        this.balance = balance;
        this.number = number;
    }
    // 메소드
        // getter , setter


    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
