package CW2;

public class BirthData {
    private char gender;
    private byte plural;
    private byte age;
    private String race;
    private byte parity;
    private boolean married;
    private short birthWeight;
    private byte smokeN;
    private byte drinkN;
    private boolean firstep;
    private boolean welfare;
    private boolean smoker;
    private boolean drinker;
    private short wpre;
    private short wgain;
    private byte education;
    private byte gestation;


    public BirthData(char gender, byte plural, byte age,
                     String race, byte parity, boolean married,
                     short birthWeight, byte smokeN, byte drinkN,
                     boolean firstep, boolean welfare, boolean smoker,
                     boolean drinker, short wpre, short wgain,
                     byte education, byte gestation) {
        this.gender = gender;
        this.plural = plural;
        this.age = age;
        this.race = race;
        this.parity = parity;
        this.married = married;
        this.birthWeight = birthWeight;
        this.smokeN = smokeN;
        this.drinkN = drinkN;
        this.firstep = firstep;
        this.welfare = welfare;
        this.smoker = smoker;
        this.drinker = drinker;
        this.wpre = wpre;
        this.wgain = wgain;
        this.education = education;
        this.gestation = gestation;
    }
    public String getRace(){
        return race;
    }
    public short getBirthWeight(){
        return birthWeight;
    }

    public boolean isSmoker() {
        return smoker;
    }

    public byte getGestation() {
        return gestation;
    }

    public byte getEducation() {
        return education;
    }
}
