package Test;

import java.util.Set;

public interface IDictionary {
    void show();
    void insert(String source, String lang, String new_translate);
    void delete(String k);
    Set unique();
    int numLen1();
    String translate(String text);
}
