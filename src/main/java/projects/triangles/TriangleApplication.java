package projects.triangles;

import main.elementaryTasksAPI.inputOutput.input.InputDataFromConsole;

import java.io.IOException;

public class TriangleApplication implements Message{
    protected InputDataFromConsole input = new InputDataFromConsole();
    private final TriangleStorage storage = new TriangleStorage();

//    TODO change method
    public void execute(){
        boolean isContinue = true;
        while (isContinue){
            try {
                System.out.println(ENTER_PARAMETERS);
                System.out.println(INPUT_TEMPLATE);
                String enteredString = input.getParameters();
                ParserStringToTriangle parser = new ParserStringToTriangle(enteredString);
                Triangle triangle = parser.getTriangle();
                if (triangle != null) {
                    storage.addTriangle(triangle);
                }
                isContinue = isContinue();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        System.out.println(storage.toString());
    }
    //    TODO change method
    private boolean isContinue() {
        try {
            System.out.println(ENTER_PARAMETERS);
            System.out.println(INPUT_TEMPLATE);
            String response = input.getParameters();
            return response.equalsIgnoreCase("yes")
                    || response.equalsIgnoreCase("y");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return false;
    }
}