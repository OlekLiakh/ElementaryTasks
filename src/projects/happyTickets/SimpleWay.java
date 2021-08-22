package projects.happyTickets;

import java.util.stream.Stream;

public class SimpleWay {
    private int firstTicket;
    private int lastTicket;

    public SimpleWay(int firstTicket, int lastTicket) {
        if (lastTicket > firstTicket) {
            this.firstTicket = firstTicket;
            this.lastTicket = lastTicket;
        } else {
            this.firstTicket = lastTicket;
            this.lastTicket = firstTicket;
        }
    }

    protected Long countHappyTickets() {
        long countSimply = Stream.iterate(firstTicket, m -> m + 1)
                .limit(lastTicket - firstTicket + 1)
                .filter(x -> {
                    int sumFirstThreeNumbers = (x / 100000) + (x / 10000 % 10) + (x / 1000 % 10);
                    int sumLastFirstThreeNumbers = (x % 1000 / 100) + (x % 100 / 10) + (x % 10);
                    return sumFirstThreeNumbers == sumLastFirstThreeNumbers;
                })
                .count();
        return countSimply;
    }
}
