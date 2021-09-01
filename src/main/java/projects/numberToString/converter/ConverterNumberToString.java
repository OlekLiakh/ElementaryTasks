package projects.numberToString.converter;
import main.Message;

public abstract class ConverterNumberToString {

    public abstract String convertNumberToString(long number) throws IllegalArgumentException;
    public ConverterNumberToString(){
    }
}
