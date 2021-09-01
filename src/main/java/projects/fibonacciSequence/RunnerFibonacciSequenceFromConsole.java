package projects.fibonacciSequence;

import main.elementaryTasksAPI.RunnerApplicationFromConsole;
import main.elementaryTasksAPI.inputOutput.input.InputDataFromConsole;
import main.elementaryTasksAPI.inputOutput.output.OutputDataToConsole;

public class RunnerFibonacciSequenceFromConsole extends RunnerApplicationFromConsole {

    public RunnerFibonacciSequenceFromConsole(String[] args){
        super(args, new FibonacciSequenceApplicationFromConsole(),
                new GetParametersFibonacciSequence(new InputDataFromConsole()),
                new OutputDataToConsole());
    }
}
