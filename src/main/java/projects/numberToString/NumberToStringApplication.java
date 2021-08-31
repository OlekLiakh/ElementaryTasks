package projects.numberToString;

import main.Application;
import main.parserStringToNumber.ParserStringToNumber;
import projects.numberToString.converter.ConverterNumberToString;
import projects.numberToString.converter.ConverterNumberToStringRussian;

public class NumberToStringApplication extends Application {

    private Long number;

    public NumberToStringApplication(ParserStringToNumber<Long> parser){
        super(parser);
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
