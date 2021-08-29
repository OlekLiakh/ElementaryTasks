package projects.numberToString;

import projects.numberToString.converter.ConverterNumberToString;
import projects.numberToString.converter.ConverterNumberToStringRussian;

public class Main {
    public static void main(String[] args) {
        EnterParameters inputNumber = new EnterParameters(args);
        ConverterNumberToString converter = new ConverterNumberToStringRussian();
//        ConverterNumberToString converter = new ConverterNumberToStringEnglish();
        System.out.println(converter.convertNumberToString(inputNumber.getNumber()));

    }
}
