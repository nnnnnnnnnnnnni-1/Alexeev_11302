package ClassWork2;

public class ComplexNumber {

    private double a;
    private double b; // complex part

    public ComplexNumber(double a, double b){
        a = this.a;
        b = this.b;
    }
    public ComplexNumber(){
        this(0.0,0.0);
    }
    public ComplexNumber add(ComplexNumber number){
        ComplexNumber result = new ComplexNumber();
        result.a = this.a + number.a;
        result.b = this.b + number.b;
        return result;
    }
    public void add2(ComplexNumber number){
        this.a = this.a + number.a;
        this.b = this.b + number.b;
    }
    public ComplexNumber sub(ComplexNumber number){
        ComplexNumber result = new ComplexNumber();
        result.a = this.a - number.a;
        result.b = this.b - number.b;
        return result;
    }
    public void sub2(ComplexNumber number){
        this.a = this.a - number.a;
        this.b = this.b - number.b;
    }
    public ComplexNumber multNumber(double x){
        ComplexNumber result = new ComplexNumber();
        result.a = this.a * x;
        result.b = this.b * x;
        return result;
    }
    public void multNumber2(double x){
        this.a*=x;
        this.b*=x;
    }
    public double length(){
        return Math.sqrt(a*a + b*b);
    }
    public String toString(){
        if (b>0){
            return a + " + i*" + b;
        } else {
            return a + " - i*" + b;
        }
    }
    public double arg(){
        if (a>0 & b>=0){
            return Math.atan(b/a);
        } else if (a>0 & b<0){
            return Math.atan(b/a);
        } else if (a<0 & b>=0){
            return (Math.PI + Math.atan(b/a));
        } else if (a<0 & b<0){
            return (-1*Math.PI + Math.atan(b/a));
        } else if (a == 0 & b>0){
            return Math.PI/2;
        } else if (a == 0 & b<0){
            return (-1*Math.PI/2);
        } else if (a==0 & b==0){
            return 0.0;
        }
        return 0.0;
    }
    public ComplexNumber pow(double x){ //z^n = (sin(f)^n )
        ComplexNumber result = new ComplexNumber();
        result.a = Math.pow(this.length(), x) * Math.cos(x*this.arg());
        result.b = Math.pow(this.length(), x) * Math.sin(x*this.arg());
        return result;
    }
    public boolean equals(ComplexNumber number){
        double eps = 1e-10;
        return (Math.abs(this.a - number.a) < eps & Math.abs(this.b - number.b) < eps);
    }
    public double getA(){
        return a;
    }
    public double getB(){
        return b;
    }
}


/*  We want to present you an App “CheapTaxSearcher”, which main goal is to help people
 to move around the city by finding the cheapest way in all taxi aggregators that exist 
 in the city. Our app represents including totality of functions that have simple taxi aggregators:
1. Quick and easy booking: Simply enter your location and destination, and our app 
will instantly connect you with the nearest available taxi.
2. Real-time tracking: You can track the location of your taxi in real-time, so you'll know exactly 
when it will arrive.
3. Secure payment options: Our app offers secure payment options, so you can pay for your ride without
 having to worry about carrying cash. Also app has a good unique feature that let choose people different 
 pay methods (wallet, cripto and s.o.), not only bank cards.
4. Driver ratings and reviews: You can view driver ratings and reviews from other users, so you can
 choose a driver with a good reputation.
5. 24/7 customer support: If you have any questions or issues, our customer support team is available
 24/7 to assist you.
    Our main function is searching the cheapest way of driving, so in interface it has:
6. Variants of driving from different agregators with prices
7. A lot of bonuses.
    App's target audience are citizens of big cities and buzy people. 
Besides economy of money it helps to save time that people could spend in process of 
searching the cheapest way to move from one point to another in different taxi-apps.

	*/
