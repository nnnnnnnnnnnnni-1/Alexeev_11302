package ClassWork2.Alexeev_11302.Variant2;
public class UltimateZal extends Sportzal{ //универсальный спортзал
    public UltimateZal(int squaremetres, String typeOfSport, boolean isThereShower){
        super(squaremetres, typeOfSport, isThereShower);
    }
    @Override
    public String whichSport(){
        return "Это универсальный зал для любого вида спорта";
    }
}