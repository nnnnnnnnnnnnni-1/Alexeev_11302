package Test2variant3;
public class Task2{
    public static void main (String [] args){
        double[][] array = {{1, 2, 3},
                            {1, 3, 5},
                            {4, 3, 9}};
        Task2 t = new Task2();
        double[][] tri = t.gauss(array);
        for (int i = 0; i < tri.length; i++){
            System.out.println();
            for (int j = 0; j < tri.length; j++){
                System.out.print(tri[i][j] + " ");
            }
            
        }
    }
    public double det(double[][] matrix){
        Task2 t = new Task2();
        double[][] m = t.gauss(matrix);
        int det = 1;
        for (int i = 0; i < matrix.length; i++){
            det *= m[i][i];
        }
        return det;
    }

    public double[][] gauss (double[][] m){
        double[][] matrix = m;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k < n; k++) {
                double coef = -(matrix[k][i] / matrix[i][i]);
                if (coef % 2 != 1 && coef % 2 != 0) {
                    double temp = matrix[i][i];
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] *= matrix[k][i];
                        matrix[k][j] *= temp;
                    }
                    coef = -1 *(matrix[k][i] / matrix[i][i]);
                }
                for (int j = i; j < n; j++) {
                    if (i == j) {
                        matrix[k][j] = 0;
                    } else {
                        matrix[k][j] += coef * matrix[i][j];
                    }
                }
            }
        }
        return matrix;
    }
    public double[] kramer(double[][] matrix, double[] coefficientsB){
        double[] deltas = new double[matrix.length];
        double [][] changing = matrix;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){

            }
        }
    }
}