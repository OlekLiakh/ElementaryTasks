package projects.numberToString;

import main.GetParameters;
import main.inputOutput.input.InputData;

import java.io.IOException;

public class GetParametersNumberToString extends GetParameters {

    private String enteredValue;

    public GetParametersNumberToString(InputData input) {
        super(input);
    }

    @Override
    protected String getParametersFromStartArguments(String[] args) {

        if (args.length == 1) {
            enteredValue = args[0];
        }
        return enteredValue;
    }

    @Override
    protected String getArguments() throws IOException {
        enteredValue = input.getParameters();
        return enteredValue;
    }
}
