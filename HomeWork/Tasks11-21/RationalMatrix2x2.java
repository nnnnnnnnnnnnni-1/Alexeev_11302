package Tasks11-21;
public class RationalMatrix2x2{
    private RationalFraction[][] matrix = new RationalFraction[2][2];
    public RationalMatrix2x2() throws Exception{
        this(new RationalFraction(), new RationalFraction(), new RationalFraction(), new RationalFraction());
    }
    public RationalMatrix2x2(RationalFraction[][] matrix){
        this.matrix = matrix;
    }
    public RationalMatrix2x2(RationalFraction a, RationalFraction b, RationalFraction c, RationalFraction d){
        matrix[0][0] = a;
        matrix[0][1] = b;
        matrix[1][0] = c;
        matrix[1][1] = d;
    }
    public RationalMatrix2x2 add(RationalMatrix2x2 m) throws Exception{
        RationalMatrix2x2 result = new RationalMatrix2x2();
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++){
                result.matrix[i][j] = matrix[i][j].add(m.matrix[i][j]);
            }
        }
        return result;
    }
    public RationalMatrix2x2 mult(RationalMatrix2x2 m) throws Exception{
        RationalMatrix2x2 result = new RationalMatrix2x2();
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++){
                result.matrix[i][j] = matrix[i][0].mult(m.matrix[0][j]).add(matrix[i][1].mult(m.matrix[1][j]));
            }
        }
        return result;
    }
    public RationalFraction det() throws Exception{
        return matrix[0][0].mult(matrix[1][1]).sub(matrix[0][1].mult(matrix[1][0]));
    }
    public RationalVector2D multVector(RationalVector2D vector) throws Exception{
        RationalVector2D result = new RationalVector2D(matrix[0][0].mult(vector.getX()).add(matrix[0][1].mult(vector.getY())), matrix[1][0].mult(vector.getX()).add(matrix[1][1].mult(vector.getY())));
        return result;
    }

}