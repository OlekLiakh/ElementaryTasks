package main.elementaryTasksAPI.parserStringToNumber;

public class ParserStringToLong extends ParserStringToNumber<Long> {

    @Override
    public Long parseParameters(String paramToParse) throws IllegalArgumentException {
        Long number = Long.parseLong(paramToParse);
        return number;
    }
}
