import java.util.Scanner;
class Task09{
    public static boolean in(char  x, char a, char b){
        return (a <= x && b >= x);
    }
    public static boolean sign(char x){
        return x == '+' || x == '-' || x == '*' || x == '/';
    }
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int sost = 0;
        for (int i = 0; i < str.length(); i++){
            if (sost == -1){
                System.out.println(false);
                break;
            } else if (sost == 0){
                if (in(str.charAt(i), 'a', 'z')){
                    sost = 1;
                } else {
                    sost = -1;
                }
            } else if (sost == 1){
                if (in(str.charAt(i), 'a', 'z') || in(str.charAt(i), 'A', 'Z')){
                    sost = 1;
                } else if (str.charAt(i) == ' '){
                    sost = 2;
                } else {
                    sost = -1;
                }
            } else if (sost == 2){
                if (str.charAt(i) == '='){
                    sost = 3;
                } else {
                    sost = -1;
                }
            } else if (sost == 3){
                if (str.charAt(i) == ' '){
                    sost = 4;
                } else {
                    sost = -1;
                }
            } else if (sost == 4){
                if (in(str.charAt(i), 'a', 'z')){
                    sost = 5;
                } else if (in(str.charAt(i), '1', '9')){
                    sost = 6;
                } else if (str.charAt(i) == '-') {
                    sost = 7;
                } else {
                    sost = -1;
                }
            } else if (sost == 5){
                if (in(str.charAt(i), 'a', 'z') || in(str.charAt(i), 'A', 'Z')){
                    sost = 5;
                } else if (str.charAt(i) == ' '){
                    sost = 8;
                } else {
                    sost = -1;
                }
            } else if (sost == 6){
                if (in(str.charAt(i), '1', '9')){
                    sost = 6;
                } else if (str.charAt(i) == ' '){
                    sost = 8;
                } else {
                    sost = -1;
                }
            } else if (sost == 7){
                if (in(str.charAt(i), '1', '9')){
                    sost = 6;
                } else {
                    sost = -1;
                }
            } else if (sost == 8){
                if (sign(str.charAt(i))){
                    sost = 9;
                } else {
                    sost = -1;
                }
            } else if (sost == 9){
                if (str.charAt(i) == ' '){
                    sost = 10;
                } else {
                    sost = -1;
                }
            } else if (sost == 10){
                if (in(str.charAt(i), '1','9')){
                    sost = 11;
                } else if (in(str.charAt(i), 'a', 'z')){
                    sost = 12;
                } else {
                    sost = -1;
                }
            } else if (sost == 11){
                if (in(str.charAt(i), '1','9')){
                    sost = 11;
                } else {
                    sost = -1;
                }
            } else if (sost == 12){
                if (in(str.charAt(i), 'a', 'z') || in(str.charAt(i), 'A', 'Z')){
                    sost = 12;
                } else {
                    sost = -1;
                }
            }
            
        }
        if (sost == 11 || sost == 12){
            System.out.println("true");
        }
    }
}