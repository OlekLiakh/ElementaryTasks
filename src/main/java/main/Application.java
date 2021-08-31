package main;

import main.parserStringToNumber.ParserStringToNumber;

public abstract class Application {

    protected ParserStringToNumber<? extends Number> parser;
    private boolean isParserNeed;

    public Application() {
        isParserNeed = false;
    }

    public Application(ParserStringToNumber<? extends Number> parser) {
        this.parser = parser;
        isParserNeed = true;
    }

    public abstract void parseParameters(String enteredValue) throws IllegalArgumentException;

    public abstract String execute(String enteredValue) throws IllegalArgumentException;




}
