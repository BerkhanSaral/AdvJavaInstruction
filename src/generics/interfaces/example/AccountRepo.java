package generics.interfaces.example;

    //Customer icin veri tabani islemleri bu class da yapilacak
//interface code bakim icin kolay
    public class AccountRepo implements Repo <Account> {
        @Override
        public void save(Account obj) {

        }

        @Override
        public Account find() {
            return null;
        }


        //saveAccount(Account obj){


        //Account find
        //}


    }
