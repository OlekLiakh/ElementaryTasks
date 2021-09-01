package main.parserStringToNumber;

public class ParserStringToLong extends ParserStringToNumber<Long> {

    private Long number;

    @Override
    public boolean parseParameters(String paramToParse) throws IllegalArgumentException{
        number = Long.parseLong(paramToParse);
        return true;
    }

    @Override
    public Long getParsedParameter() {
        return number;
    }


}
