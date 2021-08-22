package inputParameters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataInputFromConsole implements DataInput {

    @Override
    public String getParameters() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String enteredString = "";
        try{
        enteredString = bufferedReader.readLine();
        bufferedReader.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return enteredString;
    }
}