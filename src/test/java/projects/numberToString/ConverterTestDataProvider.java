package projects.numberToString;

import org.testng.annotations.DataProvider;

public class ConverterTestDataProvider {
    static final long maxValidNumber = ((long) Math.pow(10, 15)) - 1;
    static final long minValidNumber = (long) ((Math.pow(10, 15)) * -1 + 1);

    @DataProvider (name = "conditionsConverterTest")
    public static Object[][] dataProviderConverterTest(){
        return new Object[][] {
                {0, "����"},
                {8L, "������"},
                {21L,"�������� ����"},
                {143L, "��� ����� ���"},
                {12012L, "���������� ����� ����������"},
                {1031000L, "���� ������� �������� ���� ������"},
                {2042000L, "��� �������� ����� ��� ������"},
                {3053000L,"��� �������� ��������� ��� ������" },
                {5011000L, "���� ��������� ����������� �����"},
                {105065000L, "��� ���� ��������� ���������� ���� �����"},
                {1010100013L, "���� �������� ������ ��������� ��� ����� ����������"},
                {4576345213L, "������ ��������� ������� ��������� ����� ��������� " +
                                "������ ����� ���� ����� ������ ����������"},
                {6000100001L, "����� ���������� ��� ����� ����"},
                {104560090L, "��� ������ �������� ������� ���������� ����� ���������"},
                {1000000000L, "���� ��������"},
                {100100001001L, "��� ���������� ��� ��������� ���� ������ ����"},
                {maxValidNumber, "��������� ��������� ������ ���������� " +
                        "��������� ��������� ������ ���������� " +
                        "��������� ��������� ������ ��������� " +
                        "��������� ��������� ������ ����� " +
                        "��������� ��������� ������"},
                {minValidNumber, "����� ��������� ��������� ������ ���������� " +
                        "��������� ��������� ������ ���������� " +
                        "��������� ��������� ������ ��������� " +
                        "��������� ��������� ������ ����� " +
                        "��������� ��������� ������"}
        };
    }
}
