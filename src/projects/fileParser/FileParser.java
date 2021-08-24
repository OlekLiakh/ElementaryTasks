package projects.fileParser;

import inputParameters.DataEnterFromConsole;
import inputParameters.DataEnterFromFile;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileParser implements MessageFileParser{

    private String[] args;
    private DataEnterFromConsole input = new DataEnterFromConsole();

    public FileParser(String[] args) {
        this.args = args;
    }

    public void run() {
        boolean getParams = true;
        while (getParams) {
            if (args.length == 2) {
                String path = args[0];
                String stringForCount = args[1];
                int count = getCount(path, stringForCount);
                System.out.printf("String %s occurs %d times", stringForCount, count);
                getParams = false;
            }
            if (args.length == 3) {
                String path = args[0];
                String searchString = args[1];
                String replaceString = args[2];
                rewriteStringInFile(path, searchString, replaceString);
                getParams = false;
            }
            if (getParams) {
                args = getParameters();
            }
        }
    }

    private int getCount(String path, String stringToCount) {
        DataEnterFromFile dataEnterFromFile = new DataEnterFromFile(path);
        String textFromFile = "";
        try {
            textFromFile = dataEnterFromFile.getParameters();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        Counter counter = new Counter();
        int count = counter.getCount(textFromFile, stringToCount);
        return count;
    }

    private void rewriteStringInFile(String path, String searchString, String replaceString) {
        try {
            DataEnterFromFile dataEnterFromFile = new DataEnterFromFile(path);
            String dataFromFile = dataEnterFromFile.getParameters();
            String changedString = dataFromFile.replaceAll(searchString, replaceString);
            FileWriter writer = new FileWriter(path, false);
            writer.write(changedString);
            writer.flush();
        } catch (FileNotFoundException exception) {
            System.out.println("The file can't be find");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private String[] getParameters() {
        System.out.println(ENTER_VALUES);
        System.out.println(INPUT_SCHEME);
        String enteredParameters = input.getParameters();
        args = enteredParameters.split(" ");
        return args;
    }
}