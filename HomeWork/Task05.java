import java.util.Scanner;
class Task05{
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        final double x = scanner.nextDouble();
        double deg = x;
        double eps = 1e-10;
        double slog = 1;
        int i = 1;
        double ln = x;
        int sign = 1;
        double absSlog = slog;
        while (absSlog - eps > 0){
            deg *= x;
            i++;
            sign *= (-1);
            slog = (double) sign * deg / i;
            ln = ln + slog;
            if (slog > 0){
                absSlog = slog;
            } else {
                absSlog = -1 * slog;
            }
        }
        System.out.println(ln);
        System.out.println(Math.log(1 + x));
    }
}