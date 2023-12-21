package ClassWork2.Alexeev_11302;
public class Vector2D{
    private double x;
    private double y;

    public Vector2D(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Vector2D(){
        this(0,0);
    }

    public String toString(){
        return "X = " + x + " Y = " + y;
    }

    public Vector2D add(Vector2D vector){
        Vector2D equels = new Vector2D();

        equels.x = this.x + vector.x;
        equels.y = this.y + vector.y;
        
        return equels;
    }
    public void add2(Vector2D vector){
        this.x = this.x + vector.x;
        this.y = this.y + vector.y;
    }

    public Vector2D sub(Vector2D vector){
        Vector2D equels = new Vector2D();

        equels.x = this.x - vector.x;
        equels.y = this.x - vector.y;

        return equels;
    }

    public void sub2(Vector2D vector){
        this.x = this.x - vector.x;
        this.y = this.y - vector.y;
    }

    public Vector2D mult(double num){
        Vector2D equels = new Vector2D();

        equels.x = this.x * num;
        equels.y = this.y * num;

        return equels;
    }

    public void mult2(double num){
        this.x = this.x * num;
        this.y = this.y * num;
    }

    public double length(){
        return Math.sqrt((Math.pow(this.x, 2.0)+Math.pow(this.y, 2.0)));
    }

    public double scalarProduct(Vector2D vector){
        double equels;
        equels = this.x * vector.x + this.y * vector.y;
        return equels;
    }

    public double cos(Vector2D vector){
        return this.scalarProduct(vector)/(vector.length() + this.length());
    }

    public boolean equals(Vector2D vector){
        double eps = 1e-9;
        return (Math.abs(this.x - vector.x) < eps && Math.abs(this.y - vector.y) < eps);
    }
    


}
/*что такое игровое поле, как кодируется и так далее  */