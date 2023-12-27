package Tasks11-21;
class ZeroDenomException extends Exception{

}
public class RationalFraction {
    
    private int a;
    private int b;

    public RationalFraction() throws Exception{
        this(0,27);
    }

    public RationalFraction(int a, int b) throws Exception {
        if (b == 0){
            throw new ZeroDenomException();
        }
        this.a = a;
        this.b = b;
    }

    public int getA(){
        return a;
    }
    public int getB(){
        return b;
    }

    public void reduce(){
        int c;
        int ch = a;
        int zn = b;
        while (ch!=0 && zn!=0){
            if (ch>zn){
                ch = ch%zn;
            } else {
                zn = zn%ch;
            }
        }
        c = ch + zn;
        a = a/c;
        b = b/c;
    }
    public RationalFraction add(RationalFraction fraction) throws Exception {
        RationalFraction result;
        if (this.b == fraction.getB()){
            result = new RationalFraction(this.a + fraction.getA(), this.b); //    a/b + c/d   =   (ad + cb)/bd
        } else {
            result = new RationalFraction(this.a * fraction.getB() + this.b * fraction.getA(), this.b * fraction.getB());
        }
        result.reduce();
        return result;
    }
    public void add2(RationalFraction fraction){
        if (this.b == fraction.b){
            this.a = this.a + fraction.b; //    a/b + c/d   =   (ad + cb)/bd
        } else {
            this.b = this.b * fraction.b;
            this.a = this.a * fraction.b + fraction.a * this.b;
            this.reduce();
        }
    }
    public RationalFraction sub (RationalFraction fraction) throws Exception{
        RationalFraction result = new RationalFraction();
        if (this.b == fraction.b){
            result.a = this.a - fraction.a;
        } else {
            result.b = this.b * fraction.b;
            result.a = this.a * fraction.b - fraction.a * this.b;
            result.reduce();
        }
        return result;
    }
    public void sub2(RationalFraction fraction){
        if (this.b == fraction.b){
            this.a = this.a - fraction.b; //    a/b + c/d   =   (ad + cb)/bd
        } else {
            this.b = this.b * fraction.b;
            this.a = this.a * fraction.b - fraction.a * this.b;
            this.reduce();
        }
    }
    public RationalFraction mult(RationalFraction fraction) throws Exception{
        RationalFraction result = new RationalFraction();
        result.a = this.a * fraction.a;
        result.b = this.b * fraction.b;
        return result;
    }
    public void mult2(RationalFraction fraction){
        this.a = this.a * fraction.a;
        this.b = this.b * fraction.b;
    }

    public RationalFraction div(RationalFraction fraction) throws Exception{
        RationalFraction result = new RationalFraction();
        result.a = this.a * fraction.b;
        result.b = this.b * fraction.a;
        return result;
    }
    public void div2(RationalFraction fraction){

        this.a = this.a * fraction.b;
        this.b = this.b * fraction.a;
    }

    public String toString(){
        if (a > 0 && b > 0 || a < 0 && b < 0){
            return a + "/" + b;
        } else {
            return "-" + a + "/" + b;
        }
    }
    public boolean equals(RationalFraction fraction){
        this.reduce();
        fraction.reduce();
        double eps = 1e-10;
        return ((double)(Math.abs(this.a - fraction.a)) < eps && (double)(Math.abs(this.b - fraction.b)) < eps);
    }
    public int numberPart(){
        return a%b;
    }
    //1/2 = 0.5  1/3 = 0.33 
    public double value(){
        return (double)(a/b);
    }
}
/*Основное внимание в книге уделяется небольшой по численности и пестрой по составу группе интеллигенции,
 профессионально занимающейся творческой деятельностью в области литературы и искусства. Это узкий слой,
 сосредоточенный главным образом в Москве и Ленинграде, тесно спаянный творческими, личными и семейными
  связями.

Художественная интеллигенция рассматривается с одной стороны как респондентская группа, отражавшая
 общественные настроения и мнения, с другой — как группа влияния, идеи и взгляды которой воспринимались
  широкой общественной средой. Особое внимание уделяется деятельности творческих союзов; властные структуры
   изучаются на уровне центральных партийных и государственных органов.
   
Описывается художественная интеллигенция в основном из Москвы и Ленинграда.
Эта группа, в частности творческие союзы, отражала всеобщие настроения, а также
идеями влияла на общественность. 
 
 
 */