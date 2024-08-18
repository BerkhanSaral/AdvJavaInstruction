package threads;

public class ThreadCreationWays {
    public static void main(String[] args) {

        //her java programında default olarak 1 tane thread başlatılır:main thread
        System.out.println("Mevcut thread : "+Thread.currentThread().getName());


        //main threadi bir süre bekletelim(uyutalım)

//        try {
//            Thread.sleep(5000);//hangi threadin run metodu içinde yazarsak o thread uyur
//        } catch (InterruptedException e) {
//            System.out.println(e.getMessage());
//        }

        //Thread oluşturmanın ve başlatmanın 2 yolu var:
        //run metodunu override etmeliyiz
        //1.YOL
        Thread thread1=new MyThread();
        //thread1.run();-->thread başlatılmaz!!!
        thread1.start();//Threadi başlatır ve run metodunu çağırır.
        thread1.setName("threadcik:)");


        //2.YOL
        Runnable runnable=new MyRunnable();
        Thread thread2=new Thread(runnable);
        thread2.start();
        thread2.setName("threadman");

        //2.YOL : anonymous class : isimsiz sınıf
        //Runnable:functional interface-->sadece run metodu var
        Thread thread3=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);//thread3
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                //threade yaptırmak istediğimiz işlemleri(kodları)
                System.out.println("Çalışan thread : "+Thread.currentThread().getName());
                System.out.println("Anonim sınıf ile oluşturulan thread başladı..");
            }
        });
        thread3.start();
        thread3.setName("AliCan");



        //2.YOL: Runnable:functional interface --> lambda exp.
        Thread thread4=new Thread(()->{
            //run metodunun bodysindeyiz:)
            //threade yaptırmak istediğimiz işlemleri(kodları)
            System.out.println("Çalışan thread : "+Thread.currentThread().getName());
            System.out.println("Lambda exp ile oluşturulan thread başladı..");
        });

        //main threadi thread4 ü başlatmadan bir süre bekletelim(uyutalım)

//        try {
//            Thread.sleep(3000);//hangi threadin run metodu içinde yazarsak o thread uyur
//        } catch (InterruptedException e) {
//            System.out.println(e.getMessage());
//        }



        thread4.start();
        thread4.setName("threadwoman");


        //main threadi bir süre bekletelim(uyutalım)

        try {
            Thread.sleep(1000);//hangi threadin run metodu içinde yazarsak o thread uyur
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("main metod burada tamamlandı.");//main threadin görevi


        //NOT:her thread kendi işini(run metodu içindeki kodları) senkron (sıralı) çalıştırır
        //Threaler kendi arasında ASENKRON çalışır.
    }
}