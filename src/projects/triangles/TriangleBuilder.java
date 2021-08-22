package projects.triangles;

import inputParameters.DataInput;
import inputParameters.DataInputFromConsole;
import validator.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TriangleBuilder implements MessagesTriangles {

    protected DataInput input = new DataInputFromConsole<MessagesTriangles>();
    private final int numberTriangleParameters = 4;
    protected Validator<MessagesTriangles> validator = new TriangleValidator();
    private String enteredString;

    public TriangleBuilder() {}

    public Triangle getTriangle() {
        boolean isValueCorrect = false;
        while (!isValueCorrect) {
            enteredString = input.getParameters();
            List<String> listEnteredParameters = splitEnteredParameters();
            if (validator.isNumberParametersValid(listEnteredParameters, numberTriangleParameters)) {
                isValueCorrect = true;
            }
            else {
                continue;
            }
            try{
                validator.isParametersValid(listEnteredParameters);
                isValueCorrect = true;
            }
            catch (NumberFormatException e){
                isValueCorrect = false;
                System.out.println(e.getMessage());
            }
        }
    }
    private List<String> splitEnteredParameters() {
        List<String> listEnteredParameters = new ArrayList<>();
        listEnteredParameters = Stream.of(enteredString.split(SPLITTER))
                    .map(elem -> new String(elem))
                    .map(elem -> elem.trim())
                    .collect(Collectors.toList());
        return listEnteredParameters;
    }
}