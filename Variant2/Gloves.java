package ClassWork2.Alexeev_11302.Variant2;
public class Gloves extends AbstractSportAtributes{
    private String fightingArt;
    public Gloves(String name, int price, String subject, String fightingArt){
        super(name, price, subject);
        this.fightingArt = fightingArt;
    }
    public void showSpros(){
        System.out.println("Спрос уменьшился на 10 %");
    }
}