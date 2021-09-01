package projects.numberToString.message;

import main.Message;

public class MessageRussian extends Message {
    private final String ENTER_VALUES = "������� �����";
    private final String INPUT_SCHEME = "����� ������ ���� � ��������� +/-����������";
    private final String INCORRECT_VALUE = "������� �������� ������";
    private final String EXCEPTION = "���-�� ����� �� ���. ������� ����� �����.";
    private final String OUT_OF_RANGE = "����� �� � �������� ���������";
    private final String MINUS = "�����";
    private final String TRILLION = "��������";
    private final String BILLION = "��������";
    private final String MILLION = "�������";

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
