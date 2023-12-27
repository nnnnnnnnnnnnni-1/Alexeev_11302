import java.util.Scanner;
class Task03{
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        final double x = scanner.nextDouble();
        int sign = 1;
        int fact = 1;
        int i = 1;
        double deg = x;
        double eps = 1e-5;
        double sin = x;
        double slog = x;
        double absSlog = 1.0;
        while(absSlog - eps > 0){
            deg*=x;
            deg*=x;
            i+=1;
            fact*=i;
            i+=1;
            fact*=i;
            sign*=(-1);
            slog = (double) sign * deg / fact;
            sin += slog;
            if (slog > 0){
                absSlog = slog;
            } else {
                absSlog = -1 * slog;
            }
        }
        System.out.println(sin);
        System.out.println(Math.sin(x));
    }
}