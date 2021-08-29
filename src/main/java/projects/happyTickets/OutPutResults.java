package projects.happyTickets;

public class OutPutResults implements Messages {
    HardWay hardWay;
    SimpleWay simpleWay;

    public OutPutResults(HardWay hardWay, SimpleWay simpleWay) {
        this.hardWay = hardWay;
        this.simpleWay = simpleWay;
    }

    public void printResults() {
        int hardWayResult = hardWay.countHappyTickets();
        System.out.println(NUMBER_HAPPY_TICKETS + HARD_WAY_METHOD + ": " + hardWayResult);
        long simpleWayResult = simpleWay.countHappyTickets();
        System.out.println(NUMBER_HAPPY_TICKETS + SIMPLE_WAY_METHOD + ": " + simpleWayResult);
        if (hardWayResult > simpleWayResult) {
            System.out.println(WINNER_HARD_WAY_METHOD);
        } else if (hardWayResult < simpleWayResult) {
            System.out.println(WINNER_SIMPLE_WAY_METHOD);
        } else {
            System.out.println("Methods are equals");
        }
    }
}
