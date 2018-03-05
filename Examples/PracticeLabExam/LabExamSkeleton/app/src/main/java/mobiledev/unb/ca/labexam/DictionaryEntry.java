package mobiledev.unb.ca.labexam;

public class DictionaryEntry {

    private String mWord;
    private String mDefinition;

    public DictionaryEntry(String word, String definition) {
        mWord = word;
        mDefinition = definition;
    }

    public String getWord() {
        return mWord;
    }

    public String getDefinition() {
        return mDefinition;
    }

}
