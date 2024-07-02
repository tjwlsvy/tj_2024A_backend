package 과제.step4;

public class Level3 {
  public static void main(String[] args) {

  회원 m1 = new 회원();

  m1.num = 1;
  m1.id = "dbwotjr";
  m1.pw = "1234";
  m1.name = "유재석";

  회원 s2 = new 회원();
  s2.num = 10;
  s2.id = "rkdghehd";
  s2.pw = "5678";
  s2.name = "강호동";

    System.out.println(m1.num+ " "+m1.id+" "+m1.pw+" "+m1.name);
    System.out.println(s2.num+ " "+s2.id+" "+s2.pw+" "+s2.name);

  }
}
