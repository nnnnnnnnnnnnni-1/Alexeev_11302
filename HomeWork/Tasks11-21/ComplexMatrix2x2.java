package Tasks11-21;
public class ComplexMatrix2x2{
    private ComplexNumber[][] matrix = new ComplexNumber[2][2];
    public ComplexMatrix2x2(){
        this(new ComplexNumber(), new ComplexNumber(), new ComplexNumber(), new ComplexNumber());
    }
    public ComplexMatrix2x2(ComplexNumber[][] matrix){
        this.matrix = matrix;
    }
    public ComplexMatrix2x2(ComplexNumber a, ComplexNumber b, ComplexNumber c, ComplexNumber d){
        matrix[0][0] = a;
        matrix[0][1] = b;
        matrix[1][0] = c;
        matrix[1][1] = d;
    }
    public ComplexMatrix2x2 add(ComplexMatrix2x2 m){
        ComplexMatrix2x2 result = new ComplexMatrix2x2();
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++){
                result.matrix[i][j] = matrix[i][j].add(m.matrix[i][j]);
            }
        }
        return result;
    }
    public ComplexMatrix2x2 mult(ComplexMatrix2x2 m){
        ComplexMatrix2x2 result = new ComplexMatrix2x2();
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++){
                result.matrix[i][j] = matrix[i][0].mult(m.matrix[0][j]).add(matrix[i][1].mult(m.matrix[1][j]));
            }
        }
        return result;
    }
    public ComplexNumber det(){
        return matrix[0][0].mult(matrix[1][1]).sub(matrix[0][1].mult(matrix[1][0]));
    }
    public ComplexVector2D multVector(ComplexVector2D vector){
        ComplexVector2D result = new ComplexVector2D(matrix[0][0].mult(vector.getX()).add(matrix[0][1].mult(vector.getY())), matrix[1][0].mult(vector.getX()).add(matrix[1][1].mult(vector.getY())));
        return result;
    }
}