package projects.fibonacciSequence;

import main.RunnerApplication;
import main.inputOutput.input.InputDataFromConsole;
import main.inputOutput.output.OutputDataToConsole;

public class RunnerFibonacciSequenceFromConsole extends RunnerApplication{

    public RunnerFibonacciSequenceFromConsole(String[] args){
        super(args, new FibonacciSequenceApplication(),
                new GetParametersFibonacciSequence(new InputDataFromConsole()),
                new OutputDataToConsole());
    }
}
