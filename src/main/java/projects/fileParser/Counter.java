package projects.fileParser;

public class Counter {
    public int getCount(String lines, String stringToCount) {
        int counter = 0;
        boolean isContains = lines.contains(stringToCount);
        if (isContains) {
            int charIndex = 0;
            while (isContains) {
                charIndex = lines.indexOf(stringToCount, charIndex);
                charIndex = charIndex + stringToCount.length();
                counter += 1;
                if (!lines.substring(charIndex).contains(stringToCount)) {
                    isContains = false;
                }
            }
        }
        return counter;
    }
}
