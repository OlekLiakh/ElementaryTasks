package projects.numberToString;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ValidatorNumberToStringTest {
    ValidatorNumberToString validator = new ValidatorNumberToString();

    @Test(enabled = false)
    public void test_isDataValid_NumberLessThanZeroInRange_True() {
        long number = -1234538;
        boolean expected = validator.isDataValid(number);
        assertTrue(expected);
    }
    @Test
    public void test_isDataValid_NumberLessThanZeroOutOfRange_False() {
        long number = (long) ((Math.pow(10, 15)) * -1);
        boolean expected = validator.isDataValid(number);
        assertFalse(expected);
    }
    @Test
    public void test_isDataValid_NumberMoreThanZeroInRange_True() {
        long number = 3477867645L;
        boolean expected = validator.isDataValid(number);
        assertTrue(expected);
    }
    @Test
    public void test_isDataValid_NumberMoreThanZeroOutOfRange_False() {
        long number = (long) (Math.pow(10, 15))+2;
        boolean expected = validator.isDataValid(number);
        assertFalse(expected);
    }
    @Test
    public void test_isDataValid_Zero_True() {
        long number = 0;
        boolean expected = validator.isDataValid(number);
        assertTrue(expected);
    }
}
