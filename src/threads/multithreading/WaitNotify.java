package threads.multithreading;

//wait-notify : thread arasında iletişimi sağlar.
//üretici(producer)-tüketici(consumer)
/*Bir öğrencinin banka hesabı için para yatırma(deposit) ve çekme işlemleri(withdraw) için uygulama
        Hesapta para yoksa para yatırılması(bakiyenin artması) beklensin.
        Bakiye artınca(yeterli olunca) para çekme gerçekleşsin.*/
public class WaitNotify {

    public static int balance = 0;


    //para yatirma
    public synchronized void deposit(int amount) {
        System.out.println(Thread.currentThread().getName() + " para yatirmak istiyor");
        balance += amount;
        System.out.println("Para yatirma islemi basarili, mevcut bakiye " + balance);
        notify();//wait methodu ile bekleyen threade bildirim gonderir
        //  notifyAll();//wait ile bekleyen tüm threadlere bildirim gönderir
    }

    //para cekme
    public synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " para cekmek istiyor");
        if (balance == 0 || balance < amount) {
            System.out.println("Yetersiz bakiye, Mevcut bakiye : " + balance);
            //isleme devam edilemez, bekleyecek
            System.out.println("Bakiyenin guncellenmesi bekleniyor");
            try {
                wait();//monitor edilen objeyi gecici olarak serbest birakir
                //notify() ile uyarilana kadar bekler
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //kaldigi yerden isleme devam eder
        //bakiye guncellendi
        //bakiye yeterliyse
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Para cekme islemi basarili, mevcut bakiye : " + balance);
        } else {
            System.out.println("Yetersiz bakiye, Mevcut bakiye : " + balance);
            System.out.println("Umudunu kaybetme, yarin gel");
        }
    }

    public static void main(String[] args) {

        WaitNotify obj = new WaitNotify();

        //para cekme ve yatima islemlerini 2 tane thread`e yaptiralim
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.withdraw(1000);
            }
        });
        thread1.setName("Ali Can");
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                obj.deposit(200);
            }
        });
        thread2.setName("Veli");
        thread2.start();
    }


}
