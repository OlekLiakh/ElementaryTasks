package projects.numberToString;

import main.RunnerApplication;
import main.parserStringToNumber.ParserStringToLong;

public class Main {
    public static void main(String[] args) {
        RunnerApplication main = new GetParametersNumberToString(args,
                new NumberToStringApplication(new ParserStringToLong()));
        main.runApplication();
    }
}
