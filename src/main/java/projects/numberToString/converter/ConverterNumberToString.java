package projects.numberToString.converter;
import main.Application;
import main.Validator;

public abstract class ConverterNumberToString {
    public abstract String convertNumberToString(long number) throws IllegalArgumentException;

    public ConverterNumberToString(){
    }
}
