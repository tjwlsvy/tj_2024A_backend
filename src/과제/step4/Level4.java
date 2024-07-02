package 과제.step4;

public class Level4 {
  public static void main(String[] args) {
    제품 a1 = new 제품(1, "아이폰" , 1000 , "2024-07-02");
    제품 s1 = new 제품(2, "갤럭시" , 2000 , "2024-07-20");

    System.out.println(a1.code+" "+a1.name+" "+a1.price+" "+a1.day);
    System.out.println(s1.code+" "+s1.name+" "+s1.price+" "+s1.day);
  }



}
