import java.util.Scanner;
class Task2{
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = 2*n-2;
        int b = 2*n-1;
        for (int i = 0; i < n; i++){
            System.out.println();
            int j = i;
            while (j < a+1){
                System.out.print(" ");
                j++;
            }
            j--;
            while (j < b){
                System.out.print("*");
                j++;
            }
            b+=2;
        }
        int c = 1;
        a = n-1;
        b-=2*n;
        for (int i = 0; i < n; i++){
            System.out.println();
            for (int j = 0; j < a; j++){
                System.out.print(" ");
            }
            for (int j = 0; j < c; j++){
                System.out.print("*");
            }
            for (int j = 0; j < b; j++){
                System.out.print(" ");
            }
            for (int j = 0; j < c; j++){
                System.out.print("*");
            }
            a--;
            b-=2;
            c+=2;
        }
    }
}