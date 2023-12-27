import java.util.Scanner;
class Task04{
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        final double x = scanner.nextDouble();
        int sign = 1;
        int fact = 1;
        int i = 0;
        double deg = 1;
        double eps = 1e-5;
        double cos = 1.0;
        double slog = x;
        double absSlog = 1.0;
        while (absSlog - eps > 0){
            deg*=x;
            deg*=x;
            i++;
            fact*=i;
            i++;
            fact*=i;
            sign*=(-1);
            slog = sign * deg / fact;
            cos += slog;
            if (slog > 0){
                absSlog = slog;
            } else {
                absSlog = -1 * slog;
            }
        }
        System.out.println(cos);
        System.out.println(Math.cos(x));
    }
}