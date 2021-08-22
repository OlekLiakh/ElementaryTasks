package projects.fibonacci;

import java.util.stream.Stream;

public class Fibonacci {
    public static void main(String[] args) {
        byStream(3);
        byArray(3);
    }

    private static void byStream(int digitLength) {
        //        100 ..... 1000
        long startRange = (long)(Math.pow(10,digitLength-1));
        long endRange = (long)(Math.pow(10,digitLength));;
        Stream.iterate(new Integer[]{0,1}, x -> new Integer[]{x[1], x[0]+x[1]})
                .filter(x -> ((startRange<=x[0])&&(x[0]<endRange)))
                .mapToLong(x->x[0])
                .forEach(System.out::println);
    }
    private static void byArray(int digitLength){

        long startRange = (long)(Math.pow(10,digitLength-1));
        long endRange = (long)(Math.pow(10,digitLength));;

        int [] array = {0,1};
        while (true){
            int temp = array[1];
            array[1] = array[0]+array[1];
            array[0]=temp;
        }
    }
}
