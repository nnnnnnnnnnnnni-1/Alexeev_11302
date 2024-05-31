package HomeWork4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Node {
    String tag;
    String text;
    List<Node> children;
    Node parent;
    Map<String, String> attr;
    public Node(){
        this(null, null);
    }
    public Node(String tag, String text){
        this.tag = tag;
        this.text = text;
        children = new ArrayList<>();
        attr = new HashMap<>();
    }
    public void addChild(Node child) {
        child.parent = this;
        this.children.add(child);
    }
}
public class DomTree {
    private Node root;
    String meta;
    List<String> scriptCode;
    List<String> styleCode;
    public DomTree(String file) {
        this.scriptCode = new ArrayList<>();
        this.styleCode = new ArrayList<>();
        this.root = new Node("html", null);
        StringBuilder allHTML = new StringBuilder();
        try (BufferedReader bw = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bw.readLine()) != null) {
                allHTML.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (allHTML.length() > 0) {
            String tag = null;
            if (allHTML.toString().contains(">") && allHTML.toString().contains("<")) {
                tag = allHTML.substring(allHTML.indexOf("<")+1, allHTML.indexOf(">"));
                if (tag.equals("tbody")){
                    allHTML.delete(allHTML.indexOf("<tbody"), allHTML.indexOf("<tbody") + "<tbody".length());
                    if (allHTML.indexOf(">") - allHTML.indexOf("<") < 0){
                        allHTML.delete(allHTML.indexOf(">"), allHTML.indexOf(">")+1);
                    }
                    continue;
                }
                allHTML.delete(allHTML.indexOf("<"), allHTML.indexOf(">"));

            } else {
                allHTML.setLength(0);
                break;
            }//>e>
            if (tag.contains("style")){
                if (tag.equals("<style")){
                    tag = "style";
                }
                String text = allHTML.substring(allHTML.indexOf(">"), allHTML.indexOf("</style>")+1);
                styleCode.add(text);
                allHTML.delete(allHTML.indexOf(">"), allHTML.indexOf("</style")+1);
                allHTML.delete(allHTML.indexOf("/style"), allHTML.indexOf("/style")+5);
                allHTML.delete(allHTML.indexOf(">"), allHTML.indexOf(">")+1);
                stack.peek().addChild(new Node(tag, null).parent = stack.peek());
                continue;
            }
            String text = null;
            if (allHTML.indexOf(">") - allHTML.indexOf("<") < 0) {
                text = allHTML.substring(allHTML.indexOf(">") + 1, allHTML.indexOf("<"));
                allHTML.delete(allHTML.indexOf(">") + 1, allHTML.indexOf("<"));
                if (tag.contains("script")){
                    scriptCode.add(text);
                    text = null;
                }
                if (text != null) {
                    if (text.isEmpty()) {
                        text = null;
                    }
                }
            }
            if (allHTML.indexOf(">") - allHTML.indexOf("<") > 0) {

                allHTML.delete(allHTML.indexOf(">"), allHTML.indexOf(">") + 1);
            }
            if (tag.contains("meta")){
                this.meta = tag;
                continue;
            }
            //System.out.println(allHTML.toString());
            //System.out.println(tag);
            if (tag.charAt(0) != '/') {
                Node newNode = new Node(tag, text);
                stack.add(newNode);
            } else {
                if (!tag.contains(" ")) {
                    if (tag.contains(stack.peek().tag) || stack.peek().tag.contains(tag.replaceAll("/", ""))) {
                        Node node = stack.pop();
                        if (!stack.isEmpty()) {
                            stack.peek().addChild(node);
                            node.parent = stack.peek();
                        }
                    }
                } else {
                    if (tag.replaceAll(" ", "").contains(stack.peek().tag)
                            || stack.peek().tag.contains(tag.replaceAll(" ", "").replaceAll("/", ""))) {
                        Node node = stack.pop();
                        if (!stack.isEmpty()) {
                            stack.peek().addChild(node);
                            node.parent = stack.peek();
                        }
                    }
                }
            }
        }
    }
    public Node getRoot(){
        return root;
    }

    public static void main(String[] args) {
        DomTree tree = new DomTree("C:\\Users\\admin\\Downloads\\NeverGonnaGiveYouUp.html");
//"C:\\Users\\admin\\Downloads\\NeverGonnaGiveYouUp.html"
    // "src\\HomeWork4\\html.html"
        tree.bypass(tree.getRoot());

    }
    public void bypass(Node root){
        //System.out.println(root.tag);
        if (root.text != null) {
            System.out.println(root.text);
        }
        if (!root.children.isEmpty()) {
            for (int j = 0; j < root.children.size(); j++) {
                bypass(root.children.get(j));
            }
        }
    }
}
