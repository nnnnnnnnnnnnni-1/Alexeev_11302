package Players;
public class HealerPlayer extends Player {
    private int healPoints;

    public HealerPlayer(String name, int maxHP) {
        super(name, maxHP);
    }

    public void heal(int p) {
        if (p <= healPoints) {
            setHp(getHp() + p);
            healPoints -= p;
        }
    }
}