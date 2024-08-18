package generics.bounding;


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

//wildcard(?): joker, bilinmeyen data tipi
//generic yapıları kullanırken alttan veya üstten sınırlama yapılabilir.
public class GenericWithWildcard {
    public static void main(String[] args) {

        List<Integer> integers=new ArrayList<>();
        List<Double> doubles=new ArrayList<>();
        List<String> strings=new ArrayList<>();
        List<Number> numbers=new ArrayList<>();
        List<Object> objects=new ArrayList<>();

        addElements(integers);
        //addElements(doubles);
        addElements(numbers);
        addElements(objects);

        multiplyByTwo(integers);
        multiplyByTwo(doubles);
        multiplyByTwo(numbers);
        //multiplyByTwo(objects);

    }

    //generic yapıyı kullanırken alttan sınırlama
    //listeye 1 den 10 a kadar tam sayıları ekleyen bir metod yazalım
    //list--> ?: Integer, Number, Object
    public static void addElements(List<? super Integer> list){

        for (int i=1;i<11;i++){
            list.add(i);
        }

    }

    //generic yapıyı kullanırken üstten sınırlama
    //listedeki elemanları 2 ile çarpan bir metod yazalım
    //list --> ? : number ve childlari
    public static void multiplyByTwo(List<? extends Number> list){

        list.stream().map(t->2*t.doubleValue());

    }


}
