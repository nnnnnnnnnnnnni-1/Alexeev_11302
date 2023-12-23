package ClassWork2.Alexeev_11302.Variant2;
public class Sportzal{
    protected int squaremetres; //вместимость спортивного зала в квадратных метрах
    protected String typeOfSport;
    protected boolean isThereShower; //есть ли душ

    public Sportzal(int squaremetres, String typeOfSport, boolean isThereShower){
        this.squaremetres = squaremetres;
        this.typeOfSport = typeOfSport;
        this.isThereShower = isThereShower;
    }

    public String whichSport(){
        return typeOfSport;
    }

}