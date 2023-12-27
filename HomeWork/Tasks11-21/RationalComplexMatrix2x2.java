package Tasks11-21;
public class RationalComplexMatrix2x2{
    RationalComplexNumber[][] matrix = new RationalComplexNumber[2][2];
    public RationalComplexMatrix2x2() throws Exception{
        this(new RationalComplexNumber(), new RationalComplexNumber(), new RationalComplexNumber(), new RationalComplexNumber());
    }
    public RationalComplexMatrix2x2(RationalComplexNumber[][] matrix){
        this.matrix = matrix;
    }
    public RationalComplexMatrix2x2(RationalComplexNumber a, RationalComplexNumber b, RationalComplexNumber c, RationalComplexNumber d){
        matrix[0][0] = a;
        matrix[0][1] = b;
        matrix[1][0] = c;
        matrix[1][1] = d;
    }
    public RationalComplexMatrix2x2 add(RationalComplexMatrix2x2 m) throws Exception{
        RationalComplexMatrix2x2 result = new RationalComplexMatrix2x2();
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++){
                result.matrix[i][j] = matrix[i][j].add(m.matrix[i][j]);
            }
        }
        return result;
    }
    public RationalComplexMatrix2x2 mult(RationalComplexMatrix2x2 m) throws Exception{
        RationalComplexMatrix2x2 result = new RationalComplexMatrix2x2();
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++){
                result.matrix[i][j] = matrix[i][0].mult(m.matrix[0][j]).add(matrix[i][1].mult(m.matrix[1][j]));
            }
        }
        return result;
    }
    public RationalComplexNumber det() throws Exception{
        return matrix[0][0].mult(matrix[1][1]).sub(matrix[0][1].mult(matrix[1][0]));
    }
    public RationalComplexVector2D multVector(RationalComplexVector2D vector) throws Exception{
        RationalComplexVector2D result = new RationalComplexVector2D(matrix[0][0].mult(vector.getX()).add(matrix[0][1].mult(vector.getY())), matrix[1][0].mult(vector.getX()).add(matrix[1][1].mult(vector.getY())));
        return result;
    }

}