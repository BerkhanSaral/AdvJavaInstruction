package threads.multithreading;

public class Volatile01 {

    public  static volatile int flag = 0;// her cekirdek kendi on bellegini alirsa
    //volatile: sadece degiskenin degerinin main memorye yazilmasini ve buradan okunmasini garanti eder

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag == 0) {
                    System.out.println("Bu sadece bir RISK");
                }
            }
        });
        thread1.start(); //CPU 1: flag=0

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                flag=1;
                System.out.println("Flag degiskeninin degeri degisti");
            }
        });
        thread2.start(); //CPU 2: flag:1 fakat CPU 1(thread1)`in bundan haberi yok
    }
}
