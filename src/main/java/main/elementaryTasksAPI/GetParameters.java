package main.elementaryTasksAPI;

import main.elementaryTasksAPI.inputOutput.input.InputData;

import java.io.IOException;

public abstract class GetParameters {

    protected InputData input;

    protected GetParameters(InputData input){
        this.input = input;
    }
    protected abstract String getParametersFromStartArguments(String [] args);
    protected abstract String getArguments() throws IOException;
}
