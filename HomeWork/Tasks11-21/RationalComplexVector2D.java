package Tasks11-21;
public class RationalComplexVector2D{
    private RationalComplexNumber x;
    private RationalComplexNumber y;
    public RationalComplexVector2D() throws Exception{
        this(new RationalComplexNumber(), new RationalComplexNumber());
    }
    public RationalComplexVector2D(RationalComplexNumber x, RationalComplexNumber y){
        this.x = x;
        this.y = y;
    }
    public RationalComplexNumber getX(){
        return x;
    }
    public RationalComplexNumber getY(){
        return y;
    }
    public RationalComplexVector2D add(RationalComplexVector2D vector) throws Exception{
        RationalComplexVector2D result = new RationalComplexVector2D(x.add(vector.x), y.add(vector.y));
        return result;
    }
    public String toString(){
        return "X = " + x.toString() + " Y = " + y.toString();
    }
    public RationalComplexNumber scalarProduct(RationalComplexVector2D vector) throws Exception{
        return x.mult(vector.x).add(y.mult(vector.y));
    }
}