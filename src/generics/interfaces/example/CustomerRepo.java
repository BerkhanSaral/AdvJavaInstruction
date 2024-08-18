package generics.interfaces.example;

//Customer icin veri tabani islemleri bu class da yapilacak
public class CustomerRepo implements  Repo<Customer>{
    @Override
    public void save(Customer obj) {

    }

    @Override
    public Customer find() {
        return null;
    }

    //save(Customer obj){
    // insert into ...}

    //customer findCustomer

}
