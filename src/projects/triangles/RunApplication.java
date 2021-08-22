package projects.triangles;

import inputParameters.DataInput;
import inputParameters.DataInputFromConsole;

public class RunApplication implements MessagesTriangles {
    protected DataInput input = new DataInputFromConsole();
    private final TriangleStorage storage = new TriangleStorage();

    public void run(){
        boolean isRun = true;
        while (isRun){
            TriangleBuilder parser = new TriangleBuilder();
            Triangle triangle = parser.getTriangle();
            if (triangle != null) {
                storage.addTriangle(triangle);
            }
            isRun = isContinue();
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
