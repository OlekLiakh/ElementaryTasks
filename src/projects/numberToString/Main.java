package projects.numberToString;

import projects.numberToString.dictionary.Dictionary;
import projects.numberToString.dictionary.EnglishDictionary;

public class Main {
    public static void main(String[] args) {
        ParseStringToNumber inputNumber = new ParseStringToNumber(args);
        Dictionary dictionary = new EnglishDictionary();
        ConverterNumberToString converter = new ConverterNumberToString(inputNumber.getNumber(), dictionary);
        System.out.println(converter.convertNumberToString());
    }
}
