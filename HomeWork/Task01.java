import java.util.Scanner;
class Task1{
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i <= n; i++){
            System.out.println();
            for (int j = 0; j < i; j++){
                System.out.print("*");
            }
        }
        System.out.println();
        for (int i = 0; i <= n; i++){
            System.out.println();
            for (int j = n; j > i; j--){
                System.out.print("*");
            }
        }
        for (int i = 0; i < n; i++){
            System.out.println("");
            for (int j = 0; j < n; j++){
                if (i > j){
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
        }
    }
}