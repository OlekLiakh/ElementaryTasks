package projects.numberToString;

import projects.numberToString.dictionary.Dictionary;

import java.util.HashMap;

public class ConverterNumberToString implements Messages {
    private final HashMap<Integer, String> dictionary;
    private long number;
    private final StringBuilder stringBuilder = new StringBuilder();

    public ConverterNumberToString(long number, Dictionary dictionary) {
        this.number = number;
        this.dictionary = dictionary.getDictionary();
    }

    public String convertNumberToString() {
        if (number < 0) {
            stringBuilder.append(MINUS).append(" ");
            number = Math.abs(number);
        }
        if (number >= Integer.MIN_VALUE && number <= Integer.MAX_VALUE) {
            if (dictionary.containsKey((int) number)) {
                stringBuilder.append(dictionary.get((int) number));
                return stringBuilder.toString();
            }
        }
        int trillion = (int) ((number / Math.pow(10, 12)));
        int billion = (int) ((number / Math.pow(10, 9))%1000);
        int million = (int) ((number / Math.pow(10, 6))%1000);
        int thousand = (int) ((number / Math.pow(10, 3))%1000);
        int hundreds = (int) (number % Math.pow(10, 3));

        if (trillion != 0) {
            buildString(trillion);
            stringBuilder.append(" ").append(TRILLION).append(" ");
        }
        if (billion != 0) {
                buildString(billion);
                stringBuilder.append(" ").append(BILLION).append(" ");
        }
        if (million != 0) {
                buildString(million);
                stringBuilder.append(" ").append(MILLION).append(" ");
        }
        if (thousand != 0) {
                buildString(thousand);
                stringBuilder.append(" ").append(THOUSAND).append(" ");
        }
        if (hundreds != 0) {
            buildString(hundreds);
        }
        return stringBuilder.toString();
    }

    private void buildString(int number) {
        stringBuilder.append(getHundreds(number));
        if ((stringBuilder.length() != 0) && (number % 100 != 0)) {
            stringBuilder
                    .append(AND)
                    .append(" ");
        }
        stringBuilder.append(getTens(number));
    }

    //110010101
    private String getHundreds(int number) {
        String hundredsString = "";
        if (number / 100 == 0) {
            return "";
        }
        hundredsString = dictionary.get(number / 100) + " " + HUNDRED + " ";
        return hundredsString;
    }

    private String getTens(int number) {
        int tens = number % 100;
        String tensString = "";
        if (tens == 0) {
            return tensString;
        }
        if (dictionary.containsKey(tens)) {
            tensString = dictionary.get(tens);
        } else {
            tensString = dictionary.get(tens / 10 * 10) + HYPHEN + dictionary.get(tens % 10);
        }
        return tensString;
    }
}