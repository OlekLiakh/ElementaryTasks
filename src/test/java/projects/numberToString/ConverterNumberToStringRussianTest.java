package projects.numberToString;

import org.testng.annotations.Test;
import projects.numberToString.converter.ConverterNumberToStringRussian;

import static org.testng.Assert.assertEquals;

public class ConverterNumberToStringRussianTest {
    ConverterNumberToStringRussian converter = new ConverterNumberToStringRussian();

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void testConvertNumber_NumberMoreThanValid_IllegalArgumentException() {
        long maxInputValue = (long) Math.pow(10, 15);

        converter.convertNumberToString(maxInputValue);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void testConvertNumber_NumberLessThanValid_IllegalArgumentException() {
        long lessThanValidValue = (long) Math.pow(10, 15) * -1;

        converter.convertNumberToString(lessThanValidValue);
    }

    @Test
    public void testConvertNumberToStringZero() {
        long digit = 0;
        String expected = "ноль";

        String actualResult = converter.convertNumberToString(digit);

        assertEquals(actualResult, expected);
    }

    @Test
    public void testConvertNumberToStringOneDigit() {
        long digit = 8L;
        String expected = "восемь";

        String actualResult = converter.convertNumberToString(digit);

        assertEquals(actualResult, expected);
    }

    @Test
    public void testConvertNumberToStringTwoDigitNumber() {
        long digit = 21L;
        String expected = "двадцать один";

        String actualResult = converter.convertNumberToString(digit);

        assertEquals(actualResult, expected);
    }

    @Test
    public void testConvertNumberToStringThreeDigitNumber() {
        long digit = 143L;
        String expected = "сто сорок три";

        String actualResult = converter.convertNumberToString(digit);

        assertEquals(actualResult, expected);
    }

    @Test
    public void testConvertNumberToString_TwelveThousandTwelve() {
        long digit = 12012L;
        String expected = "двенадцать тысяч двенадцать";

        String actualResult = converter.convertNumberToString(digit);

        assertEquals(actualResult, expected);
    }

    @Test
    public void testConvertNumberToString_OneMillion_Thousands_TwoDigitNumberEndsOnOne_NotEleven() {
        long digit = 1031000L;
        String expected = "один миллион тридцать одна тысяча";

        String actualResult = converter.convertNumberToString(digit);

        assertEquals(actualResult, expected);
    }

    @Test
    public void ConvertNumberToString_TwoMillion_Thousand_TwoDigitNumberEndsOnTwo_NotTwelve() {
        long digit = 2042000L;
        String expected = "два миллиона сорок две тысячи";

        String actualResult = converter.convertNumberToString(digit);

        assertEquals(actualResult, expected);
    }

    @Test
    public void testConvertNumberToString_ThreeMillion_Thousand_TwoDigitNumberEndsOnThreeOrFour_NotThirteenAndFourteen() {
        long digit = 3053000L;
        String expected = "три миллиона пятьдесят три тысячи";

        String actualResult = converter.convertNumberToString(digit);

        assertEquals(actualResult, expected);
    }

    @Test
    public void testConvertNumberToString_FiveMillion_Thousands_NumbersFromElevenToTwenty() {
        long digit = 5011000L;
        String expected = "пять миллионов одиннадцать тысяч";

        String actualResult = converter.convertNumberToString(digit);

        assertEquals(actualResult, expected);
    }

    @Test
    public void testConvertNumberToStringTwentyOneHundredFiveMillion_Thousands_TwoDigitNumberEndsOnMoreThanFour() {
        long digit = 105065000L;
        String expected = "сто пять миллионов шестьдесят пять тысяч";

        String actualResult = converter.convertNumberToString(digit);

        assertEquals(actualResult, expected);
    }

    @Test
    public void testConvertNumberToString_Billion_OneHundred_Thousand() {
        long digit = 1010100013L;
        String expected = "один миллиард десять миллионов сто тысяч тринадцать";

        String actualResult = converter.convertNumberToString(digit);

        assertEquals(actualResult, expected);
    }

    @Test
    public void testConvertNumberToString_SixBillionOneHundredThousandOne() {
        long digit = 6000100001L;
        String expected = "шесть миллиардов сто тысяч один";

        String actualResult = converter.convertNumberToString(digit);

        assertEquals(actualResult, expected);
    }

    @Test
    public void testConvertNumberToString_10456090() {
        long digit = 104560090L;
        String expected = "сто четыре миллиона пятьсот шестьдесят тысяч девяносто";

        String actualResult = converter.convertNumberToString(digit);

        assertEquals(actualResult, expected);
    }

    @Test
    public void testConvertNumberToString_100100001001() {
        long digit = 100100001001L;
        String expected = "сто миллиардов сто миллионов одна тысяча один";

        String actualResult = converter.convertNumberToString(digit);

        assertEquals(actualResult, expected);
    }

    @Test
    public void testConvertNumber_MaxNumber() {
        long maxNumber = ((long) Math.pow(10, 15)) - 1;
        String expected = "девятьсот девяносто девять триллионов " +
                "девятьсот девяносто девять миллиардов " +
                "девятьсот девяносто девять миллионов " +
                "девятьсот девяносто девять тысяч " +
                "девятьсот девяносто девять";

        String actualResult = converter.convertNumberToString(maxNumber);

        assertEquals(actualResult, expected);

    }

    @Test
    public void testConvertNumber_MinNumber() {
        long minNumber = (long) ((Math.pow(10, 15)) * -1 + 1);
        String expected = "минус девятьсот девяносто девять триллионов " +
                "девятьсот девяносто девять миллиардов " +
                "девятьсот девяносто девять миллионов " +
                "девятьсот девяносто девять тысяч " +
                "девятьсот девяносто девять";

        String actualResult = converter.convertNumberToString(minNumber);

        assertEquals(actualResult, expected);
    }
}
