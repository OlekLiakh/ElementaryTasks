package projects.fileParser;

import messages.Messages;

public interface MessageFileParser extends Messages {
    String ENTER_VALUES = "Enter values by scheme";
    String INPUT_SCHEME = "If you want to count the number of occurrences of a string in a text file\n"
                + "Enter parameters by scheme: <file path> <string to count>\n"
                + "If you want to replace a string to another in file\n"
                + "Enter parameters by scheme: <file path> <search string> <replacement string>";
}


