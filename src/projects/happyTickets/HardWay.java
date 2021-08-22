package projects.happyTickets;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class HardWay {

    private int firstTicket;
    private int lastTicket;

    public HardWay(int firstTicket, int lastTicket){
        if(lastTicket>firstTicket){
        this.firstTicket = firstTicket;
        this.lastTicket = lastTicket;
        }  else {
            this.firstTicket = lastTicket;
            this.lastTicket = firstTicket;
        }
    }

    protected int countHappyTickets() {
        Predicate<Integer> hardWayCounter = new HardWayPredicate();
        long countHard = Stream.iterate(firstTicket, m -> m + 1)
                .limit(lastTicket-firstTicket+1)
                .filter(hardWayCounter::test)
                .peek(System.out::println)
                .count();
        return (int)countHard;
    }
}

