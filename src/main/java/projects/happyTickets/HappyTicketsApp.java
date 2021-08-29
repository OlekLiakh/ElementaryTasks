package projects.happyTickets;

public class HappyTicketsApp implements Messages{
    public static void main(String[] args) {
        DataInput incomingParameters = new DataInput();
        int[] array = incomingParameters.getParameters();
        HardWay hardWay = new HardWay(array[0],array[1]);
        SimpleWay simpleWay = new SimpleWay(array[0],array[1]);

        OutPutResults outPutResults = new OutPutResults(hardWay, simpleWay);
        outPutResults.printResults();
    }
}
