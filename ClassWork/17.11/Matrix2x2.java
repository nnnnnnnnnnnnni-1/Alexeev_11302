package ClassWork2.Alexeev_11302;

public class Matrix2x2 {
    public double[][] matrix = new double[2][2];
    public Matrix2x2(){
        this(0.0);
    }
    public Matrix2x2(double x){
        this.matrix[0][0] = x;
        this.matrix[0][1] = x;
        this.matrix[1][0] = x;
        this.matrix[1][1] = x;
    }
    public Matrix2x2(double[][] matrix) {
        this.matrix = matrix;
    }
    public Matrix2x2(double x, double y, double z, double t){
        this.matrix[0][0] = x;
        this.matrix[0][1] = y;
        this.matrix[1][0] = z;
        this.matrix[1][1] = t;
    }
    public double[][] get(){
        return matrix;
    }
    public Matrix2x2 add(Matrix2x2 m){
        Matrix2x2 result = new Matrix2x2();
        result.matrix[0][0] = this.matrix[0][0] + m.matrix[0][0];
        result.matrix[0][1] = this.matrix[0][1] + m.matrix[0][1];
        result.matrix[1][0] = this.matrix[1][0] + m.matrix[1][0];
        result.matrix[1][1] = this.matrix[1][1] + m.matrix[1][1];
        return result;
    }
    public void add2(Matrix2x2 m){
        this.matrix[0][0] = this.matrix[0][0] + m.matrix[0][0];
        this.matrix[0][1] = this.matrix[0][1] + m.matrix[0][1];
        this.matrix[1][0] = this.matrix[1][0] + m.matrix[1][0];
        this.matrix[1][1] = this.matrix[1][1] + m.matrix[1][1];
    }
    public Matrix2x2 sub(Matrix2x2 m){
        Matrix2x2 result = new Matrix2x2();
        result.matrix[0][0] = this.matrix[0][0] - m.matrix[0][0];
        result.matrix[0][1] = this.matrix[0][1] - m.matrix[0][1];
        result.matrix[1][0] = this.matrix[1][0] - m.matrix[1][0];
        result.matrix[1][1] = this.matrix[1][1] - m.matrix[1][1];
        return result;
    }
    public void sub2(Matrix2x2 m){
        this.matrix[0][0] = this.matrix[0][0] - m.matrix[0][0];
        this.matrix[0][1] = this.matrix[0][1] - m.matrix[0][1];
        this.matrix[1][0] = this.matrix[1][0] - m.matrix[1][0];
        this.matrix[1][1] = this.matrix[1][1] - m.matrix[1][1];
    }
    public Matrix2x2 multNumber(double x){
        Matrix2x2 result = new Matrix2x2();
        result.matrix[0][0] *= x;
        result.matrix[0][1] *= x;
        result.matrix[1][0] *= x;
        result.matrix[1][1] *= x;
        return result;
    }
    public void multNumber2(double x){
        this.matrix[0][0] *= x;
        this.matrix[0][1] *= x;
        this.matrix[1][0] *= x;
        this.matrix[1][1] *= x;
    }
    public Matrix2x2 mult(Matrix2x2 m){
        Matrix2x2 result = new Matrix2x2();
        result.matrix[0][0] = this.matrix[0][0] * m.matrix[0][0] + this.matrix[0][1] * m.matrix[1][0]; //right
        result.matrix[0][1] = this.matrix[0][0] * m.matrix[0][1] + this.matrix[0][1] * m.matrix[1][1];
        result.matrix[1][0] = this.matrix[1][0] * m.matrix[0][0] + this.matrix[1][0] * m.matrix[1][0];
        result.matrix[1][1] = this.matrix[1][0] * m.matrix[0][1] + this.matrix[1][1] * m.matrix[1][1];
        return result;
    }
    public void mult2(Matrix2x2 m){
        this.matrix[0][0] = this.matrix[0][0] * m.matrix[0][0] + this.matrix[0][1] * m.matrix[1][0]; //right
        this.matrix[0][1] = this.matrix[0][0] * m.matrix[0][1] + this.matrix[0][1] * m.matrix[1][1];
        this.matrix[1][0] = this.matrix[1][0] * m.matrix[0][0] + this.matrix[1][0] * m.matrix[1][0];
        this.matrix[1][1] = this.matrix[1][0] * m.matrix[0][1] + this.matrix[1][1] * m.matrix[1][1];
    }
    public double det(){
        return matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0];
    }
    public void transpon(){
        double a = matrix[0][1];
        matrix[0][1] = matrix[1][0];
        matrix[1][0] = a;
    }
    public Matrix2x2 invereMatrix(){
        Matrix2x2 m = new Matrix2x2();
        if (m.det()!=0){
            m.matrix[0][0] = this.matrix[1][1]/this.det();
            m.matrix[0][1] = -1*this.matrix[1][0]/this.det();
            m.matrix[1][0] = this.matrix[0][1]/this.det();
            m.matrix[1][1] = -1*this.matrix[1][1]/this.det();
            m.transpon();
            return m;
        } else {
            System.out.println("Не обратима");
        }
        return null;
    }
    public Matrix2x2 equivalentDiagonal() {
        Matrix2x2 m = new Matrix2x2();
        m.matrix = this.matrix;
        m.matrix[1][0] -= this.matrix[0][0] * this.matrix[1][0] / this.matrix[0][0];
        m.matrix[1][1] -= this.matrix[0][0] * this.matrix[1][0] / this.matrix[0][0];
        transpon();
        m.matrix[1][0] -= m.matrix[0][0] * m.matrix[1][0] / m.matrix[0][0];
        m.matrix[1][1] -= m.matrix[0][0] * m.matrix[1][0] / m.matrix[0][0];
        m.transpon();
        return m;
    }
}
