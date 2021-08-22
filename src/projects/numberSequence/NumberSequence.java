package projects.numberSequence;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberSequence {
    public static void main(String[] args) {

        long stringLength = 10L;
        Double enteredNumbersSquare = 36D;

        double number = Math.sqrt(enteredNumbersSquare);
        long startNumber;
        if (enteredNumbersSquare.equals(Math.pow((long) number, 2))) {
            startNumber = (long) number;
        } else {
            startNumber = (long) number + 1;
        }

        String result = Stream.iterate(startNumber, m->m+1)
                .limit(stringLength)
                .map(x -> x.toString()+", ")
                .collect(Collectors.joining());
        result = result.substring(0,result.length()-2);

//        Output
        System.out.println(result);
    }
}