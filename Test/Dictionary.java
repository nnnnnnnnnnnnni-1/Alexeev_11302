package Test;

import java.util.HashSet;
import java.util.Set;

public class Dictionary implements IDictionary {
    private Node head;
    final private String lang;
    private Node current;
    public Dictionary(String lang){
        this.lang = lang;
    }
    public void insert(String source, String lang, String new_translate) {
        Node node = new Node(source, new_translate);
        if (head == null) {
            this.head = node;
        } else {
            this.current.next = node;
        }
        this.current = node;
    }

    public void delete(String k) {
        Node currentNode = head;
        Node previusNode = null;
        while (currentNode != null) {
            if (currentNode.getWord().equals(k)) {
                if (currentNode == head) {
                    head = head.next;
                } else {
                    previusNode.next = currentNode.next;
                }
                return;
            }
            previusNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    public Set unique() {
        Set<Node> set = new HashSet<>();
        Node current = head;
        while (current != null){
            set.add(current);
            current = current.next;
        }
        return set;
    }

    public int numLen1() {
        Node current = head;
        int result = 0;
        while(current != null){
            for (String translate : current.getTranslations()){ //проверка на условие для всех переводов слова
                if (!(Math.abs(current.getWord().length() - translate.length()) < 1)){
                    current = current.next;
                }
            }
            result++;
            current = current.next;
        }
        return result;
    }
    public void show() {
        Node current = head;
        while (current != null){
            System.out.println("Word: " + current.getWord());
            System.out.print(" Translations: ");
            for (String translation : current.getTranslations()){
                System.out.print(translation + " ");
            }
            System.out.println();
            current = current.next;
        }
    }
    public String getTranslate(String source){
        if(head == null) return source;
        Node current = head;
        while (current != null){
            if(current.getWord().equals(source)){
                return current.getTranslations()[0];
            }
            current = current.next;
        }
        return source;
    }

    public String translate(String text){
        StringBuilder translatedText = new StringBuilder();
        for(String word : text.split(" ")){
            translatedText.append(getTranslate(word)).append(" ");
        }
        return translatedText.toString();
    }

    public static void main(String[] args) {
        Dictionary d = new Dictionary("Eng");
        d.insert("Яблоко", "eng", "apple");
        d.insert("Яблоко", "eng", "aple");
        d.insert("планшет", "eng", "pad");
        d.insert("abcd", "eng", "abc");
        d.show();
//        d.delete("Яблоко");
//        d.show();
        System.out.println(d.numLen1());
    }
}
