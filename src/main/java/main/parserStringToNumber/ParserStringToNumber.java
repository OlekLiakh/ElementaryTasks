package main.parserStringToNumber;

public abstract class ParserStringToNumber<T extends Number> {

    public abstract T parseParameters(String paramToParse) throws IllegalArgumentException;
}
