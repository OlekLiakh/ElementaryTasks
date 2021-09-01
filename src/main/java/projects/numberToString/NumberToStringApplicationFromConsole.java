package projects.numberToString;

import main.elementaryTasksAPI.ApplicationFromConsole;
import main.elementaryTasksAPI.parserStringToNumber.ParserStringToLong;
import projects.numberToString.converter.ConverterNumberToString;
import projects.numberToString.converter.ConverterNumberToStringRussian;
import projects.numberToString.message.MessageRussian;


public class NumberToStringApplicationFromConsole extends ApplicationFromConsole {

    private Long number;

    public NumberToStringApplicationFromConsole() {
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
        number = (Long) parser.parseParameters(enteredValue);
    }

}
