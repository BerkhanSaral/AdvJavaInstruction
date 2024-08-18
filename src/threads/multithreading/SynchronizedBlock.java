package threads.multithreading;

public class SynchronizedBlock {

    //TASK: Ekrana 14 satırda [ [ [ [ [ ] ] ] ] ]
    //bu taski 2 tane threade yaptıralım

    public static void main(String[] args) {

        Brackets brackets=new Brackets();

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i=1;i<=7;i++){
                    brackets.printBrackets();
                }

            }
        });
        thread1.setName("Barnie");

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i=1;i<=7;i++){
                    brackets.printBrackets();
                }
            }
        });
        thread2.setName("Fred");

        thread1.start();
        thread2.start();



    }

}

class Brackets{

    //parantez desenini oluşturan bir metod yazalım
    public /*synchronized*/ void printBrackets(){

        //bir thread obje(this) ile bu bloğa eriştiğinde başka thread bu objeyi kullanmasın
        synchronized (this) {
            for (int i = 1; i < 11; i++) {
                if (i < 6) {
                    System.out.print("[ ");
                } else {
                    System.out.print("] ");
                }
            }
            System.out.println("-------> " + Thread.currentThread().getName());
        }

        //senkron olması gerekmeyen başka kodlar
        for (int i=1;i<=5;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }



}
