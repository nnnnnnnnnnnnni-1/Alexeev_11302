package ClassWork2.Alexeev_11302;

public class Main {
    public static void main(String [] args){
        RationalFraction ration = new RationalFraction(3, 9);
        ration.reduce();

        System.out.println(ration.getA() + " " + ration.getB());
        System.out.println(ration.value());
        
        double[][] z = {{1.0, 2.0}, {3.0, 6.0}};
        double[][] s = {{2.0, 3.0}, {5.0, 7.0}};
        Matrix2x2 m = new Matrix2x2(z);
        m.equivalentDiagonal();
        
        System.out.println(m.matrix[0][0] + " " +m.matrix[0][1] + " " +m.matrix[1][0] + " " +m.matrix[1][1]);
    }
}
