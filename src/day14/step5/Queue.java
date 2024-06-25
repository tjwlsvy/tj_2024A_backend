package day14.step5;

public interface Queue {        // queue 인터페이스 구현
    void enQueue(String title);
    String deQueue();
    int getSize();
}
