package inputParameters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EnterDataFromConsole{

    public String getParameters(String enterValueMessage, String inputScheme) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String enteredString = "";
        try {
            System.out.println(enterValueMessage);
            System.out.println(inputScheme);
            enteredString = bufferedReader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return enteredString;
    }
}