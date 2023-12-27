package Tasks11-21;

public class RationalVector2D {

    private RationalFraction x;
    private RationalFraction y;

    public RationalVector2D() throws Exception{
        this(new RationalFraction(), new RationalFraction());
    }
    public RationalVector2D(RationalFraction x, RationalFraction y){
        this.x = x;
        this.y = y;
    }
    public RationalVector2D add(RationalVector2D vector) throws Exception{
        RationalVector2D result = new RationalVector2D();
        result.x = this.x.add(vector.x);
        result.y = this.y.add(vector.y);
        return result;
    }
    public void add2(RationalVector2D vector) throws Exception{
        this.x.add2(vector.x);
        this.y.add2(vector.y);
    }
    public String toString(){
        return "X = " + x.toString() + "Y = " + y.toString();
    }
    public double length() throws Exception{
        RationalFraction result = new RationalFraction();
        result = x.mult(x).add(y.mult(y));
        return result.getA() / result.getB();
    }
    public RationalFraction scalarProduct(RationalVector2D vector) throws Exception{ //x*x + y*y  a = (1/2, 2/3) b = (4/5, 8/13)
        //RationalFraction result = new RationalFraction();
        RationalFraction result = this.x.mult(vector.x).add(this.y.mult(vector.y));
        return result;
    }
    public boolean equals(RationalVector2D vector){
        return this.x.equals(vector.x) && this.y.equals(vector.y);
    }
}
