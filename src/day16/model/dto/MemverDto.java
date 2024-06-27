package day16.model.dto;

public class MemverDto { // 이동객체
    // 1, 멤버변수 <--> DB필드와 동일 ,private 권장
    private String mid;
    private String mpwd;
    private String mname;
    private String mphone;
    private String mdate;
    private int mno;

    // 2. 생성자 : 기본생성자 , 풀생성자
    public MemverDto(){}

    public MemverDto(String mid, String mpwd, String mname, String mphone, String mdate, int mno) {
        this.mid = mid;
        this.mpwd = mpwd;
        this.mname = mname;
        this.mphone = mphone;
        this.mdate = mdate;
        this.mno = mno;
    }
    // -- 회원가입용 생성자
    public MemverDto(String mid , String mpwd , String mname , String mphone){
        this.mid = mid;
        this.mpwd = mpwd;
        this.mname = mname;
        this.mphone = mphone;
    }
    // 메소드 : 1 getter / setter 2, toString


    @Override
    public String toString() {
        return "MemverDto{" +
                "mid='" + mid + '\'' +
                ", mpwd='" + mpwd + '\'' +
                ", mname='" + mname + '\'' +
                ", mphone='" + mphone + '\'' +
                ", mdate='" + mdate + '\'' +
                ", mno=" + mno +
                '}';
    }

    public int getMno() {
        return mno;
    }

    public void setMno(int mno) {
        this.mno = mno;
    }

    public String getMdate() {
        return mdate;
    }

    public void setMdate(String mdate) {
        this.mdate = mdate;
    }

    public String getMphone() {
        return mphone;
    }

    public void setMphone(String mphone) {
        this.mphone = mphone;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String manme) {
        this.mname = manme;
    }

    public String getMpwd() {
        return mpwd;
    }

    public void setMpwd(String mpwd) {
        this.mpwd = mpwd;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }
}
