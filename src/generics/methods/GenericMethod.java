package generics.methods;

import java.util.Arrays;

public class GenericMethod {
    public static void main(String[] args) {

        Integer[] intArr = {2, 3, 8, 99, 55};
        Double[] doubleArr = {1.3, 35.6, 99.9, 0.5};
        String[] stringArr = {"Java", "generics", "hayatımızı", "kolaylaştırır"};

        printArr(intArr);
        printArr(doubleArr);
        printArr(stringArr);

        printArrGeneric(intArr);
        printArrGeneric(doubleArr);
        printArrGeneric(stringArr);

        System.out.println("getFirst(intArr) = " + getFirst(intArr));
        System.out.println("getFirst(intArr) = " + getFirst(doubleArr));
        System.out.println("getFirst(intArr) = " + getFirst(stringArr));



        System.out.println("---------------çok parametreli generic metod-----------");

        printArrAndElement(intArr,"AdvJava");//S:Integer , U: String
        printArrAndElement2(intArr,123);//T:Integer
    }





    //arrayleri yazdirmak icin method tanimlayalim

    public static void printArr(Integer[] arr) {
        Arrays.stream(arr).forEach(t -> System.out.print(t + " "));
        System.out.println();
    }

    public static void printArr(Double[] arr) {
        Arrays.stream(arr).forEach(t -> System.out.print(t + " "));
        System.out.println();
    }

    public static void printArr(String[] arr) {
        Arrays.stream(arr).forEach(t -> System.out.print(t + " "));
        System.out.println();
    }

    public static <T> void printArrGeneric(T[] arr) {
        Arrays.stream(arr).forEach(t -> System.out.print(t + " "));
        System.out.println();
    }

    public static <T> T getFirst(T[] arr) {
        T first = arr[0];
        return first;
    }


    public static <S, U> void printArrAndElement(S[] arr, U obj) {

        //arr[0]=obj;

        Arrays.stream(arr).forEach(t -> System.out.print(t + " "));
        System.out.println();
    }

    public static <T> void printArrAndElement2(T[] arr, T obj) {

          arr[0]=obj;

        Arrays.stream(arr).forEach(t -> System.out.print(t + " "));
        System.out.println();
    }

}
