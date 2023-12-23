package ClassWork2.Alexeev_11302.Variant2;
public abstract class AbstractSportAtributes{
    protected String name;
    protected double price;
    protected String subject;
    public AbstractSportAtributes(String name, int price, String subject){
        this.name = name;
        if (price > 0){
            this.price = price;
        }
        this.subject = subject;
    }
    public abstract void showSpros();
    public void priceGrowing(int procents){
        price = price * (1 + (double) procents / 100);
    }
    public void sale(int procents){
        price = price - price * (1 + (double) procents / 100);
    }

}