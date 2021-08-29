package projects.triangles;

import inputParameters.EnterDataFromConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParserStringToTriangle implements Message {

    protected EnterDataFromConsole input = new EnterDataFromConsole();
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
        enteredString = input.getParameters(ENTER_PARAMETERS, INPUT_TEMPLATE);
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

    public Double validateSide(String enteredValue, int sideNumber) {
        while (true) {
            try {
                double parsedValue = Double.parseDouble(enteredValue);
                if (parsedValue<=0){
                    throw new NumberFormatException();
                }
                return parsedValue;
            } catch (NumberFormatException nfe) {
                System.out.println(WRONG_SIDE);
                String wrongSide = "Entered value: "+enteredValue+ " for side number " + sideNumber+" is incorrect\n";
                System.out.print(wrongSide);
                System.out.println(SIDE_FORMAT_RULE);
                enteredValue = input.getParameters(ENTER_PARAMETERS, INPUT_TEMPLATE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}