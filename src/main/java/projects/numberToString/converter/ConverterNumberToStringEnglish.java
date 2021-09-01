package projects.numberToString.converter;

import projects.numberToString.message.MessagesEnglish;
import projects.numberToString.ValidatorNumberToString;
import projects.numberToString.converter.dictionary.Dictionary;
import projects.numberToString.converter.dictionary.EnglishDictionary;

public class ConverterNumberToStringEnglish extends ConverterNumberToString implements MessagesEnglish {
    private ValidatorNumberToString validator = new ValidatorNumberToString();
    private Dictionary dictionary = new EnglishDictionary();
    private final StringBuilder stringBuilder = new StringBuilder();

    public ConverterNumberToStringEnglish() {
        super();
    }

    @Override
    public String convertNumberToString(long number)  throws IllegalArgumentException {
        if(!validator.isDataValid(number)){
            throw new IllegalArgumentException (INCORRECT_VALUE);
        }
        if (number < 0) {
            stringBuilder.append(MINUS).append(" ");
            number = Math.abs(number);
        }
        int classTrillion = (int) (number / Math.pow(10, 12));
        int classBillion = (int) (number / Math.pow(10, 9)) % 1000;
        int classMillion = (int) (number / Math.pow(10, 6)) % 1000;
        int classThousand = (int) (number / Math.pow(10, 3)) % 1000;
        int classHundreds = (int) (number % Math.pow(10, 3));

        buildString(classTrillion, TRILLION);
        buildString(classBillion, BILLION);
        buildString(classMillion, MILLION);
        buildString(classThousand, THOUSAND);
        buildString(classHundreds);

        return stringBuilder.toString();
    }

    protected void buildString(int treeDigitNumber, String numberClass) {
        if (treeDigitNumber != 0) {
            buildString(treeDigitNumber);
            stringBuilder.append(" ").append(numberClass).append(" ");
        }
    }

    private void buildString(int treeDigitNumber) {
        stringBuilder.append(convertHundreds(treeDigitNumber));
        stringBuilder.append(convertTensAndUnits(treeDigitNumber));
    }

    protected String convertHundreds(int treeDigitNumber) {
        int hundredDigit = treeDigitNumber / 100;
        if (hundredDigit == 0) {
            return "";
        }
        String hundredsString = dictionary.getString(hundredDigit) + " " + HUNDRED + " ";
        return hundredsString;
    }

    protected String convertTensAndUnits(int treeDigitNumber) {
        int twoDigitNumber = treeDigitNumber % 100;
        if (twoDigitNumber == 0) {
            return "";
        }
        if (dictionary.containsNumber(twoDigitNumber)) {
            return dictionary.getString(twoDigitNumber);
        }
        int units = twoDigitNumber % 10;
        int tens = twoDigitNumber - units;
        String tensString = dictionary.getString(tens) + HYPHEN + dictionary.getString(units);
        return tensString;
    }
}