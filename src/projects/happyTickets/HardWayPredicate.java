package projects.happyTickets;

import java.util.function.Predicate;

public class HardWayPredicate implements Predicate<Integer> {
    private int sumOdds = 0;
    private int sumEven = 0;

    @Override
    public boolean test(Integer integer) {
        countSumsOddAndEvenDigits(integer);
        boolean isSumsEquals = (sumEven == sumOdds);
        sumOdds = 0;
        sumEven = 0;
        return isSumsEquals;
    }

    private void countSumsOddAndEvenDigits(Integer integer) {
        for (int i = 10; i <= 1000000; i *= 10) {
            int temp = integer % i;
            if (i > 10) {
                temp = temp / (i / 10);
            }
            if (temp % 2 == 0) {
                sumEven += temp;
            } else {
                sumOdds += temp;
            }
        }
    }
}
