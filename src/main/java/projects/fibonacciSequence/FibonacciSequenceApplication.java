package projects.fibonacciSequence;

import main.Application;
import main.parserStringToNumber.ParserStringToLong;


public class FibonacciSequenceApplication extends Application {

    private long [] fibonacciSequenceRange = new long [2];
    private MessageFibonacciSequence message = new MessageFibonacciSequence();

    public FibonacciSequenceApplication() {
        super(new ParserStringToLong(), new MessageFibonacciSequence());
    }

    @Override
    public String execute(String enteredParameters) throws IllegalArgumentException {
        parseParameters(enteredParameters);
        FibonacciSequence fibonacciSequence = new FibonacciSequence(fibonacciSequenceRange);
        String result = fibonacciSequence.getFibonacciSequence();
        return result;
    }

    @Override
    public void parseParameters(String enteredValue) throws IllegalArgumentException {
        String [] splitedValue = enteredValue.split(message.getDELIMITER());
        if(splitedValue.length==1){
            Long numberLength = (Long)parser.parseParameters(splitedValue[0]);
            if(numberLength==0){
                throw new IllegalArgumentException();
            }
            fibonacciSequenceRange[0] = (long)(Math.pow(10, numberLength - 1));
            fibonacciSequenceRange[1] = (long)(Math.pow(10, numberLength));
        }
        if(splitedValue.length==2) {
            Long startRange = (Long) parser.parseParameters(splitedValue[0]);
            fibonacciSequenceRange[0] = startRange;
            Long endRange = (Long) parser.parseParameters(splitedValue[1]);
            fibonacciSequenceRange[1] = endRange;
        }
    }

}
