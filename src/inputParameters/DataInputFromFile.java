package inputParameters;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataInputFromFile implements DataInput {

    String path;

    public DataInputFromFile(String path) {
        this.path = path;
    }

    @Override
    public String getParameters() {
        StringBuilder lines = new StringBuilder();
        try {
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
            bufferedReader.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return lines.toString();
    }
}