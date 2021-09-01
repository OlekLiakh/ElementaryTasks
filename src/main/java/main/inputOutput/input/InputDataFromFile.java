package main.inputOutput.input;

import java.io.BufferedReader;
import java.io.IOException;

public class InputDataFromFile extends InputData {

    String path;

    public InputDataFromFile(String path) {
        this.path = path;
    }

    public String getParameters() throws IOException {
        StringBuilder lines = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(path));
        String line = bufferedReader.readLine();
        lines.append(line);
        while (line != null) {
            line = bufferedReader.readLine();
            if (line != null) {
                lines.append("\n");
                lines.append(line);
            }
        }
        return lines.toString();
    }
}