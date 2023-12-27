package Tasks11-21;
public class RationalComplexNumber{
    private RationalFraction a; 
    private RationalFraction b; // complex part
    public RationalComplexNumber() throws Exception{
        this(new RationalFraction(), new RationalFraction());
    }
    public RationalComplexNumber(RationalFraction a, RationalFraction b){
        this.a = a;
        this.b = b;
    }
    public RationalComplexNumber add(RationalComplexNumber number) throws Exception{
        RationalComplexNumber result = new RationalComplexNumber(a.add(number.a), b.add(number.b));
        return result;
    }
    public RationalComplexNumber sub(RationalComplexNumber number) throws Exception{
        RationalComplexNumber result = new RationalComplexNumber(a.sub(number.a), b.sub(number.b));
        return result;
    }
    public RationalComplexNumber mult (RationalComplexNumber number) throws Exception{
        RationalComplexNumber result = new RationalComplexNumber(a.mult(number.a).sub(b.mult(number.b)), a.mult(number.b).add(b.mult(number.a)));
        return result;
    }
    public String toString(){
        if (b.getA() > 0 && b.getB() > 0 || b.getA() < 0 && b.getB() < 0 ){
            return a.toString() + " + i*" + b.toString();
        } else {
            return a.toString() + " - i*" + Math.abs(b.getA()) + "/" + Math.abs(b.getA());
        }
    }
}