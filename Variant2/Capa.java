package ClassWork2.Alexeev_11302.Variant2;
public class Capa extends AbstractSportAtributes{
    protected String color;
    public Capa(String name, int price, String subject, String color){
        super(name, price, subject);
        this.color = color;
    }
    public void showSpros(){
        System.out.println("Спрос увеличился на 20 %");
    }
}