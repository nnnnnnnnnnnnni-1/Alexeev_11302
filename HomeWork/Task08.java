import java.util.Scanner;
public class Task08{
    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int sost = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '('){
                sost++;
            } else if (str.charAt(i) == ')'){
                sost--;
            }
            if (sost < 0){
                System.out.println("false");
                break;
            }
        }
        if (sost == 0){
            System.out.println("true");
        }
    }
}