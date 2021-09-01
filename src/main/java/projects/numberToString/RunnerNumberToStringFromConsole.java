package projects.numberToString;

import main.Application;
import main.GetParameters;
import main.RunnerApplication;
import main.inputOutput.input.InputDataFromConsole;
import main.inputOutput.output.OutputDataToConsole;
import main.parserStringToNumber.ParserStringToLong;

public class RunnerNumberToStringFromConsole extends RunnerApplication{

    public RunnerNumberToStringFromConsole(String[] args){
        super(args, new NumberToStringApplication(),
                new GetParametersNumberToString(new InputDataFromConsole()),
                new OutputDataToConsole());
    }
}
