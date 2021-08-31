package main.parserStringToNumber;

public class ParserStringToDouble extends ParserStringToNumber<Double> {

    private Double number;

    public ParserStringToDouble(){
    }

    @Override
    public boolean parseParameters(String paramToParse) throws IllegalArgumentException{
        number = Double.parseDouble(paramToParse);
        return true;
    }

    @Override
    public Double getParsedParameter() {
        return number;
    }


}
