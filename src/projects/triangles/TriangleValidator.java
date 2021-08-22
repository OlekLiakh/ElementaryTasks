package projects.triangles;

import validator.Validator;

import java.util.List;

public class TriangleValidator extends Validator<MessagesTriangles> {

    public TriangleValidator() {
        super();
    }

    @Override
    public boolean isParametersValid(List<String> parameters) throws NumberFormatException {
        double sideOne = validateSide(parameters.get(1), 1);
        double sideTwo = validateSide(parameters.get(2), 2);
        double sideThree = validateSide(parameters.get(3), 3);
        isTriangleCanExist(sideOne,sideTwo,sideThree);
        return true;
    }
    private double validateSide(String enteredValue, int sideNumber) throws NumberFormatException {
        double parsedValue = Double.parseDouble(enteredValue);
        if (parsedValue <= 0) {
            throw new NumberFormatException(messages.ENTERED_AN_INCORRECT_VALUE);
        }
        return parsedValue;
    }
    private boolean isTriangleCanExist(Double sideOne,Double sideTwo,Double sideThree){
       if(!(((sideOne+sideTwo)>sideThree)
               &&((sideOne+sideThree)>sideTwo)
                &&((sideTwo+sideThree)>sideOne))){
           throw new NumberFormatException(messages.WRONG_SIDE);
       }
    }
}