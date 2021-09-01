package projects.numberToString.converter.dictionary;

import java.util.HashMap;

public abstract class Dictionary{
    protected HashMap<Integer, String> dictionary = new HashMap<>();

    public Dictionary() {
        initDictionary();
    }

    abstract void initDictionary();

    public String getString(int number) {
        return dictionary.get(number);
    }

    public boolean containsNumber(int number) {
        return dictionary.containsKey(number);
    }

}
