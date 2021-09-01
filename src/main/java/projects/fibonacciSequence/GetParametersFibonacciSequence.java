package projects.fibonacciSequence;

import main.GetParameters;
import main.inputOutput.input.InputData;

import java.io.IOException;

public class GetParametersFibonacciSequence extends GetParameters {

    private String enteredValue;
    private MessageFibonacciSequence message;

    public GetParametersFibonacciSequence(InputData input) {
        super(input);
    }

    @Override
    protected String getParametersFromStartArguments(String[] args) {

        if (args.length == 1) {
            enteredValue = args[0];
        }
        if(args.length==2) {
            enteredValue = args[0]+message.getDELIMITER()+args[1];
        }
        return enteredValue;
    }

    @Override
    protected String getArguments() throws IOException {
        enteredValue = input.getParameters();
        return enteredValue;
    }
}
