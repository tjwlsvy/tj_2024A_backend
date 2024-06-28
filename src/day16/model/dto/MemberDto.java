package day16.model.dto;

public class MemberDto { // 이동객체
    // 1, 멤버변수 <--> DB필드와 동일 ,private 권장
    private String mid;             // 다른 패키지에서 사용할수없는 private이라는 String 타입의 mid변수 생성
    private String mpwd;            // 다른 패키지에서 사용할수없는 private이라는 String 타입의 mpwd변수 생성
    private String mname;           // 다른 패키지에서 사용할수없는 private이라는 String 타입의 mname변수 생성
    private String mphone;          // 다른 패키지에서 사용할수없는 private이라는 String 타입의 mphone변수 생성
    private String mdate;           // 다른 패키지에서 사용할수없는 private이라는 String 타입의 mdate변수 생성
    private int mno;                // 다른 패키지에서 사용할수없는 private이라는 String 타입의 mno변수 생성

    // 2. 생성자 : 기본생성자 , 풀생성자
    public MemberDto(){}
    // 어디든 접근이 가능한 public void라는 타입의 MemberDto()라는 생성자를 만든다.
    public MemberDto(String mid, String mpwd, String mname, String mphone, String mdate, int mno) {
        this.mid = mid;             // 현재 mid라는 매개변수를 mid라는 인스턴스변수에 저장/대입 한다.
        this.mpwd = mpwd;           // 현재 mpwd라는 매개변수를 mpwd라는 인스턴스변수에 저장/대입 한다.
        this.mname = mname;         // 현재 mname라는 매개변수를 mname라는 인스턴스변수에 저장/대입 한다.
        this.mphone = mphone;       // 현재 mphone라는 매개변수를 mphone라는 인스턴스변수에 저장/대입 한다.
        this.mdate = mdate;         // 현재 mdate라는 매개변수를 mdate라는 인스턴스변수에 저장/대입 한다.
        this.mno = mno;             // 현재 mno라는 매개변수를 mno라는 인스턴스변수에 저장/대입한다.
    }

    // -- 회원가입용 생성자를 만들고 각String타입의 mid ,mpwd , mname , mphone를 만든다.
    public MemberDto(String mid , String mpwd , String mname , String mphone){
        this.mid = mid;             // 현재 mid라는 매개변수를 mid라는 인스턴스변수에 저장/대입 한다.
        this.mpwd = mpwd;           // 현재 mpwd라는 매개변수를 mpwd라는 인스턴스변수에 저장/대입 한다.
        this.mname = mname;         // 현재 mname라는 매개변수를 mname라는 인스턴스변수에 저장/대입 한다.
        this.mphone = mphone;       // 현재 mphone라는 매개변수를 mphone라는 인스턴스변수에 저장/대입 한다.
    }

    // 메소드 : 1 getter / setter 2, toString

    @Override   // 상위클래스가 가지고 있는 메서드를 재정의 한다.
    public String toString() {  // toString 함수
        return "MemverDto{" +
                "mid='" + mid + '\'' +
                ", mpwd='" + mpwd + '\'' +
                ", mname='" + mname + '\'' +
                ", mphone='" + mphone + '\'' +
                ", mdate='" + mdate + '\'' +
                ", mno=" + mno +
                '}';
    }
    // getter and setter
    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMpwd() {
        return mpwd;
    }

    public void setMpwd(String mpwd) {
        this.mpwd = mpwd;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMphone() {
        return mphone;
    }

    public void setMphone(String mphone) {
        this.mphone = mphone;
    }

    public String getMdate() {
        return mdate;
    }

    public void setMdate(String mdate) {
        this.mdate = mdate;
    }

    public int getMno() {
        return mno;
    }

    public void setMno(int mno) {
        this.mno = mno;
    }
}
