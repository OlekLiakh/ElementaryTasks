package inputParameters;

import messages.Messages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class  DataInputFromConsole <T extends Messages> implements DataInput {

    private T message;

    public DataInputFromConsole (){};

    @Override
    public String getParameters() {
        System.out.println(message.ENTER_PARAMETERS);
        System.out.println(message.INPUT_TEMPLATE);
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