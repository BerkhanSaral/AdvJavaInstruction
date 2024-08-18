package generics.interfaces.example;

//bu uygulmadaki tüm repolarin uymasi gereken kurallar var
public interface Repo <T> {

    //save
    void save(T obj);


    //find
    T find();


}
