package main.parserStringToNumber;

public class ParserStringToInt extends ParserStringToNumber<Integer> {

    private Integer number;

    public ParserStringToInt(){
    }

    @Override
    public boolean parseParameters(String paramToParse) throws IllegalArgumentException{
        number = Integer.parseInt(paramToParse);
        return true;
    }

    @Override
    public Integer getParsedParameter() {
        return number;
    }


}
