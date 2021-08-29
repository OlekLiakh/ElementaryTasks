package projects.numberToString.converter;

import projects.numberToString.message.MessagesRussian;
import projects.numberToString.ValidatorNumberToString;
import projects.numberToString.dictionary.Dictionary;
import projects.numberToString.dictionary.RussianDictionary;

public class ConverterNumberToStringRussian extends ConverterNumberToString implements MessagesRussian {

    private Dictionary dictionary = new RussianDictionary();
    private ValidatorNumberToString validator = new ValidatorNumberToString();

    public ConverterNumberToStringRussian() {
        super();
    }

    @Override
    public String convertNumberToString(long number) throws IllegalArgumentException{
        if(!validator.isDataValid(number)){
            throw new IllegalArgumentException (INCORRECT_VALUE);
        }
        if(number==0){
            return dictionary.getString(0);
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (number < 0) {
            stringBuilder.append(MINUS).append(" ");
            number = Math.abs(number);
        }
        int classTrillion = (int) (number / Math.pow(10, 12)); //0
        int classBillion = (int) (number / Math.pow(10, 9) % 1000); //0
        int classMillion = (int) (number / Math.pow(10, 6) % 1000); //110
        int classThousand = (int) (number / Math.pow(10, 3) % 1000); //010
        int classHundreds = (int) (number % Math.pow(10, 3)); //101

        stringBuilder.append(buildString(classTrillion, TRILLION));
        stringBuilder.append(buildString(classBillion, BILLION));
        stringBuilder.append(buildString(classMillion, MILLION));
        stringBuilder.append(buildStringThousand(classThousand));
        stringBuilder.append(buildString(classHundreds));

        if (stringBuilder.charAt(stringBuilder.length()-1)==' '){
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        return stringBuilder.toString();
    }

    private String buildString(int treeDigitNumber, String numberClass) {
        StringBuilder stringBuilder = new StringBuilder();
        if (treeDigitNumber != 0) {
            stringBuilder.append(buildString(treeDigitNumber));
            if (treeDigitNumber % 10 == 1) {
                if (treeDigitNumber % 100 != 11) {
                    stringBuilder.append(" ").append(numberClass);
                } else {
                    stringBuilder.append(" ").append(numberClass).append("ов");
                }
            } else if (treeDigitNumber % 10 == 2 || treeDigitNumber % 10 == 3 || treeDigitNumber % 10 == 4) {
                if (treeDigitNumber % 100 == 12 || treeDigitNumber % 100 == 13 || treeDigitNumber % 100 == 14) {
                    stringBuilder.append(" ").append(numberClass).append("ов");
                } else {
                    stringBuilder.append(" ").append(numberClass).append("а");
                }
            } else {
                stringBuilder.append(" ").append(numberClass).append("ов");
            }
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    private String buildStringThousand(int treeDigitNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        if (treeDigitNumber != 0) {
            stringBuilder.append(buildString(treeDigitNumber));
            if (treeDigitNumber % 10 == 1) {
                if (treeDigitNumber % 100 != 11) {
                    stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length())
                            .append("на").append(" ").append("тыс€ча");
                } else {
                    stringBuilder.append(" ").append("тыс€ч");
                }
            } else if (treeDigitNumber % 10 == 2 || treeDigitNumber % 10 == 3 || treeDigitNumber % 10 == 4) {
                if (treeDigitNumber % 100 != 12 && treeDigitNumber % 100 != 13 && treeDigitNumber % 100 != 14) {
                    if (treeDigitNumber % 10 == 2) {
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1)
                                .append("е").append(" ").append("тыс€чи");
                    } else {
                        stringBuilder.append(" ").append("тыс€чи");
                    }
                }
//                else {
//                    stringBuilder.append(" ").append("тыс€ч");
//                }
            } else {
                stringBuilder.append(" ").append("тыс€ч");
            }
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    private String buildString(int treeDigitNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(convertHundreds(treeDigitNumber));
        if(treeDigitNumber / 100!=0 && treeDigitNumber % 100!=0){
            stringBuilder.append(" ");
        }
        stringBuilder.append(convertTensAndUnits(treeDigitNumber));
        return stringBuilder.toString();
    }

    private String convertHundreds(int treeDigitNumber) {
        int hundredDigit = treeDigitNumber / 100 * 100;
        if (hundredDigit == 0) {
            return "";
        }
        String hundredsString = dictionary.getString(hundredDigit);
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
        String tensString = dictionary.getString(tens) + " " + dictionary.getString(units);
        return tensString;
    }
}