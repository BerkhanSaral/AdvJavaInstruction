package generics.bounding;

public class Runner {
    public static void main(String[] args) {

        Integer[] integers={2,3,6,9,8,7};
        Double[] doubles={0.3,99.3,10.0,2.3};
        String[] strings={"generics","üstten","sınırlandıralabilir"};

        GenericUpperBound<Integer> obj1=new GenericUpperBound<>();//T:Integer
        obj1.numberArray=integers;


        System.out.println(obj1.countAverage());

        //GenericUpperBound<String> obj2=new GenericUpperBound<String>();

        GenericUpperBound<Double> obj3=new GenericUpperBound<>();//T:Integer



    }
}