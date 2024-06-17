package day07.Step2;

public class step2 {
    public static void main(String[] args) {


        Student studentLee = new Student();
        // studentLee.studentName = "이상원";
        studentLee.setStudentName("이상원");

        studentLee.grade = 3;

        System.out.println(studentLee.getStudentName());



    }
}
