package projects.triangles;

public interface Message {
    String ENTER_PARAMETERS = "Enter the triangle parameters according to the template";
    String SPLITTER = ",";
    String INPUT_TEMPLATE = "<name>" + SPLITTER + " <first side>" + SPLITTER + " <second side>" + SPLITTER + " <third side>";
    String WRONG_SIDE = "Entered data for side is incorrect";
    String SIDE_FORMAT_RULE = "Enter positive integer or floating-point number (not zero).";
    String WRONG_INPUT_PARAMETERS = "Data passed in does not match the template";
    String QUESTION = "If you want to add parameters of triangle enter <yes> or <y>";
    String TRIANGLE_CAN_NOT_EXIST = "A triangle with such sides cannot exist";
}