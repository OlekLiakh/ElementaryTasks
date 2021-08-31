package projects.numberToString;

import inputParameters.EnterDataFromConsole;
import main.Application;
import main.RunnerApplication;
import projects.numberToString.message.MessagesRussian;

public class GetParametersNumberToString extends RunnerApplication implements MessagesRussian {

    EnterDataFromConsole input = new EnterDataFromConsole();

    public GetParametersNumberToString(String[] args, Application app) {
        super(args, app);
    }

    @Override
    protected void getParametersFromArguments() {
        if(args.length == 1){
            enteredValue = args[0];
        } else isParametersFromArgumentsValid = false;
    }

    @Override
    protected void getArguments() {
        enteredValue = input.getParameters(ENTER_VALUES, INPUT_SCHEME);
    }


}
