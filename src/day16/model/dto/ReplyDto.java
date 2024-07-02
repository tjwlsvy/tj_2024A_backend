package day16.model.dto;

public class ReplyDto {
  // DTO : 저장 , Data TransFer Object
  // MVC 패턴에서의 역할 : 각 구역별(view , controller , dao) 데이터 변수들을 묶어서 구역간 이동하는 객체
    // 1. 멤버변수는 private , 2. 생성자 : 빈 생성자 , 풀생성자 +n개 3. 메소드 getter and setter , toString()

  // 1. 멤버변수
  private String rcontent;
  private String  rdate;
  private int mno;
  private int bno;
  private int rno;
  // + 작성자 아이디 추가
  private String mid;

  public String getMid() {
    return mid;
  }

  public void setMid(String mid) {
    this.mid = mid;
  }

  // 2. 생성자
  public ReplyDto(){}
  public ReplyDto(String rcontent, String rdate, int mno, int bno, int rno) {
    this.rcontent = rcontent;
    this.rdate = rdate;
    this.mno = mno;
    this.bno = bno;
    this.rno = rno;
  }
  // 3. getter and setter
  public String getRcontent() {
    return rcontent;
  }

  public void setRcontent(String rcontent) {
    this.rcontent = rcontent;
  }

  public String getRdate() {
    return rdate;
  }

  public void setRdate(String rdate) {
    this.rdate = rdate;
  }

  public int getMno() {
    return mno;
  }

  public void setMno(int mno) {
    this.mno = mno;
  }

  public int getBno() {
    return bno;
  }

  public void setBno(int bno) {
    this.bno = bno;
  }

  public int getRno() {
    return rno;
  }

  public void setRno(int rno) {
    this.rno = rno;
  }
  // 4. toString()
  @Override
  public String toString() {
    return "ReplyDto{" +
            "rcontent='" + rcontent + '\'' +
            ", rdate='" + rdate + '\'' +
            ", mno=" + mno +
            ", bno=" + bno +
            ", rno=" + rno +
            '}';
  }

}




