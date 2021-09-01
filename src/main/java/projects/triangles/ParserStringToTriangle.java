package projects.triangles;

import main.elementaryTasksAPI.inputOutput.input.InputDataFromConsole;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParserStringToTriangle implements Message {

    protected InputDataFromConsole input = new InputDataFromConsole();
    private String enteredString;

    public ParserStringToTriangle(String enteredString) {
        this.enteredString = enteredString;
    }

    public Triangle getTriangle() {
        if (enteredString == null) {
            enterTriangleValues();
        }
        List<String> listEnteredParameters = splitEnteredParameters();
        String triangleName = listEnteredParameters.get(0);
        Double sideOne = validateSide(listEnteredParameters.get(1), 1);
        Double sideTwo = validateSide(listEnteredParameters.get(2), 2);
        Double sideThree = validateSide(listEnteredParameters.get(3), 3);

        if(isTriangleCanExist(sideOne, sideTwo, sideThree)) {
            Triangle triangle = new Triangle(triangleName, sideOne, sideTwo, sideThree);
            return triangle;
        } else {
            System.out.println(TRIANGLE_CAN_NOT_EXIST);
            return null;
        }
    }
    private boolean isTriangleCanExist(Double sideOne, Double sideTwo, Double sideThree) {
        return ((sideOne + sideTwo) > sideThree)
                && ((sideOne + sideThree) > sideTwo)
                && ((sideTwo + sideThree) > sideOne);
    }

    private void enterTriangleValues() {
        System.out.println(WRONG_INPUT_PARAMETERS);
//TODO change method
        System.out.println(ENTER_PARAMETERS);
        System.out.println(INPUT_TEMPLATE);
        try {
            enteredString = input.getParameters();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private List<String> splitEnteredParameters() {
        List<String> listEnteredParameters = new ArrayList<>();
        int numberTriangleParameters = 4;
        boolean isCorrect = false;
        while (!isCorrect) {
            listEnteredParameters = Stream.of(enteredString.split(","))
                    .map(elem -> new String(elem))
                    .map(elem -> elem.trim())
                    .collect(Collectors.toList());
            if (listEnteredParameters.size() != numberTriangleParameters) {
                enterTriangleValues();
            } else {
                isCorrect = true;
            }
        }
        return listEnteredParameters;
    }

    private Double validateSide(String enteredValue, int sideNumber) {
        while (true) {
            try {
                double parsedValue = Double.parseDouble(enteredValue);
                if (parsedValue<=0){
                    System.out.println(WRONG_SIDE);
                    String wrongSide = "Entered value: "+enteredValue+ " for side number " + sideNumber+" is incorrect\n";
                    System.out.print(wrongSide);
                    System.out.println(SIDE_FORMAT_RULE);
                    System.out.println(ENTER_PARAMETERS);
                    System.out.println(INPUT_TEMPLATE);
                    enteredValue = input.getParameters();
                }
                return parsedValue;
            } catch (NumberFormatException nfe) {
                System.out.println(nfe.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}