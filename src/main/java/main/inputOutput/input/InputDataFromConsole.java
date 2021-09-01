package main.inputOutput.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputDataFromConsole extends InputData{

    public String getParameters() throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String enteredString = bufferedReader.readLine();
        return enteredString;
    }
}