package projects.numberToString;

import projects.numberToString.dictionary.Dictionary;
import projects.numberToString.dictionary.EnglishDictionary;

public class Main {
    public static void main(String[] args) {
        EnterParameters inputNumber = new EnterParameters(args);
        Dictionary dictionary = new EnglishDictionary();
        ConverterNumberToString converter = new ConverterNumberToString(inputNumber.getNumber(), dictionary);
        System.out.println(converter.convertNumberToString());
    }
}
