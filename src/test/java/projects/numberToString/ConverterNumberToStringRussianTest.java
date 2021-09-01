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

    @Test (dataProvider = "conditionsConverterTest",
            dataProviderClass = ConverterTestDataProvider.class)
    public void testConvertNumberToStringValidParam(long number, String numberToString) {
        long digit = number;
        String expected =numberToString;

        String actualResult = converter.convertNumberToString(digit);

        assertEquals(actualResult, expected);
    }

}
