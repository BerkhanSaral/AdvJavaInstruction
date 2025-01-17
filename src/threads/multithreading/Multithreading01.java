package threads.multithreading;

public class Multithreading01 {
    public static void main(String[] args) {

        //TASK: 1 den 10 a 2 defa kadar sayalım:main thread
        long start=System.currentTimeMillis();
        Counter counter1=new Counter("Arda");
        Counter counter2=new Counter("Berkhan");
        counter1.count();
        counter2.count();
        long finish=System.currentTimeMillis();

        System.out.println("Thread olmadan geçen süre : "+(finish-start));//10247


        //------------------------------------------------------------------------------

        //TASK: 1 den 10 a 2 defa kadar sayalım:multithreading
        long start2=System.currentTimeMillis();//+
        Thread thread1=new CounterThread("Sümeyya");
        Thread thread2=new CounterThread("Hatice");
        thread1.start();
        thread2.start();

        //main threadin thread1 ve thread2 işini bitirene kadar beklemeli

        try {
            thread1.join();//thread1 işini bitirene kadar main thread bekler
            thread2.join();//thread2 işini bitirene kadar main thread bekler
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long finish2=System.currentTimeMillis();

        System.out.println("Multithreading ile geçen süre : "+(finish2-start2));//5131



    }
}

class Counter{

    public String name;

    //param const
    public Counter(String name) {
        this.name = name;
    }

    //1 den 10 a kadar console a yazdıralım
    public void count(){

        for (int i=1; i<11;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i + " - "+this.name);
        }

    }


}

//aynı taski multithreading uygulamayla yapalım
class CounterThread extends Thread{

    public String name;

    public CounterThread(String name){
        this.name=name;
    }

    //1 den 10 a kadar console a yazdıralım
    public void count(){

        for (int i=1; i<11;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i + " - "+this.name);
        }

    }

    //run metodunu override: sayma işlemini threadlere verelim
    @Override
    public void run() {
        count();
    }
}