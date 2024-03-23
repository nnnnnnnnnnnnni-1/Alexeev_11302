package Test;

import java.util.Arrays;

public class ArrayList {
    private String[] translations;
    protected int capacity;
    protected int size;
    public ArrayList(){
        capacity = 1;
        translations = new String[capacity];
        size = 0;
    }
    public void add(String translation){
        if (size == translations.length) extendCapacity();
        translations[size] = translation;
        size++;
    }
    public void extendCapacity(){
        capacity += 1;
        translations = Arrays.copyOf(translations, capacity);
    }
    public String[] getTranslations(){
        return translations;
    }
}
