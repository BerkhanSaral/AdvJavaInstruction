package threads.multithreading;


//wait-interrupt : thread arasında iletişimi sağlar.
//üretici(producer)-tüketici(consumer)
/*Bir öğrencinin banka hesabı için para yatırma(deposit) ve çekme işlemleri(withdraw) için uygulama
        Hesapta para yoksa para yatırılması(bakiyenin artması) beklensin.
        Bakiye artınca(yeterli olunca) para çekme gerçekleşsin.*/

//multi threading uygulamalarda bir threadin işini sürdürebilmesi için
//diğer bir threadin çalışması gerekiyorsa wait/notify veya wait/interrupt ile
//iletişim sağlanabilir
public class WaitInterrupt {

    public static int balance = 0;

    //para yatırma
    public synchronized void deposit(int amount) {
        System.out.println(Thread.currentThread().getName() + " para yatırmak istiyor.");
        balance += amount;
        System.out.println("Para yatırma işlemi başarılı, mevcut bakiye : " + balance);
    }

    //para çekme işlemi
    public synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " para çekmek istiyor.");
        //bakiye yetersiz ise
        if (balance == 0 || balance < amount) {
            System.out.println("Bakiye yetersiz!!! Mevcut bakiye : " + balance);
            //işleme devam edilemez, bekleyecek
            System.out.println("Bakiyenin güncellenmesi bekleniyor...");
            try {
                wait();//monitör edilen objeyi geçici olarak serbest bırakır
            } catch (InterruptedException e) {
                System.out.println("Bakiye guncellendi, isleme devam ediliyor");
            }
        }
        //kaldığı yerden işleme devam eder
        //bakiye güncellendi
        //bakiye yeterli ise
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Para çekme işlemi başarılı, mevcut bakiye : " + balance);
        } else {
            System.out.println("Bakiye yetersiz!!! Mevcut bakiye : " + balance);
            System.out.println("Umudunuu kaybetme, yarın gel:)");
        }

    }

    public static void main(String[] args) {

        WaitInterrupt obj = new WaitInterrupt();

        //para çekme ve yatırma işlemlerini 2 tane threade yaptıralım
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
                obj.deposit(2000);
                thread1.interrupt();//wait-sleep-join ile beklemekte olan thread`i kesintiye ugratir
            }
        });
        thread2.setName("Veli");
        thread2.start();
    }
}