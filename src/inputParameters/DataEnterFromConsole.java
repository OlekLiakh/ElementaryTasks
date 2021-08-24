package inputParameters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataEnterFromConsole {

    public String getParameters() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String enteredString = "";
        try {
            enteredString = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return enteredString;
    }
}