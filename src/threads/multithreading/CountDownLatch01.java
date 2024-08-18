package threads.multithreading;
/*
bazı threadlerin main thread ve diğer threadlerden önce çalışmasını ve işini
tamamladıktan sonra diğer threadlerin kaldığı yerden devam etmesini istediğimizde
CountDownLatch classının metodları ile öncelik vermek istediğimiz
threadlerin(worker threads) sayısı kadar bir sayaç başlatıp sayaç 0 olana kadar
diğer threadler bekletilebilir.
 */

import java.util.concurrent.CountDownLatch;

public class CountDownLatch01 {
    public static void main(String[] args) {

        System.out.println("Burada main thread çalışmaya başladı.");

        CountDownLatch latch=new CountDownLatch(3);

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" burada çalışmaya başladı...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                //bu threadin workerthreadlerin işi bitene kadar beklemesi gerekiyor.
                try {
                    latch.await();//sayac 0 olana kadar threadi bekletir
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+" tekrar çalışmaya devam ediyor.");

            }
        });
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                //hiç başlamadan workerları beklesin
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+" çalışmaya yeni başladı...");
            }
        });
        thread2.start();

        WorkerThreads worker1=new WorkerThreads("worker1",5000,latch);
        WorkerThreads worker2=new WorkerThreads("worker2",3000,latch);
        WorkerThreads worker3=new WorkerThreads("worker3",4000,latch);
        worker1.start();
        worker2.start();
        worker3.start();

        System.out.println("main thread workerlari bekliyor");
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main thread calismaya devam ediyor");




    }

}

class WorkerThreads extends Thread{

    public int duration;
    public CountDownLatch latch;

    //param const

    public WorkerThreads(String name, int duration, CountDownLatch latch) {
        super(name);
        this.duration = duration;
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" çalışmaya başladı....");
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+" çalışmasını tamamladı....");
        latch.countDown();//sayacı bir azaltır

    }
}
