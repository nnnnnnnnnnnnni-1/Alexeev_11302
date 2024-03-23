package Test;

import java.util.Arrays;

public class Node {
    final private String word;
    int size = 0;
    private ArrayList translations;
    Node next;

    public Node(String word, String translation){
        translations = new ArrayList();
        this.word = word;
        translations.add(translation);
        next = null;
    }
    public Node(String word, String[] manyTranslations){
        translations = new ArrayList();
        this.word = word;
        for (String translation : manyTranslations){
            translations.add(translation);
        }
    }
    public void add(String translation){
        for (String word : translations.getTranslations()){
            if (word.equals(translation)){
                System.out.println("This word is already in dict");
                return;
            }
        }
        translations.add(translation);
    }
    @Override
    public String toString(){
        return "Word: " + word + " Translations: " + Arrays.toString(translations.getTranslations());
    }
    public String getWord(){return word;}
    public String[] getTranslations(){return translations.getTranslations();}
}
