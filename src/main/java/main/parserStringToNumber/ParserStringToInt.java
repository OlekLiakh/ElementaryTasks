package main.parserStringToNumber;

public class ParserStringToInt extends ParserStringToNumber<Integer> {

    @Override
    public Integer parseParameters(String paramToParse) throws IllegalArgumentException {
        Integer number = Integer.parseInt(paramToParse);
        return number;
    }

}
