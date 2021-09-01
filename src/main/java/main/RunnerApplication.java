package main;

import main.inputOutput.output.OutputData;

import java.io.IOException;

public abstract class RunnerApplication {

    private GetParameters getParameters;
    private Application app;
    private OutputData output;
    private Message message;
    private String[] args;
    private String enteredValue;
    private boolean isParametersFromArgumentsValid = true;


    public RunnerApplication(String[] args, Application app,
                             GetParameters getParameters, OutputData output) {
        this.args = args;
        this.app = app;
        this.getParameters = getParameters;
        this.output = output;
    }

    public void runApplication() {
        message = app.getMessage();

        boolean isContinue = true;
        do {
            try {
                if (args.length != 0 || isParametersFromArgumentsValid) {
                    enteredValue = getParameters.getParametersFromStartArguments(args);
                    if (enteredValue == null) {
                        isParametersFromArgumentsValid = false;
                        continue;
                    }
                } else {
                    output.outputData(message.getENTER_VALUES());
                    output.outputData(message.getINPUT_SCHEME());
                    enteredValue = getParameters.getArguments();
                }
                String result = app.execute(enteredValue);
                output.outputData(result);
                isContinue = false;
            } catch (IllegalArgumentException | IOException exception) {
                isParametersFromArgumentsValid = false;
                output.outputData(message.getINCORRECT_VALUE());
                output.outputData(exception.getMessage());
            } catch (Exception exception) {
                output.outputData(message.getEXCEPTION());
            }
        } while (isContinue);
    }
}
