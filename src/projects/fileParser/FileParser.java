package projects.fileParser;

import inputParameters.DataInput;
import inputParameters.DataInputFromConsole;
import inputParameters.DataInputFromFile;

public class FileParser {

    public static void main(String[] args) {

        if (args.length != 2 || args.length != 3) {
            System.out.println("If you want to count the number of occurrences of a string in a text file.");
            System.out.println("Enter parameters by scheme: <file path> <string to count>");
            System.out.println("If you want to replace a string to another in file");
            System.out.println("Enter parameters by scheme: <file path> <search string> <replacement string>");
            DataInput input = new DataInputFromConsole();
            String enteredParameters = input.getParameters();
            args = enteredParameters.split(" ");
        }
        if (args.length == 2) {
            DataInputFromFile dataInputFromFile = new DataInputFromFile(args[0]);
            String enteredData = "";
            try {
                enteredData = dataInputFromFile.getParameters();
            } catch (Exception e){
                e.printStackTrace();
                System.exit(0);
            }
            Counter counter = new Counter();
            counter.getCount(enteredData,args[1]);
        }
        if (args.length==3){
            DataInputFromFile dataInputFromFile = new DataInputFromFile(args[0]);
            String enteredData = "";
            try {
                enteredData = dataInputFromFile.getParameters();
            } catch (Exception e){
                e.printStackTrace();
                System.exit(0);
            }
            enteredData.replaceAll(args[1],args[2]);
        }
    }


}