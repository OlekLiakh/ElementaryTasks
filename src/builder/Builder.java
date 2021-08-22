package builder;

import inputParameters.DataInputFromConsole;
import messages.Messages;
import validator.Validator;

public class Builder <T extends Messages> {
    private int neededParameters;
    private String[] args;
    Validator<T> validator;
    DataInputFromConsole<T> input;

    Builder(String[] args, int neededParameters) {
        this.args = args;
        this.neededParameters = neededParameters;
    }

    public void getParameters() {
        boolean isSuccessful = false;
        while (!isSuccessful) {
            try {
                validator.isNumberParametersValid();
                String name = args[0];
                double sideOne = Double.parseDouble(args[1]);
                double sideTwo = Double.parseDouble(args[2]);
                double sideThree = Double.parseDouble(args[3]);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());

            }

        }
    }
}
