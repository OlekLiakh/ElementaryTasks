package projects.numberToString.dictionary;

import java.util.HashMap;

public abstract class Dictionary {
    protected HashMap<Integer, String> dictionary = new HashMap<>();

    abstract void initDictionary();

    public HashMap<Integer, String> getDictionary() {
        return dictionary;
    }

}
