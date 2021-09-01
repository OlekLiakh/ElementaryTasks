package main.runMainApplication;

import main.elementaryTasksAPI.ApplicationFromConsole;
import main.elementaryTasksAPI.RunnerApplicationFromConsole;
import main.elementaryTasksAPI.parserStringToNumber.ParserStringToInt;
import projects.fibonacciSequence.RunnerFibonacciSequenceFromConsole;
import projects.numberToString.RunnerNumberToStringFromConsole;

import java.util.HashMap;
import java.util.Map;

public class MainApplicationFromConsole extends ApplicationFromConsole {

    private String [] args;
    private Integer numberApplication;
    private Map<Integer, RunnerApplicationFromConsole> applicationMap=new HashMap<>();

    public MainApplicationFromConsole() {
        super(new ParserStringToInt(), new MessageMain());
    }
    public MainApplicationFromConsole(String [] args) {
        super(new ParserStringToInt(), new MessageMain());
        this.args = args;
    }

    @Override
    public String execute(String enteredParameters) throws IllegalArgumentException {
        parseParameters(enteredParameters);
        runProgram(numberApplication);
        return "";
    }

    @Override
    public void parseParameters(String enteredValue) throws IllegalArgumentException {
        numberApplication = (Integer) parser.parseParameters(enteredValue);
    }
    private void runProgram (int number){
        initApplicationMap();
        applicationMap.get(number).runApplication();
    }

    private void initApplicationMap(){
        applicationMap.put(5, new RunnerNumberToStringFromConsole(args));
        applicationMap.put(8, new RunnerFibonacciSequenceFromConsole(args));
    }


}
