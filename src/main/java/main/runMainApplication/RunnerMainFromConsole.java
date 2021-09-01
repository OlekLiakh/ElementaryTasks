package main.runMainApplication;

import main.elementaryTasksAPI.RunnerApplicationFromConsole;
import main.elementaryTasksAPI.inputOutput.input.InputDataFromConsole;
import main.elementaryTasksAPI.inputOutput.output.OutputDataToConsole;

public class RunnerMainFromConsole extends RunnerApplicationFromConsole {

    public RunnerMainFromConsole(String[] args){
        super(args, new MainApplicationFromConsole(args),
                new GetParametersMain(new InputDataFromConsole()),
                new OutputDataToConsole());
    }
}
