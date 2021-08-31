package main;

import inputParameters.EnterDataFromConsole;
import main.parserStringToNumber.ParserStringToNumber;

public abstract class RunnerApplication {

    protected String[] args;
    protected String enteredValue;
    protected boolean isParametersFromArgumentsValid = true;
    protected boolean isParserNeed;
    GetParameters getParameters;
    EnterDataFromConsole input = new EnterDataFromConsole();
    Application app;

//    TODO separate methods to own class GetParameters
    protected abstract void getParametersFromArguments();
    protected abstract void getArguments();

    public RunnerApplication(String[] args, Application app) {
        this.args = args;
        this.app = app;
        isParserNeed = false;
    }
    public RunnerApplication(String[] args, Application app, ParserStringToNumber parserParameters) {
        this.args = args;
        this.app = app;
        isParserNeed = true;
    }

    public void runApplication() {
        boolean isContinue = true;
        do {
            try {
                if (args.length == 0 || !isParametersFromArgumentsValid) {
                    getArguments();
                } else {
                    getParametersFromArguments();
                }
                String result = app.execute(enteredValue);
//                outPut.outputMessage(result);
                System.out.println(result);
                isContinue = false;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                isParametersFromArgumentsValid=false;
//                outPut.outputMessage(exception.getMessage());
            }
        } while (isContinue);
    }
}
