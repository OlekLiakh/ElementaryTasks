package projects.triangles;

import messages.Messages;

public interface MessagesTriangles extends Messages {
    String ENTER_PARAMETERS = "Enter the triangle parameters according to the template";
    String SPLITTER = ",";
    String INPUT_TEMPLATE = "<name>" + SPLITTER + " <first side>" + SPLITTER + " <second side>" + SPLITTER + " <third side>";
    String WRONG_SIDE = "Entered data is incorrect for side ";

    String SIDE_FORMAT_RULE = "Enter positive integer or floating-point number (not zero).";
    String QUESTION = "If you want to add parameters of triangle enter <yes> or <y>";
    String TRIANGLE_CAN_NOT_EXIST = "A triangle with such sides cannot exist";
}