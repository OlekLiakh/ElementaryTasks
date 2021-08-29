package projects.triangles;

import inputParameters.EnterDataFromConsole;

public class RunApplication implements Message{
    protected EnterDataFromConsole input = new EnterDataFromConsole();
    private final TriangleStorage storage = new TriangleStorage();

    public void run(){
        boolean run = true;
        while (run){
            String enteredString = input.getParameters(ENTER_PARAMETERS, INPUT_TEMPLATE);
            ParserStringToTriangle parser = new ParserStringToTriangle(enteredString);
            Triangle triangle = parser.getTriangle();
            if (triangle != null) {
                storage.addTriangle(triangle);
            }
            run = isContinue();
        }
        System.out.println(storage.toString());
    }
    private boolean isContinue() {
        String response = input.getParameters("", QUESTION);
        return response.equalsIgnoreCase("yes")
                || response.equalsIgnoreCase("y");
    }
}