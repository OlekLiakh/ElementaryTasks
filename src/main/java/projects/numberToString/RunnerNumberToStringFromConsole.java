package projects.numberToString;

import main.elementaryTasksAPI.RunnerApplicationFromConsole;
import main.elementaryTasksAPI.inputOutput.input.InputDataFromConsole;
import main.elementaryTasksAPI.inputOutput.output.OutputDataToConsole;

public class RunnerNumberToStringFromConsole extends RunnerApplicationFromConsole {

    public RunnerNumberToStringFromConsole(String[] args){
        super(args, new NumberToStringApplicationFromConsole(),
                new GetParametersNumberToString(new InputDataFromConsole()),
                new OutputDataToConsole());
    }
}
