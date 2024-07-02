package 과제.step4;

public class Level2 {
  public static void main(String[] args) {
    방문록 a1 = new 방문록();
    a1.num = 10;
    a1.content = "안녕하세요";
    a1.date = "2024-01-01";
    a1.name = "유재석";

    방문록 b1 = new 방문록();
    b1.num = 1;
    b1.content = "반갑습니다.";
    b1.date = "2024-02-02";
    b1.name = "강호동";

    System.out.println(a1.num+a1.content+a1.date+ a1.name );
    System.out.println(b1.num+b1.content+b1.date+ b1.name );

  }







}
