package main;

import main.parserStringToNumber.ParserStringToNumber;

public abstract class Application {

    protected ParserStringToNumber<? extends Number> parser;

    protected Message message;

    public Application() {
    }

    public Application(ParserStringToNumber<? extends Number> parser, Message message) {
        this.parser = parser;
        this.message = message;
    }

    public abstract void parseParameters(String enteredValue) throws IllegalArgumentException;

    public abstract String execute(String enteredValue) throws IllegalArgumentException;

    public Message getMessage() {
        return message;
    }
}
