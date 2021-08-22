package validator;

import messages.Messages;

import java.util.List;

public abstract class Validator <T extends Messages> {

    protected T messages;

    public Validator() {
    }

    public  abstract boolean isParametersValid(List<String> parameters);

    public boolean isNumberParametersValid(List<String> parameters, int neededParameters) throws NumberFormatException{
        if(parameters.size()!=neededParameters){
            throw new NumberFormatException (messages.ENTERED_AN_INCORRECT_VALUE);
        }
        return true;
    }
}
