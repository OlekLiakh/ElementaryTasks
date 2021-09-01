package main.parserStringToNumber;

public class ParserStringToDouble extends ParserStringToNumber<Double> {

    @Override
    public Double parseParameters(String paramToParse) throws IllegalArgumentException{
        Double number = Double.parseDouble(paramToParse);
        return number;
    }
}
