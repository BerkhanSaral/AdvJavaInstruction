package threads.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//threadlerle calismak maliyetlidir
//maliyetle azaltmak icin thread havuzu olusturulur
public class ThreadPool {
    public static void main(String[] args) {

        //9 tane koli icin 9 tane kurye alalim:maliyet olur
        //az thread ile cok is
        ExecutorService service = Executors.newFixedThreadPool(4);//aktif olan sadece 4 thread

        Thread kurye1 = new ThreadCreator("A", 10000);
        Thread kurye2 = new ThreadCreator("B", 3000);
        Thread kurye3 = new ThreadCreator("C", 9000);
        Thread kurye4 = new ThreadCreator("D", 7000);
        Thread kurye5 = new ThreadCreator("E", 5000);
        Thread kurye6 = new ThreadCreator("F", 8000);
        Thread kurye7 = new ThreadCreator("G", 2000);
        Thread kurye8 = new ThreadCreator("H", 4000);
        Thread kurye9 = new ThreadCreator("K", 7000);

//        kurye1.start();
//        kurye2.start();
//        kurye3.start();
//        kurye4.start();
//        kurye5.start();
//        kurye6.start();
//        kurye7.start();
//        kurye8.start();
//        kurye9.start();

        service.execute(kurye1);
        service.execute(kurye2);
        service.execute(kurye3);
        service.execute(kurye4);
        service.execute(kurye5);
        service.execute(kurye6);
        service.execute(kurye7);
        service.execute(kurye8);
        service.execute(kurye9);
        service.shutdown();//havuzu sonlandirir, aksi halde threadler havuzda beklemeye devam eder
    }
}


class ThreadCreator extends Thread {

    public String task;

    public int duration;//threadlerin calisma suresini belirlemek icin

    //param const
    public ThreadCreator(String task, int duration) {
        this.task = task;
        this.duration = duration;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " ise basladi Gorev : " + this.task);
        System.out.println();
        //bazi kodlar calisiyormus gibi bekleticem
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " isini tamamladi");
        System.out.println();
    }
}
