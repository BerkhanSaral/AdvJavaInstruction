package threads.multithreading;

public class DeadLock {
    public static void main(String[] args) {

        String sugar = "seker";
        String coffee = "kahve";

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Tom şekeri kullanmak istiyor.");
                synchronized (sugar){
                    System.out.println(Thread.currentThread().getName()+" "+sugar+" i kullanıyor...");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName()+" "+coffee+"yi kullanmak istiyor.");
                    synchronized (coffee){
                        System.out.println(Thread.currentThread().getName()+" "+coffee+"yi kullanıyor...");
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }//kahveyi bıraktı
                }//şekeri bıraktı
                System.out.println("Tom sıcak suyu ekledi, afiyetle kahvesini içiyor...");

            }
        });
        thread1.setName("Tom");

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Jerry kahveyi kullanmak istiyor.");
                synchronized (coffee){
                    System.out.println(Thread.currentThread().getName()+" "+coffee+" i kullanıyor...");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName()+" "+sugar+"yi kullanmak istiyor.");
                    synchronized (sugar){
                        System.out.println(Thread.currentThread().getName()+" "+sugar+"yi kullanıyor...");
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }//şekeri bıraktı
                }//kahveyi bıraktı
                System.out.println("Jerry sıcak suyu ekledi, afiyetle kahvesini içiyor...");

            }
        });
        thread2.setName("Jerry");

        thread1.start();
        thread2.start();
    }
}
