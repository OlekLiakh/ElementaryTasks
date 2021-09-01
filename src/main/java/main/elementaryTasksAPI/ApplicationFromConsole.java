package main.elementaryTasksAPI;

import main.elementaryTasksAPI.parserStringToNumber.ParserStringToNumber;

public abstract class ApplicationFromConsole {

    protected ParserStringToNumber<? extends Number> parser;
    protected Message message;

    public ApplicationFromConsole() {
    }

    public ApplicationFromConsole(ParserStringToNumber<? extends Number> parser, Message message) {
        this.parser = parser;
        this.message = message;
    }

    public abstract void parseParameters(String value) throws IllegalArgumentException;

    public abstract String execute(String enteredParameters) throws IllegalArgumentException;

    public Message getMessage() {
        return message;
    }
}
