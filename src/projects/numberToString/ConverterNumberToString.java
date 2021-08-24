package projects.numberToString;

import projects.numberToString.dictionary.Dictionary;

public class ConverterNumberToString implements MessagesEnglish {
    private Dictionary dictionary;
    private long number;
    private final StringBuilder stringBuilder = new StringBuilder();

    public ConverterNumberToString(long number, Dictionary dictionary) {
        this.number = number;
        this.dictionary = dictionary;
    }

    public String convertNumberToString() {
        if (number < 0) {
            stringBuilder.append(MINUS).append(" ");
            number = Math.abs(number);
        }
        //110010101
        int classTrillion = (int) (number / Math.pow(10, 12)); //0
        int classBillion = (int) (number / Math.pow(10, 9)) % 1000; //0
        int classMillion = (int) (number / Math.pow(10, 6)) % 1000; //110
        int classThousand = (int) (number / Math.pow(10, 3)) % 1000; //010
        int classHundreds = (int) (number % Math.pow(10, 3)); //101

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

    private String convertHundreds(int treeDigitNumber) {
        int hundredDigit = treeDigitNumber / 100;
        if (hundredDigit == 0) {
            return "";
        }
        String hundredsString = dictionary.getString(hundredDigit) + " " + HUNDRED + " ";
        return hundredsString;
    }

    private String convertTensAndUnits(int treeDigitNumber) {
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