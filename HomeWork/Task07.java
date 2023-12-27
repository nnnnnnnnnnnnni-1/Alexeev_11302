import java.util.Scanner;
public class Task07 {
    public static boolean in(char x, char a, char b){
        return x >= a && x <= b;
    }
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int sost = 0;
        for (int i = 0; i<str.length(); i++){
            if (sost == -1){
                System.out.println("false");
                break;
            } else if (sost == 0){
                if (in(str.charAt(i), 'a', 'z')){
                    sost = 1;
                } else if (str.charAt(i) == '_') {
                    sost = 2;
                } else {
                    sost = -1;
                }
            } else if (sost == 1){
                if (in(str.charAt(i), 'a', 'z')|| in(str.charAt(i), 'A', 'Z')){
                    sost = 3;
                } else if (str.charAt(i) == '_' ){
                    sost = 2;
                } else if (in(str.charAt(i),'1','9')) {
                    sost = 1;
                } else {
                    sost = -1;
                }
            } else if (sost == 2){
                if (in(str.charAt(i), 'a', 'z')|| in(str.charAt(i), 'A', 'Z')){
                    sost = 3;
                } else if (str.charAt(i) == '_' ){
                    sost = 2;
                } else if (in(str.charAt(i),'1','9')) {
                    sost = 1;
                } else {
                    sost = -1;
                }
            }
        } 
        if (sost == 1 | sost == 3){
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}