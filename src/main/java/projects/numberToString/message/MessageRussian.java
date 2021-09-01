package projects.numberToString.message;

import main.Message;

public class MessageRussian extends Message {
    private final String ENTER_VALUES = "Введите число";
    private final String INPUT_SCHEME = "Число должно быть в диапазоне +/-квадрилион";
    private final String INCORRECT_VALUE = "Введены неверные данные";
    private final String EXCEPTION = "Что-то пошло не так. Введите число снова.";
    private final String OUT_OF_RANGE = "Число не в пределах диапазоне";
    private final String MINUS = "минус";
    private final String TRILLION = "триллион";
    private final String BILLION = "миллиард";
    private final String MILLION = "миллион";

    @Override
    public String getENTER_VALUES() {
        return ENTER_VALUES;
    }

    @Override
    public String getINPUT_SCHEME() {
        return INPUT_SCHEME;
    }

    @Override
    public String getINCORRECT_VALUE() {
        return INCORRECT_VALUE;
    }

    @Override
    public String getEXCEPTION() {
        return EXCEPTION;
    }

    public String getOUT_OF_RANGE() {
        return OUT_OF_RANGE;
    }

    public String getMINUS() {
        return MINUS;
    }

    public String getTRILLION() {
        return TRILLION;
    }

    public String getBILLION() {
        return BILLION;
    }

    public String getMILLION() {
        return MILLION;
    }
}
