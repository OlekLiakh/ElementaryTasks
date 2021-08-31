package main.parserStringToNumber;

public abstract class ParserStringToNumber<T extends Number> {

    public abstract boolean parseParameters(String paramToParse) throws IllegalArgumentException;
    public abstract T  getParsedParameter();
}
