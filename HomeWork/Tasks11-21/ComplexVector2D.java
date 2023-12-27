package Tasks11-21;;

public class ComplexVector2D {
    private ComplexNumber x;
    private ComplexNumber y;
    public ComplexVector2D(ComplexNumber x, ComplexNumber y){
        this.x = x;
        this.y = y;
    }
    public ComplexVector2D(){
        this(new ComplexNumber(), new ComplexNumber());
    }
    public ComplexNumber getX(){
        return x;
    }
    public ComplexNumber getY(){
        return y;
    }
    public ComplexVector2D add(ComplexVector2D vector){
        ComplexVector2D result = new ComplexVector2D(this.x.add(vector.x), this.y.add(vector.y));
        return result;
    }
    public void add2(ComplexVector2D vector){
        x.add2(vector.x);
        y.add2(vector.y);
    }
    public String toString(){
        return "X = " + x.toString() + " Y = " + y.toString();
    }
    public ComplexNumber scalarProduct(ComplexVector2D vector){
        ComplexNumber result = new ComplexNumber(x.mult(vector.x).add(y.mult(vector.y)).getA(), x.mult(vector.x).add(y.mult(vector.y)).getB());
        return result;
    }
    public boolean equals(ComplexVector2D vector){
        return x.equals(vector.x) & y.equals(vector.y);
    }
}
