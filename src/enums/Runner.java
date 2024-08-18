package enums;

public class Runner {
    public static void main(String[] args) {

        printMessageForPasswordStrength("Low");

        //strength:LOW
        printMessageForPasswordStrength("LOW");

        //strength :MEDIUM
        printMessageForPasswordStrength("Medium");//CTE, RTE yok fakat istenen sonucu vermiyor.

        //strength :MEDIUM
        printMessageForPasswordStrength("Orta");

//ÇÖZÜM: metodun parametresini Enum Type olarak almak

        System.out.println("--------------------------------------------------");
        //strength:LOW
        printMessageForPasswordStrengthByEnums(PasswordStrengthEnum.LOW);

        //strength :MEDIUM
        printMessageForPasswordStrengthByEnums(PasswordStrengthEnum.MEDIUM);

        //printMessageForPasswordStrengthByEnums("yüksek seviye");-->CTE!!!


    }


//kullanıcının şifresinin seviyesi belirlendiğinde
//kullanıcıya mesaj gönderen bir metod yazalım.

    public static void printMessageForPasswordStrength(String strength){

        if (strength.equals(PasswordStrength.LOW)){
            System.out.println("Dikkat şifreniz yetersiz seviyededir!!!");
        } else if (strength.equals(PasswordStrength.MEDIUM)) {
            System.out.println("Şifre gücünüz orta düzeydedir.");
        } else if (strength.equals(PasswordStrength.HIGH)) {
            System.out.println("Tebrikler, şifre gücünüz yüksek düzeydedir:)");
        }

    }


    //aynı metodu enum type kullanarak yapalım
    public static void printMessageForPasswordStrengthByEnums(PasswordStrengthEnum strength){

        if (strength.equals(PasswordStrengthEnum.LOW)){
            // if (strength.ordinal()==0){
            System.out.println("Dikkat şifreniz yetersiz seviyededir!!!");
        } else if (strength.equals(PasswordStrengthEnum.MEDIUM)) {
            System.out.println("Şifre gücünüz orta düzeydedir.");
        } else if (strength.equals(PasswordStrengthEnum.HIGH)) {
            System.out.println("Tebrikler, şifre gücünüz yüksek düzeydedir:)");
        }

        System.out.println("Enum sırası : "+strength.ordinal());
        System.out.println("Enum ismi : "+strength.name());


    }




}