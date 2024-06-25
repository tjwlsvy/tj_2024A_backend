package 과제.stage1;

public class level6 {
    public static void main(String[] args) {

        short s = 30000;
        byte b1 = (byte) s;
        System.out.println("byte <- short : "+b1);

        int i = 2000000000;
        short s1 = (short) i;
        System.out.println("short <- int : "+s1);

        long l = 40000000000L;
        int i1 = (int)l;
        System.out.println("int <- long : "+i1);

        float f = 3.123123123F;
        long l1 = (long)f;
        System.out.println("long <- float : "+l1);

        double d = 3.123123123;
        float f1 = (float) d;
        System.out.println("float <- double : "+f1);




    }
}