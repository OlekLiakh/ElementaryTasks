package projects.numberToString;

import main.Application;
import main.parserStringToNumber.ParserStringToLong;
import projects.numberToString.converter.ConverterNumberToString;
import projects.numberToString.converter.ConverterNumberToStringRussian;
import projects.numberToString.message.MessageRussian;


public class NumberToStringApplication extends Application {

    private Long number;
    public NumberToStringApplication(){
        super(new ParserStringToLong(), new MessageRussian());

    }

    @Override
    public String execute(String enteredParameters) throws IllegalArgumentException {
        parseParameters(enteredParameters);
        ConverterNumberToString converter = new ConverterNumberToStringRussian();
        String result = converter.convertNumberToString(number);
        return result;
    }

    @Override
    public void parseParameters(String enteredValue) throws IllegalArgumentException {
        parser.parseParameters(enteredValue);
        number = (Long) parser.getParsedParameter();
    }

}
