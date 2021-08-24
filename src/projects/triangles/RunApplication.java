package projects.triangles;

import inputParameters.DataEnterFromConsole;

public class RunApplication implements Message{
    protected DataEnterFromConsole input = new DataEnterFromConsole();
    private final TriangleStorage storage = new TriangleStorage();

    public void run(){
        boolean run = true;
        while (run){
            System.out.println(ENTER_PARAMETERS);
            System.out.println(INPUT_TEMPLATE);
            String enteredString = input.getParameters();
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
        System.out.println(QUESTION);
        String response = input.getParameters();
        return response.equalsIgnoreCase("yes")
                || response.equalsIgnoreCase("y");
    }
}
