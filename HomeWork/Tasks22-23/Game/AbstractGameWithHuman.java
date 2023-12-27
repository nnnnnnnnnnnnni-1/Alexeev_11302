package Game;
import Utilits.Log;
import Players.*;
public class AbstractGameWithHuman extends AbstractGame{

    public AbstractGameWithHuman(int maxHP) {
            super(maxHP);
            System.out.println("Введите имя второго игрока");
            p2 = new Player(in.nextLine(), maxHP);
    }

    public void gameProcess() {
//        AbstractPlayer kicker = p1;
//        AbstractPlayer enemy = p2;

        Player kicker = (Player) p1;
        Player enemy = (Player) p2;

        while (p1.alive() && p2.alive()) {
            Log.out(kicker + " is going to kick " +
                    enemy + " with force: ");
            int f = in.nextInt(); // f - force
            while (!(1 <= f && f <= 10)) {
                Log.out("Некорректный ввод");
                f = in.nextInt(); // f - force
            }
            boolean result = kicker.kick(enemy, f);
            if (result) {
                Log.out("Success, " + enemy.getName() + "'s hp is " + enemy.getHp() + ".");
            } else {
                SLog.out("Missed");
            }
            Player swap = kicker;
            kicker = enemy;
            enemy = swap;
        }


    }


}