package main.runMainApplication;

import main.elementaryTasksAPI.GetParameters;
import main.elementaryTasksAPI.inputOutput.input.InputData;

import java.io.IOException;

public class GetParametersMain extends GetParameters {

    private String enteredValue;

    public GetParametersMain(InputData input) {
        super(input);
    }

    @Override
    protected String getParametersFromStartArguments(String[] args) {

        if (args.length == 1) {
            enteredValue = args[0];
            return enteredValue;
        }
        return enteredValue;
    }

    @Override
    protected String getArguments() throws IOException {
        enteredValue = input.getParameters();
        return enteredValue;
    }
}
